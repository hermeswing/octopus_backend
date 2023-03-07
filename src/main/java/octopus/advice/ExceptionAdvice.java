package octopus.advice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.dao.CannotSerializeTransactionException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.advice.exception.CUserNotFoundException;
import octopus.backend.service.ResponseService;
import octopus.entity.CommonResult;

@RequiredArgsConstructor
@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {
    
    private final ResponseService responseService;
    
    private final MessageSourceAccessor messageSourceAccessor;
    
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult argumentException(HttpServletRequest request, IllegalArgumentException e) {
        // 예외 처리의 메시지를 MessageSource에서 가져오도록 수정
        return responseService.getFailResult(-1, getMessage("argumentException"));
    }
    
    @ExceptionHandler(CUserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(HttpServletRequest request, CUserNotFoundException e) {
        // 예외 처리의 메시지를 MessageSource에서 가져오도록 수정
        return responseService.getFailResult(-1, getMessage("userNotFound"));
    }
    
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult dataAccessException(HttpServletRequest request, DataAccessException e) {
        log.info("[ExceptionAdvice >> dataAccessException] getMessage :: {}", getErrMsg(e));
        
        if (e instanceof DuplicateKeyException) {
            return responseService.getFailResult(-1, getMessage("existingUser"));
        } else if (e instanceof DataAccessResourceFailureException) {
            return responseService.getFailResult(-1, getMessage("communicationError"));
        } else {
            return responseService.getFailResult(-1, getMessage("unKnown"));
        }
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
        // 예외 처리의 메시지를 MessageSource에서 가져오도록 수정
        return responseService.getFailResult(-1, getMessage("unKnown"));
    }
    
    // code정보에 해당하는 메시지를 조회합니다.
    private String getMessage(String code) {
        return getMessage(code, null);
    }
    
    // code정보, 추가 argument로 현재 locale에 맞는 메시지를 조회합니다.
    private String getMessage(String code, Object[] args) {
        return messageSourceAccessor.getMessage(code, args, LocaleContextHolder.getLocale());
    }
    
    /**
     * Error Message 처리
     *
     * @param ex
     * @return
     */
    public static Map<String, Object> getErrMsg(DataAccessException ex) {
        String errCode = "";
        String errMsg  = "";
        
        if (ex instanceof BadSqlGrammarException) {
            SQLException se = ((BadSqlGrammarException) ex).getSQLException();
            
            errCode = "" + se.getErrorCode();
            errMsg  = se.getMessage();
        } else if (ex instanceof InvalidResultSetAccessException) {
            SQLException se = ((InvalidResultSetAccessException) ex).getSQLException();
            
            errCode = "" + se.getErrorCode();
            errMsg  = se.getMessage();
        } else if (ex instanceof DuplicateKeyException) {
            // 고유성 제한 위반과 같은 데이터 삽입 또는 업데이트시 무결성 위반
            errCode = "-1";
            errMsg  = "데이터 중복오류";
        } else if (ex instanceof DataIntegrityViolationException) {
            // 고유성 제한 위반과 같은 데이터 삽입 또는 업데이트시 무결성 위반
            errCode = "-1";
            errMsg  = "등록된 데이터가 컬럼의 속성과 다릅니다. (길이, 속성, 필수입력항목 등..)";
        } else if (ex instanceof DataAccessResourceFailureException) {
            // 데이터 액세스 리소스가 완전히 실패했습니다 (예 : 데이터베이스에 연결할 수 없음)
            errCode = "-1";
            errMsg  = "데이터베이스 연결오류";
        } else if (ex instanceof CannotAcquireLockException) {
            
        } else if (ex instanceof DeadlockLoserDataAccessException) {
            // 교착 상태로 인해 현재 작업이 실패했습니다.
            errCode = "-1";
            errMsg  = "교착 상태로 인한 현재 작업 실패";
        } else if (ex instanceof CannotSerializeTransactionException) {
            errCode = "1";
            errMsg  = "직렬화 모드에서 트랜잭션을 완료 할 수 없음";
        } else {
            errCode = "-1";
            errMsg  = ex.getMessage();
        }
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errCode", errCode);
        map.put("errMsg", errMsg);
        
        return map;
    }
}
package octopus.backend.v1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.backend.service.ResponseService;
import octopus.backend.v1.dto.TCodeMDto;
import octopus.backend.v1.service.CodeService;
import octopus.entity.CommonResult;
import octopus.entity.TCodeM;
import octopus.model.ListResult;
import octopus.model.SingleResult;

@Slf4j
@Api(tags = { "1. 대분류 Code" })
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/master")
public class CodeMController {
    
    private final CodeService     codeService;
    private final ResponseService responseService;
    
    @ApiOperation(value = "대분류 단건 검색", notes = "대분류 코드를 조회합니다.")
    @GetMapping("/code/cd/{pCd}")
    public SingleResult<TCodeMDto> findCodeByCd(@ApiParam(value = "대분류 코드", required = true) @PathVariable String pCd) {
        return responseService.getSingleResult(codeService.findByCd(pCd));
    }
    
    @ApiOperation(value = "코드 목록 조회", notes = "모든 코드을 조회합니다.")
    @GetMapping("/codes")
    public ListResult<TCodeMDto> findAllCode() {
        return responseService.getListResult(codeService.findAllCd());
    }
    
    @ApiOperation(value = "코드 저장", notes = "코드 정보를 저장합니다.")
    @PostMapping("/code")
    public SingleResult<String> save(
            @ApiParam(value = "대분류 코드", required = true) @RequestParam(required = true) String pCd,
            @ApiParam(value = "대분류코드명", required = true) @RequestParam(required = true) String pCdNm,
            @ApiParam(value = "사용여부", required = true) @RequestParam(required = true) String useYn,
            @ApiParam(value = "문자옵션1", required = false) @RequestParam(required = false) String wdOptNm1,
            @ApiParam(value = "문자옵션2", required = false) @RequestParam(required = false) String wdOptNm2,
            @ApiParam(value = "문자옵션3", required = false) @RequestParam(required = false) String wdOptNm3,
            @ApiParam(value = "문자옵션4", required = false) @RequestParam(required = false) String wdOptNm4,
            @ApiParam(value = "문자옵션5", required = false) @RequestParam(required = false) String wdOptNm5,
            @ApiParam(value = "슷지옵션1", required = false) @RequestParam(required = false) String numOptNm1,
            @ApiParam(value = "슷지옵션2", required = false) @RequestParam(required = false) String numOptNm2,
            @ApiParam(value = "슷지옵션3", required = false) @RequestParam(required = false) String numOptNm3,
            @ApiParam(value = "슷지옵션4", required = false) @RequestParam(required = false) String numOptNm4,
            @ApiParam(value = "슷지옵션5", required = false) @RequestParam(required = false) String numOptNm5,
            @ApiParam(value = "비고", required = false) @RequestParam(required = false) String rmk) {
        
        TCodeMDto tCodeMDto = TCodeMDto.builder().pCd(pCd).pCdNm(pCdNm).useYn(useYn).rmk(rmk).wdOptNm1(wdOptNm1)
                .wdOptNm2(wdOptNm2).wdOptNm3(wdOptNm3).wdOptNm4(wdOptNm4).wdOptNm5(wdOptNm5).numOptNm1(numOptNm1)
                .numOptNm2(numOptNm2).numOptNm3(numOptNm3).numOptNm4(numOptNm4).numOptNm5(numOptNm5).build();
        
        log.debug("tCodeMDto :: {}", tCodeMDto);
        
        TCodeM tCodeM = codeService.save(tCodeMDto);
        
        return responseService.getSingleResult(tCodeM.getPCd());
    }
    
    @ApiOperation(value = "코드 수정", notes = "코드 정보를 수정합니다.")
    @PutMapping("/code")
    public SingleResult<String> update(
            @ApiParam(value = "대분류 코드", required = true) @RequestParam(required = true) String pCd,
            @ApiParam(value = "대분류코드명", required = true) @RequestParam(required = true) String pCdNm,
            @ApiParam(value = "사용여부", required = true) @RequestParam(required = true) String useYn,
            @ApiParam(value = "문자옵션1", required = false) @RequestParam(required = false) String wdOptNm1,
            @ApiParam(value = "문자옵션2", required = false) @RequestParam(required = false) String wdOptNm2,
            @ApiParam(value = "문자옵션3", required = false) @RequestParam(required = false) String wdOptNm3,
            @ApiParam(value = "문자옵션4", required = false) @RequestParam(required = false) String wdOptNm4,
            @ApiParam(value = "문자옵션5", required = false) @RequestParam(required = false) String wdOptNm5,
            @ApiParam(value = "슷지옵션1", required = false) @RequestParam(required = false) String numOptNm1,
            @ApiParam(value = "슷지옵션2", required = false) @RequestParam(required = false) String numOptNm2,
            @ApiParam(value = "슷지옵션3", required = false) @RequestParam(required = false) String numOptNm3,
            @ApiParam(value = "슷지옵션4", required = false) @RequestParam(required = false) String numOptNm4,
            @ApiParam(value = "슷지옵션5", required = false) @RequestParam(required = false) String numOptNm5,
            @ApiParam(value = "비고", required = false) @RequestParam(required = false) String rmk) {
        
        TCodeMDto tCodeMDto = TCodeMDto.builder().pCd(pCd).pCdNm(pCdNm).useYn(useYn).rmk(rmk).wdOptNm1(wdOptNm1)
                .wdOptNm2(wdOptNm2).wdOptNm3(wdOptNm3).wdOptNm4(wdOptNm4).wdOptNm5(wdOptNm5).numOptNm1(numOptNm1)
                .numOptNm2(numOptNm2).numOptNm3(numOptNm3).numOptNm4(numOptNm4).numOptNm5(numOptNm5).build();
        
        log.debug("tCodeMDto :: {}", tCodeMDto);
        
        codeService.update02(tCodeMDto);
        
        return responseService.getSingleResult("성공");
    }
    
    @ApiOperation(value = "코드 삭제", notes = "코드을 삭제합니다.")
    @DeleteMapping("/code/{pCd}")
    public CommonResult delete(@ApiParam(value = "대분류 코드", required = true) @RequestParam(required = true) String pCd) {
        
        TCodeMDto tCodeMDto = TCodeMDto.builder().pCd(pCd).useYn("N").build();
        
        codeService.delete(tCodeMDto);
        
        return responseService.getSuccessResult();
    }
}

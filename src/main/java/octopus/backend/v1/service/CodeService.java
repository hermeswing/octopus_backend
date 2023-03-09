package octopus.backend.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.backend.v1.dao.CodeJpaDao;
import octopus.backend.v1.dto.TCodeMDto;
import octopus.entity.TCodeM;

@Service
@AllArgsConstructor
@Slf4j
public class CodeService {
    private CodeJpaDao codeJpaDao;
    
    @Transactional(readOnly = true)
    public TCodeMDto findByCd(String cd) {
        log.debug("여기......{}", cd);
        TCodeM tCodeM = codeJpaDao.findBypCd(cd);
        return new TCodeMDto(tCodeM);
    }
    
    @Transactional(readOnly = true)
    public List<TCodeMDto> findAllCd() {
        return codeJpaDao.findAll().stream().map(TCodeMDto::new).collect(Collectors.toList());
    }
    
    @Transactional
    public void save(TCodeMDto tCodeMDto) {
        codeJpaDao.save(tCodeMDto);
    }
    
    // @Transactional
    // public String update(CodeDto codeDto) {
    // Optional<CodeDto> updated = codeJpaDao.save(codeDto);
    // return updated.get().getCd();
    // }
    //
    // @Transactional
    // public void delete(String cd) {
    // codeJpaDao.deleteById(cd);
    // }
}
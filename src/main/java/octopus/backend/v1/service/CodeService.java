package octopus.backend.v1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.backend.v1.dao.CodeRepository;
import octopus.backend.v1.dto.TCodeMDto;
import octopus.entity.TCodeM;

@Service
@AllArgsConstructor
@Slf4j
public class CodeService {
    private CodeRepository codeRepository;
    
    @Transactional(readOnly = true)
    public TCodeMDto findByCd(String cd) {
        log.debug("여기......{}", cd);
        Optional<TCodeM> tCodeM = codeRepository.findBypCd(cd);
        return new TCodeMDto(tCodeM.get());
    }
    
    @Transactional(readOnly = true)
    public List<TCodeMDto> findAllCd() {
        return codeRepository.findAll().stream().map(TCodeMDto::new).collect(Collectors.toList());
    }
    
    @Transactional
    public TCodeM save(TCodeMDto tCodeMDto) {
        
        log.debug("tCodeMDto :: {}", tCodeMDto);
        
        TCodeM tCodeM = tCodeMDto.toEntity();
        
        log.debug("tCodeM :: {}", tCodeM);
        
        return codeRepository.save(tCodeM);
    }
    
    @Transactional
    public int update(TCodeMDto tCodeMDto) {
        
        log.debug("tCodeMDto :: {}", tCodeMDto);
        
        TCodeM tCodeM = tCodeMDto.toEntity();
        
        log.debug("tCodeM :: {}", tCodeM);
        
        return codeRepository.updateTCodeM(tCodeM.getPCd(), tCodeM.getPCdNm());
    }
    
    @Transactional
    public void delete(TCodeMDto tCodeMDto) {
        
        log.debug("tCodeMDto :: {}", tCodeMDto);
        
        TCodeM tCodeM = tCodeMDto.toEntity();
        
        log.debug("tCodeM :: {}", tCodeM);
        
        codeRepository.deleteBypCd(tCodeMDto.getPCd());
    }
}
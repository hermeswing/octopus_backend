package octopus.backend.v1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.backend.v1.dao.CodeMRepository;
import octopus.backend.v1.dto.TCodeMDto;
import octopus.entity.TCodeM;

@Service
@AllArgsConstructor
@Slf4j
public class CodeMService {
    private CodeMRepository codeMRepository;
    
    @Transactional(readOnly = true)
    public TCodeMDto findByCd(String cd) {
        Optional<TCodeM> tCodeM = codeMRepository.findBypCd(cd);
        return new TCodeMDto(tCodeM.get());
    }
    
    @Transactional(readOnly = true)
    public List<TCodeMDto> findAllCd() {
        return codeMRepository.findAll().stream().map(TCodeMDto::new).collect(Collectors.toList());
    }
    
    @Transactional
    public TCodeM save(TCodeMDto tCodeMDto) {
        
        log.debug("tCodeMDto :: {}", tCodeMDto);
        
        TCodeM tCodeM = tCodeMDto.toEntity();
        
        log.debug("tCodeM :: {}", tCodeM);
        
        return codeMRepository.save(tCodeM);
    }
    
    @Transactional
    public int update(TCodeMDto tCodeMDto) {
        
        log.debug("tCodeMDto :: {}", tCodeMDto);
        
        TCodeM tCodeM = tCodeMDto.toEntity();
        
        log.debug("tCodeM :: {}", tCodeM);
        
        return codeMRepository.updateTCodeM(tCodeM.getPCd(), tCodeM.getPCdNm());
    }
    
    @Transactional
    public void update02(TCodeMDto tCodeMDto) {
        Optional<TCodeM> tCodeM = codeMRepository.findBypCd(tCodeMDto.getPCd());
        
        log.debug("TCodeM :: {}", tCodeM.get());
        
        tCodeM.get().updateCodeM(tCodeMDto);
    }
    
    @Transactional
    public void delete(TCodeMDto tCodeMDto) {
        Optional<TCodeM> tCodeM = codeMRepository.findBypCd(tCodeMDto.getPCd());
        
        log.debug("TCodeM :: {}", tCodeM.get());
        
        tCodeM.get().updateUseYn(tCodeMDto);
    }
}
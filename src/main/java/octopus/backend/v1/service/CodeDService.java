package octopus.backend.v1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.backend.v1.dao.CodeDRepository;
import octopus.backend.v1.dto.TCodeDDto;
import octopus.entity.TCodeD;

@Service
@AllArgsConstructor
@Slf4j
public class CodeDService {
    private CodeDRepository codeDRepository;
    
    @Transactional(readOnly = true)
    public TCodeDDto findByCd(String pCd, String cd) {
        Optional<TCodeD> tCodeD = codeDRepository.findByCd(pCd, cd);
        return new TCodeDDto(tCodeD.get());
    }
    
    @Transactional(readOnly = true)
    public List<TCodeDDto> findAllCd() {
        return codeDRepository.findAll().stream().map(TCodeDDto::new).collect(Collectors.toList());
    }
    
    @Transactional
    public TCodeD save(TCodeDDto tCodeMDto) {
        
        log.debug("tCodeMDto :: {}", tCodeMDto);
        
        TCodeD tCodeM = tCodeMDto.toEntity();
        
        log.debug("tCodeM :: {}", tCodeM);
        
        return codeDRepository.save(tCodeM);
    }
    
    @Transactional
    public int update(TCodeDDto tCodeDDto) {
        
        log.debug("tCodeDDto :: {}", tCodeDDto);
        
        TCodeD tCodeM = tCodeDDto.toEntity();
        
        log.debug("tCodeM :: {}", tCodeM);
        
        return codeDRepository.updateTCodeD(tCodeM.getPCd(), tCodeM.getPCdNm());
    }
    
    @Transactional
    public void update02(TCodeDDto tCodeMDto) {
        Optional<TCodeD> tCodeM = codeDRepository.findByCd(tCodeDDto.getPCd(), tCodeDDto.getCd());
        
        log.debug("TCodeD :: {}", tCodeM.get());
        
        tCodeM.get().updateCodeD(tCodeDDto);
    }
    
    @Transactional
    public void delete(TCodeDDto tCodeDDto) {
        Optional<TCodeD> tCodeM = codeDRepository.findByCd(tCodeDDto.getPCd(), tCodeDDto.getCd());
        
        log.debug("TCodeD :: {}", tCodeD.get());
        
        tCodeM.get().updateUseYn(tCodeDDto);
    }
}
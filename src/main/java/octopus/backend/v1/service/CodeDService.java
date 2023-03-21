package octopus.backend.v1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.backend.v1.dao.CodeDRepository;
import octopus.backend.v1.dto.TCodeDDto;
import octopus.entity.TCodeD;

@Service
// @AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class CodeDService {
    // @AllArgsConstructor를 사용하는 경우
    // private CodeDRepository codeDRepository;
    
    private final CodeDRepository codeDRepository;
    private final ModelMapper     modelMapper;
    
    @Transactional(readOnly = true)
    public List<TCodeDDto> findSearch(TCodeDDto tCodeDDto) {
        List<TCodeDDto> list = codeDRepository.findBypCd(tCodeDDto.getPCd(), Sort.by(Sort.Direction.ASC, "sortSeq"))
                .stream().map(data -> TCodeDDto.getDto(data)).collect(Collectors.toList());
        
        log.debug("list :: {}", list);
        
        return list;
    }
    
    @Transactional(readOnly = true)
    public List<TCodeDDto> findBypCd(String pCd) {
        Sort s1 = Sort.by("sortSeq").ascending();
        //Sort s2 = Sort.by("cd").descending();
        //Sort sortAll = s1.and(s2);
        
        List<TCodeDDto> list = codeDRepository.findBypCd(pCd, s1).stream()
                .map(data -> TCodeDDto.getDto(data)).collect(Collectors.toList());
        
        log.debug("list :: {}", list);
        
        return list;
    }
    
    @Transactional(readOnly = true)
    public TCodeDDto findBypCdAndCd(String pCd, String cd) {
        Optional<TCodeD> tCodeD = codeDRepository.findBypCdAndCd(pCd, cd);
        
        log.debug("tCodeD :: {}", tCodeD.get());
        
        if (tCodeD.isPresent()) {
            // return TCodeDDto.getDto(tCodeD.get());
            return modelMapper.map(tCodeD.get(), TCodeDDto.class);
        } else {
            return new TCodeDDto();
        }
    }
    
    @Transactional(readOnly = true)
    public List<TCodeDDto> findAllCd() {
        List<TCodeDDto> list = codeDRepository.findAll().stream().map(data -> TCodeDDto.getDto(data))
                .collect(Collectors.toList());
        // List<TCodeDDto> list = codeDRepository.findAll().stream().map(data ->
        // modelMapper.map(data, TCodeDDto.class))
        // .collect(Collectors.toList());
        
        log.debug("list :: {}", list);
        
        return list;
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
        
        TCodeD tCodeD = tCodeDDto.toEntity();
        
        log.debug("tCodeD :: {}", tCodeD);
        
        return codeDRepository.updateTCodeD(tCodeD.getPCd(), tCodeD.getCd(), tCodeD.getCdNm());
    }
    
    @Transactional
    public void update02(TCodeDDto tCodeDDto) {
        Optional<TCodeD> tCodeD = codeDRepository.findBypCdAndCd(tCodeDDto.getPCd(), tCodeDDto.getCd());
        
        log.debug("TCodeD :: {}", tCodeD.get());
        
        tCodeD.get().updateCodeD(tCodeDDto);
    }
    
    @Transactional
    public void delete(TCodeDDto tCodeDDto) {
        Optional<TCodeD> tCodeD = codeDRepository.findBypCdAndCd(tCodeDDto.getPCd(), tCodeDDto.getCd());
        
        log.debug("TCodeD :: {}", tCodeD.get());
        
        tCodeD.get().updateUseYn(tCodeDDto);
    }
}
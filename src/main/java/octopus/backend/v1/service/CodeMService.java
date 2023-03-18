package octopus.backend.v1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.backend.v1.dao.CodeMRepository;
import octopus.backend.v1.dto.TCodeDDto;
import octopus.backend.v1.dto.TCodeMDto;
import octopus.entity.TCodeM;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class CodeMService {
	// @AllArgsConstructor를 사용하는 경우
	// private CodeDRepository codeDRepository;

	private final CodeMRepository codeMRepository;
	private final ModelMapper modelMapper;

	@Transactional(readOnly = true)
	public TCodeMDto findByCd(String cd) {
		Optional<TCodeM> tCodeM = codeMRepository.findBypCd(cd);

		log.debug("tCodeM :: {}", tCodeM.get());

		if (tCodeM.isPresent()) {
			// return TCodeMDto.getDto(tCodeM.get());
			return modelMapper.map(tCodeM.get(), TCodeMDto.class);
		} else {
			return new TCodeMDto();
		}
	}

	@Transactional(readOnly = true)
	public List<TCodeMDto> findAllCd() {
		List<TCodeMDto> list = codeMRepository.findAll().stream().map(data -> TCodeMDto.getDto(data)).collect(Collectors.toList());
		//List<TCodeMDto> list = codeDRepository.findAll().stream().map(data -> modelMapper.map(data, TCodeMDto.class))
		//		.collect(Collectors.toList());

		log.debug("list :: {}", list);

		return list;
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
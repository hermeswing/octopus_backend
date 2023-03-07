package octopus.backend.v1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.backend.v1.dao.CodeJpaDao;
import octopus.backend.v1.dto.CodeDto;

@Service
@AllArgsConstructor
@Slf4j
public class CodeService {
	private CodeJpaDao codeJpaDao;

	@Transactional(readOnly = true)
	public CodeDto findByCd(String cd) {
		log.debug("여기......{}", cd);
		CodeDto codeDto = codeJpaDao.findBypCd(cd);
		return codeDto;
	}
	/*
	@Transactional(readOnly = true)
	public List<CodeDto> findAllCd() {
		return codeJpaDao.findAll().stream().map(CodeDto::new).collect(Collectors.toList());
	}

	@Transactional
	public String save(CodeDto codeDto) {
		Optional<CodeDto> saved = codeJpaDao.save(codeDto);
		return saved.get().getCd();
	}

	@Transactional
	public String update(CodeDto codeDto) {
		Optional<CodeDto> updated = codeJpaDao.save(codeDto);
		return updated.get().getCd();
	}

	@Transactional
	public void delete(String cd) {
		codeJpaDao.deleteById(cd);
	}
*/
}
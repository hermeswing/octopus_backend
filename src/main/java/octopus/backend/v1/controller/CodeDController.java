package octopus.backend.v1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.backend.service.ResponseService;
import octopus.backend.v1.dto.TCodeDDto;
import octopus.backend.v1.service.CodeDService;
import octopus.entity.CommonResult;
import octopus.entity.TCodeD;
import octopus.model.ListResult;
import octopus.model.SearchCriteria;
import octopus.model.SingleResult;

@Slf4j
@Api(tags = { "1. Detail Code" })
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/detail")
public class CodeDController {

	private final MessageSourceAccessor messageSourceAccessor;
	private final CodeDService codeDService;
	private final ResponseService responseService;

	@ApiOperation(value = "GET방식/detail/code/search?search=검색조건", notes = "검색조건 예) search=userame:sam,age<=20")
	@GetMapping("/code/search")
	public ListResult<TCodeDDto> findSearch(
			@ApiParam(value = "조회조건", required = true) @RequestParam(value = "search", required = false) String searchString) {
		// public List<User> searchForAll (@RequestParam(value = "search", required =
		// false) String searchString) {
		List<SearchCriteria> parameters = new ArrayList<SearchCriteria>();
		if (searchString != null) {
			Pattern searchPattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
			Matcher pathMatcher = searchPattern.matcher(searchString + ",");
			while (pathMatcher.find()) {
				parameters.add(new SearchCriteria(pathMatcher.group(1), pathMatcher.group(2), pathMatcher.group(3)));
			}

			log.debug("parameters :: {}", parameters);
		}

		// List<TCodeDDto> list = codeDService.findSearch(tCodeDDto);
		List<TCodeDDto> list = null;

		log.debug("list :: {}", list);

		return responseService.getListResult(list);
	}

	// HATEOAS
	// @ApiOperation(value = "대분류 코드에 속한 공통코드 검색", notes = "공통코드를 조회합니다.")
	// @GetMapping("/code/hateoas/{pCd}")
	// public ListResult<CollectionModel<EntityModel<TCodeDDto>>> findByHateoasPCd(
	// @ApiParam(value = "대분류코드", required = true) @PathVariable String pCd) {
	// // List<TCodeDDto> list = codeDService.findBypCd(pCd);
	//
	// List<EntityModel<TCodeDDto>> codes = codeDService.findBypCd(pCd).stream()
	// .map(data -> EntityModel.of(data,
	// linkTo(methodOn(CodeDController.class).findByHateoasPCd(data.getPCd())).withSelfRel(),
	// linkTo(methodOn(CodeDController.class).findAllCode()).withRel("codes")))
	// .collect(Collectors.toList());
	// CollectionModel collection = CollectionModel.of(codes,
	// linkTo(methodOn(CodeDController.class).findAllCode()).withSelfRel());
	//
	// // log.debug("list :: {}", list);
	//
	// return responseService.getListResult(collection);
	// }

	@ApiOperation(value = "대분류 코드에 속한 공통코드 검색", notes = "대분류 코드에 속한 공통코드를 조회합니다.")
	@GetMapping("/code/{pCd}")
	public ListResult<TCodeDDto> findBypCd(@ApiParam(value = "대분류코드", required = true) @PathVariable String pCd) {
		List<TCodeDDto> list = codeDService.findBypCd(pCd);

		log.debug("list :: {}", list);

		return responseService.getListResult(list);
	}

	@ApiOperation(value = "공통코드 단건 검색", notes = "공통코드를 조회합니다.")
	@GetMapping("/code/cd/{pCd}/{cd}")
	public SingleResult<TCodeDDto> findBypCdAndCd(@ApiParam(value = "대분류코드", required = true) @PathVariable String pCd,
			@ApiParam(value = "공통코드", required = true) @PathVariable String cd) {
		TCodeDDto tCodeDDto = codeDService.findBypCdAndCd(pCd, cd);

		log.debug("tCodeDDto :: {}", tCodeDDto);

		return responseService.getSingleResult(tCodeDDto);
	}

	@ApiOperation(value = "공통코드 목록 조회", notes = "모든 코드을 조회합니다.")
	@GetMapping("/codes")
	public ListResult<TCodeDDto> findAllCode() {
		return responseService.getListResult(codeDService.findAllCd());
	}

	@ApiOperation(value = "공통코드 저장", notes = "공통코드 정보를 저장합니다.")
	@PostMapping("/codeSave")
	public SingleResult<TCodeDDto> codeSave(@RequestBody @Valid TCodeDDto tCodeDDto, Errors errors) {

		log.debug("tCodeMDto :: {}", tCodeDDto);

		TCodeD tCodeD = codeDService.save(tCodeDDto);

		return responseService.getSingleResult(TCodeDDto.getDto(tCodeD));
	}

	@ApiOperation(value = "공통코드 저장", notes = "공통코드 정보를 저장합니다.")
	@PostMapping("/code")
	public SingleResult<TCodeDDto> save(
			@ApiParam(value = "대분류코드", required = true) @RequestParam(required = true) String pCd,
			@ApiParam(value = "공통코드", required = true) @RequestParam(required = true) String cd,
			@ApiParam(value = "코드명", required = true) @RequestParam(required = true) String cdNm,
			@ApiParam(value = "사용여부", required = true) @RequestParam(required = true) String useYn,
			@ApiParam(value = "문자옵션1", required = false) @RequestParam(required = false) String wdOpt1,
			@ApiParam(value = "문자옵션2", required = false) @RequestParam(required = false) String wdOpt2,
			@ApiParam(value = "문자옵션3", required = false) @RequestParam(required = false) String wdOpt3,
			@ApiParam(value = "문자옵션4", required = false) @RequestParam(required = false) String wdOpt4,
			@ApiParam(value = "문자옵션5", required = false) @RequestParam(required = false) String wdOpt5,
			@ApiParam(value = "슷지옵션1", required = false) @RequestParam(required = false) int numOpt1,
			@ApiParam(value = "슷지옵션2", required = false) @RequestParam(required = false) int numOpt2,
			@ApiParam(value = "슷지옵션3", required = false) @RequestParam(required = false) int numOpt3,
			@ApiParam(value = "슷지옵션4", required = false) @RequestParam(required = false) int numOpt4,
			@ApiParam(value = "슷지옵션5", required = false) @RequestParam(required = false) int numOpt5,
			@ApiParam(value = "비고", required = false) @RequestParam(required = false) String rmk) {

		TCodeDDto tCodeDDto = TCodeDDto.builder().pCd(pCd).cd(cd).cdNm(cdNm).useYn(useYn).rmk(rmk).wdOpt1(wdOpt1)
				.wdOpt2(wdOpt2).wdOpt3(wdOpt3).wdOpt4(wdOpt4).wdOpt5(wdOpt5).numOpt1(numOpt1).numOpt2(numOpt2)
				.numOpt3(numOpt3).numOpt4(numOpt4).numOpt5(numOpt5).build();

		log.debug("tCodeMDto :: {}", tCodeDDto);

		TCodeD tCodeD = codeDService.save(tCodeDDto);

		return responseService.getSingleResult(TCodeDDto.getDto(tCodeD));
	}

	@ApiOperation(value = "공통코드 수정", notes = "공통코드 정보를 수정합니다.")
	@PutMapping("/code")
	public SingleResult<String> update(
			@ApiParam(value = "대분류코드", required = true) @RequestParam(required = true) String pCd,
			@ApiParam(value = "공통코드", required = true) @RequestParam(required = true) String cd,
			@ApiParam(value = "코드명", required = true) @RequestParam(required = true) String cdNm,
			@ApiParam(value = "사용여부", required = true) @RequestParam(required = true) String useYn,
			@ApiParam(value = "문자옵션1", required = false) @RequestParam(required = false) String wdOpt1,
			@ApiParam(value = "문자옵션2", required = false) @RequestParam(required = false) String wdOpt2,
			@ApiParam(value = "문자옵션3", required = false) @RequestParam(required = false) String wdOpt3,
			@ApiParam(value = "문자옵션4", required = false) @RequestParam(required = false) String wdOpt4,
			@ApiParam(value = "문자옵션5", required = false) @RequestParam(required = false) String wdOpt5,
			@ApiParam(value = "슷지옵션1", required = false) @RequestParam(required = false) int numOpt1,
			@ApiParam(value = "슷지옵션2", required = false) @RequestParam(required = false) int numOpt2,
			@ApiParam(value = "슷지옵션3", required = false) @RequestParam(required = false) int numOpt3,
			@ApiParam(value = "슷지옵션4", required = false) @RequestParam(required = false) int numOpt4,
			@ApiParam(value = "슷지옵션5", required = false) @RequestParam(required = false) int numOpt5,
			@ApiParam(value = "비고", required = false) @RequestParam(required = false) String rmk) {

		TCodeDDto tCodeDDto = TCodeDDto.builder().pCd(pCd).cd(cd).cdNm(cdNm).useYn(useYn).rmk(rmk).wdOpt1(wdOpt1)
				.wdOpt2(wdOpt2).wdOpt3(wdOpt3).wdOpt4(wdOpt4).wdOpt5(wdOpt5).numOpt1(numOpt1).numOpt2(numOpt2)
				.numOpt3(numOpt3).numOpt4(numOpt4).numOpt5(numOpt5).build();

		log.debug("tCodeDDto :: {}", tCodeDDto);

		codeDService.update02(tCodeDDto);

		return responseService.getSingleResult(messageSourceAccessor.getMessage("msg.itIsSaved")); // 저장되었습니다.
	}

	@ApiOperation(value = "공통코드 삭제", notes = "공통코드를 삭제합니다.")
	@DeleteMapping("/code/{pCd}/{cd}")
	public CommonResult delete(@ApiParam(value = "대분류코드", required = true) @RequestParam(required = true) String pCd,
			@ApiParam(value = "공통코드", required = true) @RequestParam(required = true) String cd) {

		TCodeDDto tCodeDDto = TCodeDDto.builder().pCd(pCd).cd(cd).useYn("N").build();

		codeDService.delete(tCodeDDto);

		return responseService.getSingleResult(messageSourceAccessor.getMessage("msg.itIsDeleted")); // 삭제되었습니다.
	}
}

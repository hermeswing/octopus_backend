package octopus.backend.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.backend.service.ResponseService;
import octopus.backend.v1.dto.TCodeMDto;
import octopus.backend.v1.service.CodeService;
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
        log.debug("여기......");
        return responseService.getSingleResult(codeService.findByCd(pCd));
    }
    
    @ApiOperation(value = "코드 목록 조회", notes = "모든 코드을 조회합니다.")
    @GetMapping("/master/codes")
    public ListResult<TCodeMDto> findAllCode() {
        return responseService.getListResult(codeService.findAllCd());
    }
    
    @ApiOperation(value = "코드 저장", notes = "코드 정보를 저장합니다.")
    @ApiImplicitParams({ @ApiImplicitParam(name = "pCd", value = "대분류코드"),
        @ApiImplicitParam(name = "pCdNm", value = "대분류코드명"), @ApiImplicitParam(name = "useYn", value = "사용여부"),
        @ApiImplicitParam(name = "wdOptNm1", value = "문자옵션1"), @ApiImplicitParam(name = "wdOptNm2", value = "문자옵션2"),
        @ApiImplicitParam(name = "wdOptNm3", value = "문자옵션3"), @ApiImplicitParam(name = "wdOptNm4", value = "문자옵션4"),
        @ApiImplicitParam(name = "wdOptNm5", value = "문자옵션5"), @ApiImplicitParam(name = "numOptNm1", value = "슷지옵션1"),
        @ApiImplicitParam(name = "numOptNm2", value = "슷지옵션2"), @ApiImplicitParam(name = "numOptNm3", value = "슷지옵션3"),
        @ApiImplicitParam(name = "numOptNm4", value = "슷지옵션4"), @ApiImplicitParam(name = "numOptNm5", value = "슷지옵션5"),
        @ApiImplicitParam(name = "rmk", value = "비고"), })
    @PostMapping("/master/code")
    public SingleResult<String> save(TCodeMDto tCodeMDto) {
        return responseService.getSingleResult("성공");
    }
    //
    // @ApiOperation(value = "코드 수정", notes = "코드 정보를 수정합니다.")
    // @PutMapping("/master/code")
    // public SingleResult<String> update(@ApiParam(value = "코드", required = true) @RequestParam String cd,
    // @ApiParam(value = "코드 이름", required = true) @RequestParam String name) {
    // CodeDto codeDto = octopus.backend.v1.dto.MemberDto.builder().name(name).build();
    // return responseService.getSingleResult(memberService.update(CodeDto));
    // }
    //
    // @ApiOperation(value = "코드 삭제", notes = "코드을 삭제합니다.")
    // @DeleteMapping("/master/code/{cd}")
    // public CommonResult delete(@ApiParam(value = "코드 아이디", required = true) @PathVariable String cd) {
    // memberService.delete(cd);
    // return responseService.getSuccessResult();
    // }
    // </pre>
    // */
}

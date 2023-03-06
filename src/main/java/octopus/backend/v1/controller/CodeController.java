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
import octopus.backend.service.ResponseService;
import octopus.backend.v1.dto.MemberDto;
import octopus.backend.v1.service.MemberService;
import octopus.entity.CommonResult;
import octopus.model.ListResult;
import octopus.model.SingleResult;

@Api(tags = { "1. Code" })
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class CodeController {
    
    private final MemberService   memberService;
    private final ResponseService responseService;
    
    @ApiOperation(value = "코드 단건 검색", notes = "cd로 코드을 조회합니다.")
    @GetMapping("/member/id/{cd}")
    public SingleResult<MemberDto> findCodeByCd(
            @ApiParam(value = "코드 ID", required = true) @PathVariable String cd) {
        return responseService.getSingleResult(memberService.findById(cd));
    }
    
    @ApiOperation(value = "코드 목록 조회", notes = "모든 코드을 조회합니다.")
    @GetMapping("/members")
    public ListResult<MemberDto> findAllCode() {
        return responseService.getListResult(memberService.findAllMember());
    }
    
    @ApiOperation(value = "코드 저장", notes = "코드 정보를 저장합니다.")
    @PostMapping("/member")
    public SingleResult<String> save(@ApiParam(value = "코드 이름", required = true) @RequestParam String name,
            @ApiParam(value = "코드 이메일") @RequestParam String email) {
        return responseService.getSingleResult(memberService.save(MemberDto));
    }
    
    @ApiOperation(value = "코드 수정", notes = "코드 정보를 수정합니다.")
    @PutMapping("/member")
    public SingleResult<String> update(@ApiParam(value = "코드 ID", required = true) @RequestParam String cd,
            @ApiParam(value = "코드 이름", required = true) @RequestParam String name) {
        MemberDto MemberDto = octopus.backend.v1.dto.MemberDto.builder().name(name).build();
        return responseService.getSingleResult(memberService.update(MemberDto));
    }
    
    @ApiOperation(value = "코드 삭제", notes = "코드을 삭제합니다.")
    @DeleteMapping("/member/{cd}")
    public CommonResult delete(@ApiParam(value = "코드 아이디", required = true) @PathVariable String cd) {
        memberService.delete(cd);
        return responseService.getSuccessResult();
    }
    
}

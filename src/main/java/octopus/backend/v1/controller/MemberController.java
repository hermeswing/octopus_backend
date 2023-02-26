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

@Api(tags = { "1. Member" })
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class MemberController {
    
    private final MemberService   memberService;
    private final ResponseService responseService;
    
    @ApiOperation(value = "회원 단건 검색", notes = "memberId로 회원을 조회합니다.")
    @GetMapping("/member/id/{memberId}")
    public SingleResult<MemberDto> findUserById(
            @ApiParam(value = "회원 ID", required = true) @PathVariable String memberId) {
        return responseService.getSingleResult(memberService.findById(memberId));
    }
    
    @ApiOperation(value = "회원 목록 조회", notes = "모든 회원을 조회합니다.")
    @GetMapping("/members")
    public ListResult<MemberDto> findAllMember() {
        return responseService.getListResult(memberService.findAllMember());
    }
    
    @ApiOperation(value = "회원 저장", notes = "회원 정보를 저장합니다.")
    @PostMapping("/member")
    public SingleResult<String> save(@ApiParam(value = "회원 이름", required = true) @RequestParam String name,
            @ApiParam(value = "회원 이메일") @RequestParam String email) {
        MemberDto MemberDto = octopus.backend.v1.dto.MemberDto.builder().name(name).email(email).build();
        // MemberDto MemberDto = MemberDto.builder().name(name).build();
        return responseService.getSingleResult(memberService.save(MemberDto));
    }
    
    @ApiOperation(value = "회원 수정", notes = "회원 정보를 수정합니다.")
    @PutMapping("/member")
    public SingleResult<String> update(@ApiParam(value = "회원 ID", required = true) @RequestParam String memberId,
            @ApiParam(value = "회원 이름", required = true) @RequestParam String name) {
        MemberDto MemberDto = octopus.backend.v1.dto.MemberDto.builder().name(name).build();
        // MemberDto MemberDto = MemberDto.builder().name(name).build();
        return responseService.getSingleResult(memberService.update(MemberDto));
    }
    
    @ApiOperation(value = "회원 삭제", notes = "회원을 삭제합니다.")
    @DeleteMapping("/member/{memberId}")
    public CommonResult delete(@ApiParam(value = "회원 아이디", required = true) @PathVariable String memberId) {
        memberService.delete(memberId);
        return responseService.getSuccessResult();
    }
    
}

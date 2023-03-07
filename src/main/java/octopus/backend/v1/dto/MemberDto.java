package octopus.backend.v1.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import octopus.entity.Member;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String memberId;
    private String email;
    private String name;
    private LocalDateTime loginDateTime;
    private LocalDateTime modifiedDate;

    public MemberDto(Member member) {
        this.memberId = member.getMemberId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.loginDateTime = member.getLoginDateTime();
        this.modifiedDate = member.getMdfDt();
    }

    public Member toEntity() {
        return Member.builder().email(email).name(name).build();
    }
}

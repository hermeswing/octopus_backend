package octopus.backend.v1.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import octopus.entity.BaseDto;
import octopus.entity.TCodeM;

/**
 * <pre>
 * DTO : 데이터 전달 목적
 * 데이터를 캡슐화한 데이터 전달 객체
 * </pre>
 * 
 * @author hermeswing
 */
@Data
@Builder
@AllArgsConstructor // 모든인자를 가지는객체 생성
@NoArgsConstructor // 인자 없이 객체 생성
@EqualsAndHashCode(callSuper = true) // true의 경우 부모 클래스 필드 값들도 동일한지 체크하며, false(기본값)일 경우 자신 클래스의 필드 값만 고려한다.
public class TCodeMDto extends BaseDto {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String pCd;

	@NotNull
	private String pCdNm;

	@Size(min = 1, max = 1)
	private String useYn;

	private String wdOptNm1;
	private String wdOptNm2;
	private String wdOptNm3;
	private String wdOptNm4;
	private String wdOptNm5;

	private String numOptNm1;
	private String numOptNm2;
	private String numOptNm3;
	private String numOptNm4;
	private String numOptNm5;

	private String rmk;

	private String crtId;
	private LocalDateTime crtDt;
	private String mdfId;
	private LocalDateTime mdfDt;

	public static TCodeMDto getDto(TCodeM code) {
		return TCodeMDto.builder().pCd(code.getPCd()).pCdNm(code.getPCdNm()).useYn(code.getUseYn())
				.wdOptNm1(code.getWdOptNm1()).wdOptNm2(code.getWdOptNm2()).wdOptNm3(code.getWdOptNm3())
				.wdOptNm4(code.getWdOptNm4()).wdOptNm5(code.getWdOptNm5()).numOptNm1(code.getNumOptNm1())
				.numOptNm2(code.getNumOptNm2()).numOptNm3(code.getNumOptNm3()).numOptNm4(code.getNumOptNm4())
				.numOptNm5(code.getNumOptNm5()).rmk(code.getRmk()).crtId(code.getCrtId()).crtDt(code.getCrtDt())
				.mdfId(code.getMdfId()).mdfDt(code.getMdfDt()).build();
	}

	public TCodeM toEntity() {
		return TCodeM.builder().pCd(pCd).pCdNm(pCdNm).useYn(useYn).wdOptNm1(wdOptNm1).wdOptNm2(wdOptNm2)
				.wdOptNm3(wdOptNm3).wdOptNm4(wdOptNm4).wdOptNm5(wdOptNm5).numOptNm1(numOptNm1).numOptNm2(numOptNm2)
				.numOptNm3(numOptNm3).numOptNm4(numOptNm4).numOptNm5(numOptNm5).rmk(rmk).build();
	}
}

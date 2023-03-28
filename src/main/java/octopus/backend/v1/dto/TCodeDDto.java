package octopus.backend.v1.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import octopus.entity.BaseDto;
import octopus.entity.TCodeD;

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
@ToString
@EqualsAndHashCode(callSuper = true) // true의 경우 부모 클래스 필드 값들도 동일한지 체크하며, false(기본값)일 경우 자신 클래스의 필드 값만 고려한다.
public class TCodeDDto extends BaseDto {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String pCd;

	@NotNull
	private String cd;

	private String cdNm;

	@Size(min = 1, max = 1)
	private String useYn;

	@Digits(integer = 4, fraction = 0)
	private Integer sortSeq;

	private String wdOpt1;
	private String wdOpt2;
	private String wdOpt3;
	private String wdOpt4;
	private String wdOpt5;

	private Integer numOpt1;
	private Integer numOpt2;
	private Integer numOpt3;
	private Integer numOpt4;
	private Integer numOpt5;

	private String rmk;

	public static TCodeDDto getDto(TCodeD code) {
		return TCodeDDto.builder().pCd(code.getPCd()).cd(code.getCd()).cdNm(code.getCdNm()).sortSeq(code.getSortSeq())
				.useYn(code.getUseYn()).wdOpt1(code.getWdOpt1()).wdOpt2(code.getWdOpt2()).wdOpt3(code.getWdOpt3())
				.wdOpt4(code.getWdOpt4()).wdOpt5(code.getWdOpt5()).numOpt1(code.getNumOpt1()).numOpt2(code.getNumOpt2())
				.numOpt3(code.getNumOpt3()).numOpt4(code.getNumOpt4()).numOpt5(code.getNumOpt5()).rmk(code.getRmk())
				.build();
	}

	public TCodeD toEntity() {
		return TCodeD.builder().pCd(pCd).cd(cd).cdNm(cdNm).useYn(useYn).sortSeq(sortSeq).wdOpt1(wdOpt1).wdOpt2(wdOpt2)
				.wdOpt3(wdOpt3).wdOpt4(wdOpt4).wdOpt5(wdOpt5).numOpt1(numOpt1).numOpt2(numOpt2).numOpt3(numOpt3)
				.numOpt4(numOpt4).numOpt5(numOpt5).rmk(rmk).build();
	}
}

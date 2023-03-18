package octopus.backend.v1.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class TCodeDDto {
	private String pCd;
	private String cd;
	private String cdNm;
	private String useYn;

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

	private String crtId;
	private LocalDateTime crtDt;
	private String mdfId;
	private LocalDateTime mdfDt;

	public static TCodeDDto getDto(TCodeD code) {
		return TCodeDDto.builder().pCd(code.getPCd()).cd(code.getCd()).cdNm(code.getCdNm()).useYn(code.getUseYn())
				.wdOpt1(code.getWdOpt1()).wdOpt2(code.getWdOpt2()).wdOpt3(code.getWdOpt3()).wdOpt4(code.getWdOpt4())
				.wdOpt5(code.getWdOpt5()).numOpt1(code.getNumOpt1()).numOpt2(code.getNumOpt2())
				.numOpt3(code.getNumOpt3()).numOpt4(code.getNumOpt4()).numOpt5(code.getNumOpt5()).rmk(code.getRmk())
				.crtId(code.getCrtId()).crtDt(code.getCrtDt()).mdfId(code.getMdfId()).mdfDt(code.getMdfDt()).build();
	}

	public TCodeD toEntity() {
		return TCodeD.builder().pCd(pCd).cd(cd).cdNm(cdNm).useYn(useYn).wdOpt1(wdOpt1).wdOpt2(wdOpt2).wdOpt3(wdOpt3)
				.wdOpt4(wdOpt4).wdOpt5(wdOpt5).numOpt1(numOpt1).numOpt2(numOpt2).numOpt3(numOpt3).numOpt4(numOpt4)
				.numOpt5(numOpt5).rmk(rmk).build();
	}
}

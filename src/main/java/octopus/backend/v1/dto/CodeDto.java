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
public class CodeDto {
	private String pCd;
	private String pCdNm;
	private String cd;
	private String cdNm;
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
	
	private String wdOpt1;
	private String wdOpt2;
	private String wdOpt3;
	private String wdOpt4;
	private String wdOpt5;
	
	private int numOpt1;
	private int numOpt2;
	private int numOpt3;
	private int numOpt4;
	private int numOpt5;
	
	private String rmk;
}

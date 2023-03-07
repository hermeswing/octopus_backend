package octopus.backend.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import octopus.entity.TCodeD;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    
    private int numOpt1;
    private int numOpt2;
    private int numOpt3;
    private int numOpt4;
    private int numOpt5;
    
    private String rmk;
    
    public TCodeDDto(TCodeD code) {
        this.pCd   = code.getPCd();
        this.cd    = code.getCd();
        this.cdNm  = code.getCdNm();
        this.useYn = code.getUseYn();
        
        this.wdOpt1 = code.getWdOpt_1();
        this.wdOpt2 = code.getWdOpt_2();
        this.wdOpt3 = code.getWdOpt_3();
        this.wdOpt4 = code.getWdOpt_4();
        this.wdOpt5 = code.getWdOpt_5();
        
        this.numOpt1 = code.getNumOpt_1();
        this.numOpt2 = code.getNumOpt_2();
        this.numOpt3 = code.getNumOpt_3();
        this.numOpt4 = code.getNumOpt_4();
        this.numOpt5 = code.getNumOpt_5();
        
        this.rmk = code.getRmk();
    }
    
}

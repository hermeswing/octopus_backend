package octopus.backend.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import octopus.entity.TCodeM;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TCodeMDto {
    private String pCd;
    private String pCdNm;
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
    
    public TCodeMDto(TCodeM code) {
        this.pCd   = code.getPCd();
        this.pCdNm = code.getPCdNm();
        this.useYn = code.getUseYn();
        
        this.wdOptNm1 = code.getWdOptNm_1();
        this.wdOptNm2 = code.getWdOptNm_2();
        this.wdOptNm3 = code.getWdOptNm_3();
        this.wdOptNm4 = code.getWdOptNm_4();
        this.wdOptNm5 = code.getWdOptNm_5();
        
        this.numOptNm1 = code.getNumOptNm_1();
        this.numOptNm2 = code.getNumOptNm_2();
        this.numOptNm3 = code.getNumOptNm_3();
        this.numOptNm4 = code.getNumOptNm_4();
        this.numOptNm5 = code.getNumOptNm_5();
        
        this.rmk = code.getRmk();
    }
    
}

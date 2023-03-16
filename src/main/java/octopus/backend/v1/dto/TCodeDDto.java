package octopus.backend.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import octopus.entity.TCodeD;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TCodeDDto {
    private final long serialVersionUID = 1L;
    
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
    
    private String crtId;
    private String crtDt;
    private String mdfId;
    private String mdfDt;
    
    public TCodeDDto(TCodeD code) {
        TCodeDDto.builder().pCd(code.getPCd()).cd(cd).cdNm(cdNm).useYn(useYn).wdOpt1(wdOpt1).wdOpt2(wdOpt2)
                .wdOpt3(wdOpt3).wdOpt4(wdOpt4).wdOpt5(wdOpt5).numOpt1(numOpt1).numOpt2(numOpt2).numOpt3(numOpt3)
                .numOpt4(numOpt4).numOpt5(numOpt5).rmk(rmk).crtId(crtId).crtDt(crtDt).mdfId(mdfId).mdfDt(mdfDt).build();
    }
    
    public TCodeD toEntity() {
        return TCodeD.builder().pCd(pCd).cd(cd).cdNm(cdNm).useYn(useYn).wdOpt1(wdOpt1).wdOpt2(wdOpt2).wdOpt3(wdOpt3)
                .wdOpt4(wdOpt4).wdOpt5(wdOpt5).numOpt1(numOpt1).numOpt2(numOpt2).numOpt3(numOpt3).numOpt4(numOpt4)
                .numOpt5(numOpt5).rmk(rmk).build();
    }
}

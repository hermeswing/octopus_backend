package octopus.backend.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import octopus.entity.TCodeM;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    
    private String crtId;
    private String crtDt;
    private String mdfId;
    private String mdfDt;
    
    public TCodeMDto(TCodeM code) {
        TCodeMDto.builder().pCd(pCd).pCdNm(pCdNm).useYn(useYn).wdOptNm1(wdOptNm1).wdOptNm2(wdOptNm2).wdOptNm3(wdOptNm3)
                .wdOptNm4(wdOptNm4).wdOptNm5(wdOptNm5).numOptNm1(numOptNm1).numOptNm2(numOptNm2).numOptNm3(numOptNm3)
                .numOptNm4(numOptNm4).numOptNm5(numOptNm5).rmk(rmk).crtId(crtId).crtDt(crtDt).mdfId(mdfId).mdfDt(mdfDt)
                .build();
    }
    
    public TCodeM toEntity() {
        return TCodeM.builder().pCd(pCd).pCdNm(pCdNm).useYn(useYn).wdOptNm1(wdOptNm1).wdOptNm2(wdOptNm2)
                .wdOptNm3(wdOptNm3).wdOptNm4(wdOptNm4).wdOptNm5(wdOptNm5).numOptNm1(numOptNm1).numOptNm2(numOptNm2)
                .numOptNm3(numOptNm3).numOptNm4(numOptNm4).numOptNm5(numOptNm5).rmk(rmk).build();
    }
}

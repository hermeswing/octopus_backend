package octopus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Proxy;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // jpa entity임을 알립니다.
@Getter // getter를 자동으로 생성합니다.
// @Setter // 객체가 무분별하게 변경될 가능성 있음
@Builder
@ToString(exclude = { "crtId", "crtDt", "mdfId", "mdfDt" }) // 연관관계 매핑된 엔티티 필드는 제거. 연관 관계 필드는 toString()에서 사용하지 않는 것이 좋습니다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 인자없는 생성자를 자동으로 생성합니다. 기본 생성자의 접근 제어자가 불명확함. (access = AccessLevel.PROTECTED) 추가
// @AllArgsConstructor // 객체 내부의 인스턴스멤버들을 모두 가지고 있는 생성자를 생성 (매우 위험)
@Table(name = "T_CODE_M")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // Post Entity에서 User와의 관계를 Json으로 변환시 오류 방지를 위한 코드
@Proxy(lazy = false)
public class TCodeM extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getId() {
        return this.pCd;
    }
    
    @Builder
    public TCodeM(String pCd, String pCdNm, String useYn, String rmk, String wdOptNm1, String wdOptNm2, String wdOptNm3,
            String wdOptNm4, String wdOptNm5, String numOptNm1, String numOptNm2, String numOptNm3, String numOptNm4,
            String numOptNm5) {
        Assert.hasText(pCd, "pCd must not be empty");
        Assert.hasText(pCdNm, "pCdNm must not be empty");
        Assert.hasText(useYn, "useYn must not be empty");
        
        this.pCd       = pCd;
        this.pCdNm     = pCdNm;
        this.useYn     = useYn;
        this.rmk       = rmk;
        this.wdOptNm1  = wdOptNm1;
        this.wdOptNm2  = wdOptNm2;
        this.wdOptNm3  = wdOptNm3;
        this.wdOptNm4  = wdOptNm4;
        this.wdOptNm5  = wdOptNm5;
        this.numOptNm1 = numOptNm1;
        this.numOptNm2 = numOptNm2;
        this.numOptNm3 = numOptNm3;
        this.numOptNm4 = numOptNm4;
        this.numOptNm5 = numOptNm5;
    }
    
    /**
     * 상위 코드
     */
    @Id // pk
    @NotEmpty
    @Column(nullable = false, unique = true, length = 50)
    private String pCd;
    
    /**
     * 상위 코드명
     */
    @NotEmpty
    @Column(nullable = false, length = 200)
    private String pCdNm;
    
    /**
     * 사용여부
     */
    @NotEmpty
    @Column(nullable = false, length = 1)
    private String useYn = "Y"; // Default 값
    
    /**
     * 문자옵션명#1
     */
    @Column(length = 200)
    private String wdOptNm1;
    
    /**
     * 문자옵션명#2
     */
    @Column(length = 200)
    private String wdOptNm2;
    
    /**
     * 문자옵션명#3
     */
    @Column(length = 200)
    private String wdOptNm3;
    
    /**
     * 문자옵션명#4
     */
    @Column(length = 200)
    private String wdOptNm4;
    
    /**
     * 문자옵션명#5
     */
    @Column(length = 200)
    private String wdOptNm5;
    
    /**
     * 숫자옵션명#1
     */
    @Column(length = 200)
    private String numOptNm1;
    
    /**
     * 숫자옵션명#2
     */
    @Column(length = 200)
    private String numOptNm2;
    
    /**
     * 숫자옵션명#3
     */
    @Column(length = 200)
    private String numOptNm3;
    
    /**
     * 숫자옵션명#4
     */
    @Column(length = 200)
    private String numOptNm4;
    
    /**
     * 숫자옵션명#5
     */
    @Column(length = 200)
    private String numOptNm5;
    
    /**
     * 비고
     */
    @Column(length = 1000)
    private String rmk;
}

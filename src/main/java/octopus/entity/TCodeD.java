package octopus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
import octopus.backend.v1.dto.TCodeDDto;

@Entity // jpa entity임을 알립니다.
@Getter // getter를 자동으로 생성합니다.
// @Setter // 객체가 무분별하게 변경될 가능성 있음
@ToString(exclude = { "crtId", "crtDt", "mdfId", "mdfDt" }) // 연관관계 매핑된 엔티티 필드는 제거. 연관 관계 필드는 toString()에서 사용하지 않는 것이
                                                            // 좋습니다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 인자없는 생성자를 자동으로 생성합니다. 기본 생성자의 접근 제어자가 불명확함. (access =
                                                   // AccessLevel.PROTECTED) 추가
// @AllArgsConstructor // 객체 내부의 인스턴스멤버들을 모두 가지고 있는 생성자를 생성 (매우 위험)
@Table(name = "T_CODE_D")
@IdClass(TCodeDPK.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // Post Entity에서 User와의 관계를 Json으로 변환시 오류 방지를 위한 코드
@Proxy(lazy = false)
public class TCodeD extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getId() {
        return this.cd;
    }
    
    @Builder
    public TCodeD(String pCd, String cd, String cdNm, String useYn, Integer sortSeq, String rmk, String wdOpt1,
            String wdOpt2, String wdOpt3, String wdOpt4, String wdOpt5, Integer numOpt1, Integer numOpt2,
            Integer numOpt3, Integer numOpt4, Integer numOpt5) {
        Assert.hasText(pCd, "pCd must not be empty");
        Assert.hasText(cd, "cd must not be empty");
        Assert.hasText(cdNm, "cdNm must not be empty");
        Assert.hasText(useYn, "useYn must not be empty");
        
        this.pCd     = pCd;
        this.cd      = cd;
        this.cdNm    = cdNm;
        this.useYn   = useYn;
        this.sortSeq = sortSeq;
        this.rmk     = rmk;
        this.wdOpt1  = wdOpt1;
        this.wdOpt2  = wdOpt2;
        this.wdOpt3  = wdOpt3;
        this.wdOpt4  = wdOpt4;
        this.wdOpt5  = wdOpt5;
        this.numOpt1 = numOpt1;
        this.numOpt2 = numOpt2;
        this.numOpt3 = numOpt3;
        this.numOpt4 = numOpt4;
        this.numOpt5 = numOpt5;
    }
    
    /**
     * 상세 Code Update
     */
    public void updateCodeD(TCodeDDto tCodeDDto) {
        this.cdNm    = tCodeDDto.getCdNm();
        this.useYn   = tCodeDDto.getUseYn();
        this.sortSeq = tCodeDDto.getSortSeq();
        this.rmk     = tCodeDDto.getRmk();
        this.wdOpt1  = tCodeDDto.getWdOpt1();
        this.wdOpt2  = tCodeDDto.getWdOpt2();
        this.wdOpt3  = tCodeDDto.getWdOpt3();
        this.wdOpt4  = tCodeDDto.getWdOpt4();
        this.wdOpt5  = tCodeDDto.getWdOpt5();
        this.numOpt1 = tCodeDDto.getNumOpt1();
        this.numOpt2 = tCodeDDto.getNumOpt2();
        this.numOpt3 = tCodeDDto.getNumOpt3();
        this.numOpt4 = tCodeDDto.getNumOpt4();
        this.numOpt5 = tCodeDDto.getNumOpt5();
    }
    
    /**
     * 상세 Code Update - 삭제
     */
    public void updateUseYn(TCodeDDto tCodeDDto) {
        this.useYn = tCodeDDto.getUseYn();
    }
    
    /**
     * 상위 코드
     */
    @Id // pk
    @NotEmpty
    @Column(nullable = false, unique = true, length = 50)
    private String pCd;
    
    /**
     * 코드
     */
    @Id // pk
    @NotEmpty
    @Column(nullable = false, unique = true, length = 50)
    private String cd;
    
    /**
     * 코드명
     */
    @NotEmpty
    @Column(nullable = false, length = 200)
    private String cdNm;
    
    /**
     * 사용여부
     */
    @NotEmpty
    @Column(nullable = false, length = 1)
    private String useYn = "N";
    
    /**
     * 정렬순서
     */
    @NotEmpty
    @Column(nullable = false, length = 4)
    private Integer sortSeq = 0;
    
    /**
     * 문자옵션명#1
     */
    @Column(length = 200)
    private String wdOpt1;
    
    /**
     * 문자옵션명#2
     */
    @Column(length = 200)
    private String wdOpt2;
    
    /**
     * 문자옵션명#3
     */
    @Column(length = 200)
    private String wdOpt3;
    
    /**
     * 문자옵션명#4
     */
    @Column(length = 200)
    private String wdOpt4;
    
    /**
     * 문자옵션명#5
     */
    @Column(length = 200)
    private String wdOpt5;
    
    /**
     * 숫자옵션명#1
     */
    @Column
    private Integer numOpt1;
    
    /**
     * 숫자옵션명#2
     */
    @Column
    private Integer numOpt2;
    
    /**
     * 숫자옵션명#3
     */
    @Column
    private Integer numOpt3;
    
    /**
     * 숫자옵션명#4
     */
    @Column
    private Integer numOpt4;
    
    /**
     * 숫자옵션명#5
     */
    @Column
    private Integer numOpt5;
    
    /**
     * 비고
     */
    @Column(length = 1000)
    private String rmk;
    
}

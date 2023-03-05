package octopus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder // builder를 사용할수 있게 합니다.
@Entity // jpa entity임을 알립니다.
@Getter // getter를 자동으로 생성합니다.
@Setter
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
@Table(name = "T_CODE_M")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // Post Entity에서 User와의 관계를 Json으로 변환시 오류 방지를 위한 코드
@Proxy(lazy = false)
public class TCodeM extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * 상위 코드
     */
    @Id // pk
    @Column(nullable = false, unique = true, length = 50)
    private String pCd;
    
    /**
     * 상위 코드명
     */
    @Column(nullable = false, length = 200)
    private String pCdNm;
    
    /**
     * 사용여부
     */
    @Column(nullable = false, length = 1)
    @Builder.Default
    private String useYn = "N";
    
    /**
     * 문자옵션명#1
     */
    @Column(length = 200)
    private String wdOptNm_1;
    
    /**
     * 문자옵션명#2
     */
    @Column(length = 200)
    private String wdOptNm_2;
    
    /**
     * 문자옵션명#3
     */
    @Column(length = 200)
    private String wdOptNm_3;
    
    /**
     * 문자옵션명#4
     */
    @Column(length = 200)
    private String wdOptNm_4;
    
    /**
     * 문자옵션명#5
     */
    @Column(length = 200)
    private String wdOptNm_5;
    
    /**
     * 숫자옵션명#1
     */
    @Column(length = 200)
    private String numOptNm_1;
    
    /**
     * 숫자옵션명#2
     */
    @Column(length = 200)
    private String numOptNm_2;
    
    /**
     * 숫자옵션명#3
     */
    @Column(length = 200)
    private String numOptNm_3;
    
    /**
     * 숫자옵션명#4
     */
    @Column(length = 200)
    private String numOptNm_4;
    
    /**
     * 숫자옵션명#5
     */
    @Column(length = 200)
    private String numOptNm_5;
    
    /**
     * 비고
     */
    @Column(length = 1000)
    private String rmk;
    
}

package octopus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder // builder를 사용할수 있게 합니다.
@Entity // jpa entity임을 알립니다.
@Getter // user 필드값의 getter를 자동으로 생성합니다.
@Setter
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
@Table(name = "customId") // 'CUSTOM_ID' 테이블과 매핑됨을 명시
@Proxy(lazy = false)
public class CustomId {
    @Id // pk
    @Column(name = "id_name", nullable = false, unique = true, length = 50)
    private String idName;
    
    /**
     * 구분자(S:직원, T:외부직원, Z:임시계정) + 년월일(8자리) + sequence(5자리)
     */
    @Column(name = "gubun",length = 1)
    private String gubun;
    
    @Column(name = "ymd",length = 8)
    private String ymd;
    
    @Column(name = "seq",length = 5)
    private String seq;
    
    @Column(name = "rmk",length = 200)
    private String rmk;
}
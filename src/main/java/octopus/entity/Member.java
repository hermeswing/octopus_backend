package octopus.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "member") // 'user' 테이블과 매핑됨을 명시
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // Post Entity에서 User와의 관계를 Json으로 변환시 오류 방지를 위한 코드
@Proxy(lazy = false)
public class Member extends CommonDateEntity {
	/**
     * 
     */
    private static final long serialVersionUID = 1246865649224168898L;

    /**
     * 구분자(S:직원, T:외부직원, Z:임시계정) + 년월일(8자리) + sequence(5자리) 
     */
    @Id          // pk
	@Column(nullable = false, unique = true, length = 14)
	private String memberId;
	
    @Column(nullable = false, length = 100)
    private String name;
	
    @Column(length = 100)
    private String email;
    
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(length = 100)
	private String password;
	
    @Column(length = 100)
    private LocalDateTime loginDateTime;
}
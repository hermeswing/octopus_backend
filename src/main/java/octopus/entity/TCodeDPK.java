package octopus.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;

@Data
public class TCodeDPK implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 상위 코드
     */
    @Id // pk
    @Column(nullable = false, unique = true, length = 50)
    private String pCd;
    
    /**
     * 코드
     */
    @Id // pk
    @Column(nullable = false, unique = true, length = 50)
    private String cd;
    
}

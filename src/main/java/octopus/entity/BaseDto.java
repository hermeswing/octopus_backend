package octopus.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * <pre>
 * </pre>
 */
@Data
public class BaseDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 생성자
     */
    private String crtId = "admin";
    
    /**
     * 생성일자
     */
    private LocalDateTime crtDt;
    
    /**
     * 수정자
     */
    private String mdfId = "admin";
    
    /**
     * 수정일
     */
    private LocalDateTime mdfDt;
    
}

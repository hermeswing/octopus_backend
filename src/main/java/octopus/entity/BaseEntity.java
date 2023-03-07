package octopus.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
	private LocalDateTime crtId;
	
    @CreatedDate
	private LocalDateTime crtDt;
	
	private LocalDateTime mdfId;
	
	@LastModifiedDate
	private LocalDateTime mdfDt;
	
	
}

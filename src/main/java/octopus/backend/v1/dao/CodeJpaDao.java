package octopus.backend.v1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import octopus.backend.v1.dto.TCodeDDto;
import octopus.entity.TCodeM;


//@Repository : JpaRepository를 사용하면 @Repository를 사용하지 않아도 됨. 
public interface CodeJpaDao extends JpaRepository<TCodeM, String> {
    TCodeM findBypCd(String pCd);
}

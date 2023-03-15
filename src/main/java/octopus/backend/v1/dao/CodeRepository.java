package octopus.backend.v1.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import octopus.entity.TCodeM;

// @Repository : JpaRepository를 사용하면 @Repository를 사용하지 않아도 됨.
public interface CodeRepository extends JpaRepository<TCodeM, String> {
    Optional<TCodeM> findBypCd(String pCd);
    
    int deleteBypCd(String pCd);
    
    // clearAutomatically : Persistence Context
    @Modifying(clearAutomatically = true)
    @Query("update TCodeM m set m.pCdNm = :pCdNm where m.pCd = :pCd")
    int updateTCodeM(@Param(value = "pCd") String pCd, @Param(value = "pCdNm") String pCdNm);
}
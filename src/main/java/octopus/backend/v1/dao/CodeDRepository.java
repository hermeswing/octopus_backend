package octopus.backend.v1.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import octopus.entity.TCodeD;

// @Repository : JpaRepository를 사용하면 @Repository를 사용하지 않아도 됨.
public interface CodeDRepository extends JpaRepository<TCodeD, String> {
    Optional<TCodeD> findBypCdAndCd(String pCd, String cd);
    
    //
    // clearAutomatically : Persistence Context
    @Modifying(clearAutomatically = true)
    @Query("update TCodeD m set m.cdNm = :cdNm where m.pCd = :pCd and m.cd = :cd")
    int updateTCodeD(@Param(value = "pCd") String pCd, @Param(value = "cd") String cd,
            @Param(value = "cdNm") String cdNm);
}
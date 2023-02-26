package octopus.backend.comm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import octopus.entity.CustomId;

@Repository
public interface CustomIdJpaDao extends JpaRepository<CustomId, String> {
    @Query(value = "SELECT A.MAX_ID || B.MAX_SEQ AS ID_NAME "
            + "  FROM ( "
            + "        SELECT 'S' || FORMATDATETIME(NOW(), 'yyyyMMdd') AS MAX_ID " 
            + "          FROM CUSTOM_ID " 
            + "         WHERE ID_NAME  = 'USER_ID' " 
            + "           AND YMD      = FORMATDATETIME(NOW(), 'yyyyMMdd') " 
            + "    ) A " 
            + "  , ( " 
            + "        SELECT MAX(SEQ) AS MAX_SEQ " 
            + "          FROM CUSTOM_ID " 
            + "         WHERE ID_NAME  = 'USER_ID' " 
            + "           AND YMD      = FORMATDATETIME(NOW(), 'yyyyMMdd') " 
            + "    ) B ", nativeQuery = true)
    List<CustomId> findGroupByCustomIdWithNativeQuery();
    
}

package octopus.backend.v1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import octopus.backend.v1.dto.MemberDto;
import octopus.entity.Member;

@Repository
public interface MemberJpaDao extends JpaRepository<Member, String> {
    List<Member> findByName(String name);

    Optional<Member> save(MemberDto memberDto);
}

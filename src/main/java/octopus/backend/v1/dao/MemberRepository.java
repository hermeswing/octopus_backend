package octopus.backend.v1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import octopus.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> findByName(String name);
}
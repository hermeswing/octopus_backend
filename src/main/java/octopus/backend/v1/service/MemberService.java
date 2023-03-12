package octopus.backend.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.advice.exception.CUserNotFoundException;
import octopus.backend.comm.dao.CustomIdJpaDao;
import octopus.backend.v1.dao.MemberRepository;
import octopus.backend.v1.dto.MemberDto;
import octopus.entity.Member;

@Service
@AllArgsConstructor
@Slf4j
public class MemberService {
    private CustomIdJpaDao customIdJpaDao;
    
    private MemberRepository memberRepository;
    
    @Transactional(readOnly = true)
    public MemberDto findById(String memberId) {
        Member user = memberRepository.findById(memberId).orElseThrow(CUserNotFoundException::new);
        return new MemberDto(user);
    }
    
    @Transactional(readOnly = true)
    public List<MemberDto> findAllMember() {
        return memberRepository.findAll().stream().map(MemberDto::new).collect(Collectors.toList());
    }
    
    // @Transactional
    // public String save(MemberDto memberDto) {
    // List<CustomId> list = customIdJpaDao.findGroupByCustomIdWithNativeQuery();
    //
    // log.debug("list :: {}", list);
    // if (list.size() == 0) {
    // SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
    // CustomId customeId = CustomId.builder().idName("USER_ID").gubun("S")
    // .ymd(dtFormat.format(new Date())).seq("00001").rmk("사원ID 생성").build();
    //
    // customeId = customIdJpaDao.save(customeId);
    //
    // list = customIdJpaDao.findGroupByCustomIdWithNativeQuery();
    //
    // log.debug("list :: {}", list);
    // }
    //
    // Optional<Member> saved = memberJpaDao.save(memberDto);
    // return saved.get().getMemberId();
    // }
    //
    // @Transactional
    // public String update(MemberDto memberDto) {
    // Optional<Member> updated = memberJpaDao.save(memberDto);
    // return updated.get().getMemberId();
    // }
    //
    // @Transactional
    // public void delete(String id) {
    // memberJpaDao.deleteById(id);
    // }
    
}
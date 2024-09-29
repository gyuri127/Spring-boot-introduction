package hello.hello_new_spring.repository;

import hello.hello_new_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);  //저장소에 저장됨
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll(); //모든회원리스트 반환
}

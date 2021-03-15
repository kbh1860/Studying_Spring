package Hello.HelloSpring.repository;

import Hello.HelloSpring.domain.Member;

import java.util.Optional;
import java.util.List;

public interface MemberRepository {

    Member save (Member member);
    Optional<Member> findById(Long id); //Optional = NULL일때 처리 방법
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 현재 저장된 모든 Member 반환
}

package hello.hello_new_spring.repository;

import hello.hello_new_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    //저장
    private  static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;  //키값 생성 -> 동시성 위해, 단순하게 한것임
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;

    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //이렇게하면 클라이언트에서 뭘 할 수 있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member ->member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //test를 위해
    public void clearStore(){
        store.clear();
    }
}

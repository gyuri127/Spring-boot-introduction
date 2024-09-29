package hello.hello_new_spring.repository;

import hello.hello_new_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();



    //데이터초기화 코드
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }



    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        //get으로 바로 꺼내는것이 좋은것은 아니지만 test에서는 가능. optional에서 값 가져올떄...?
        Member result = repository.findById(member.getId()).get();

        //요즘많이쓰는것->assertj
        assertThat(member).isEqualTo(result);
        //Assertions을 static import하면 다음부터는 바로 쓸 수 있음


        //글자로 보는 대신
       // Assertions.assertEquals(member, null);
        //같으면 아무일x 다르면 빨간색

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}

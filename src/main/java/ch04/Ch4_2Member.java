package ch04;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR",
        //영속성 컨텍스트에 넣기 위해 PK를 가져와야댐 -> 다음 시퀀스값 가져온뒤 영속성컨텍스트에 넣어줌
        //alllocationSize -> 네트워크 호출로 성능 하락 방지 -> DB에 미리 50개를 호출, 메모리에서 1씩 사용
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 50)//테이블도 동일하게 사용가능
/*@TableGenerator(//시퀀스 DB 테이블로 관리
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ")*/
public class Ch4_2Member {

    @Id
    /*
    GenerationType.IDENTITY
    Mysql -> 값을 넣으면 안됨 -> pk값을 db에서만 알수있음
    em.persist로 호출한 시점에 DB에 insert 쿼`리 날림 -> DB가 생성한 값을 읽어옴 -> JDBC드라이버에서 해줌
    -> ID값 알수 있는 시점이 DB에 값이 들어가야 알 수 있음
    ->
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    */
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    public Ch4_2Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

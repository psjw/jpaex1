package ch06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ch6_2Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

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

    //양방향 매핑시에 무한 루프
    //JSON 생성 라이브러리 오류 -> Entity를 Controller에서 Entity를 바로 반환
    //Controller에서 Entity 반환 하지 말자.
/*    @Override
    public String toString() {
        return "Ch5_5Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", team=" + team + //team의 toString() 호출
                '}';
    }*/
}

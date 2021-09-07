package ch06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ch6_6Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    // 일대다 양방향 설정 -> 읽기전용으로 만듬
    @JoinColumn(name="TEAM_ID", insertable = false, updatable = false)
    private Ch6_6Team team;

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Ch6_6Locker locker;

    @OneToMany(mappedBy = "members")
//    @JoinTable(name = "Ch6_5MEMBER_PRODUCT") //만약 자동으로 생성하면 다른 값을 넣을수 없어서 엔티티로 생성한다
    private List<Ch6_6Product> products = new ArrayList<>();

    public Ch6_6Member() {
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

    public Ch6_6Team getTeam() {
        return team;
    }

    public void setTeam(Ch6_6Team team) {
        this.team = team;
    }

    public Ch6_6Locker getLocker() {
        return locker;
    }

    public void setLocker(Ch6_6Locker locker) {
        this.locker = locker;
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

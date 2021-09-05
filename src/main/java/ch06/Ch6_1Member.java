package ch06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ch6_1Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    /*@Column(name = "TEAM_ID")
    private Long teamId;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }*/

    @ManyToOne // Member N : Team 1
    @JoinColumn(name = "TEAM_ID")
    private Ch6_1Team team;

    public Ch6_1Team getTeam() {
        return team;
    }

    //연관관계 주인 -> set메서드는 관례가 있기때문에 잘사용하지 않음
    public void setTeam(Ch6_1Team team) {
        this.team = team;
//        this.team.getMembers().add(this);
    }

    public void changeTeam(Ch6_1Team team) {
        this.team = team;
        this.team.getMembers().add(this);
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

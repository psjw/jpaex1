package ch05;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ch5_5Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team") //Team 1 : Member N -> member의 변수 team
    //mappedBy : 객체와 테이블간에 연관관계를 맺는 차이를 이해해야 한다.
    // new ArrayList<>() : null Ponint Exception등을 피하기위한 관례
    private List<Ch5_5Member> members = new ArrayList<>();

    public List<Ch5_5Member> getMembers() {
        return members;
    }

    public void addMember(Ch5_5Member member) {
        member.setTeam(this);
        members.add(member);
    }

    public void setMembers(List<Ch5_5Member> members) {
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


/*    @Override
    public String toString() {
        return "Ch5_5Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members=" + members + //members의 toSTring() 호출
                '}';
    }*/
}

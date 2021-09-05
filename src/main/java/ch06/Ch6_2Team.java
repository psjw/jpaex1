package ch06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ch6_2Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "TEAM_ID") // 사용하지 않으면 중간 테이블이 생긴다.
    private List<Ch6_2Member> members = new ArrayList<>();

    public List<Ch6_2Member> getMembers() {
        return members;
    }

    public void addMember(Ch6_2Member member) {
        members.add(member);
    }

    public void setMembers(List<Ch6_2Member> members) {
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

package ch06;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ch6_5Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
    @ManyToMany(mappedBy = "products")//양방향 관계설정
    private List<Ch6_5Member> members = new ArrayList<>();

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
}

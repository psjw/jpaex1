package ch03;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ch3Member {
    @Id
    private Long id;

    private String Name;

    public Ch3Member() {
    }

    public Ch3Member(Long id, String name) {
        this.id = id;
        Name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

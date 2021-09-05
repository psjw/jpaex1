package ch02;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//(name = "Member") -> 내부적 구분하는 이름 기본값 쓰는게 좋음
//@Table(name = "USER") -> DB Table명이 다를 경우(USER)
public class Ch2Member {
    @Id
    private Long id;

    @Column(unique = true, length = 10)
    //@Column(name="userName") -> DB 컬럼명이 다를경우
    private String name;

    public Ch2Member() {
    }

    public Ch2Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}


package ch07;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //싱글 테이블 전략 기본세팅 --> DTYPE 기본적으로 생성됨
//@Inheritance(strategy = InheritanceType.JOINED) //Join 테이블 전략
//@DiscriminatorColumn // DTYPE 컬럼 생성-> Entity 명이 기본으로 들어감
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 별도의 테이블로 세팅(Item 테이블 없음) -> 사용하지 않는게 좋음
public abstract class Ch7_1Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


/*
싱글 테이블 전략
create table Ch7_1Item (
       DTYPE varchar(31) not null,
        id bigint not null,
        name varchar(255),
        price integer not null,
        artist varchar(255),
        author varchar(255),
        isbn varchar(255),
        actor varchar(255),
        director varchar(255),
        primary key (id)
    )

 */

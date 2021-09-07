package ch06;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ch6_5Locker {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    //일대일 양방향
    @OneToOne(mappedBy = "locker")
    private Ch6_5Member member;
    
}
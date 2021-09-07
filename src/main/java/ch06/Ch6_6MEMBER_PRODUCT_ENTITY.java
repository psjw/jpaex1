package ch06;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Ch6_6MEMBER_PRODUCT_ENTITY {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Ch6_6Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Ch6_6Product product;

    private int count;
    private int price;
    private LocalDateTime orderDatetime;

}

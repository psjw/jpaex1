package ch07;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


//한테이블 전략
@Entity
@DiscriminatorValue("B")//임의의 값 설정
public class Ch7_1Book extends Ch7_1Item{
    private String author;
    private String isbn;
}


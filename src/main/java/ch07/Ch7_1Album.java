package ch07;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")//임의의 값 설정
public class Ch7_1Album extends Ch7_1Item{
    private String artist;
}

package ch04;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity//(name = "Member") -> 내부적 구분하는 이름 기본값 쓰는게 좋음
//@Table(name = "USER") -> DB Table명이 다를 경우(USER)
public class Ch4_1Member {
    @Id
    private Long id;


//    @Column(unique = true, length = 10) //Unique 제약조건, 길이
//    //@Column(name="userName") -> DB 컬럼명이 다를경우
//    private String Name;

    @Column(name = "name", insertable = true, updatable = true) //등록 변경 가능 여부
    //@Column( columnDefinition = "varchar(100) default 'EMPTY'") //columnDefinition 그대로 DB반영
//    @Column(nullable = false, unique = true) //notnull 허용여부 / unique 잘 사용하지 않음 : 이름이 알아보기 힘듬
    private String username;

    private int age;

    @Enumerated(EnumType.STRING) // ORDINAL(기본값) : 순서를 DB에 저장, STRING : 이름을 DB에 저장
    private RoleType roleType;

    // 자바 DATE : 날짜+시간
    // TIME : 날짜
    // TIMESTAMP  : 날짜 + 시간

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //별도의 어노테이션 없이도 인식가능
    private LocalDate testLocalDate; //날짜
    private LocalDateTime testLocalDateTime3; //날짜 + 시간

    @Lob //Clob or Blob
    private String description;

    @Transient // DataBase와 매핑하지 않음
    private int temp;

    public Ch4_1Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}

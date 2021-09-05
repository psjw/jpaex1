package ch03;

import ch02.Ch2Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain8 {
    public static void main(String[] args) {
        //persitence.xml -> <persistence-unit name="hello">
        //Application Loading 시점에 1회 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //트랜젝션 단위에서는 entityManager를 생성
        EntityManager entityManager = emf.createEntityManager();
        //트랜젝션설정
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            //실제 동작 코드 작성
            Ch3Member member1 = new Ch3Member(150L, "A");
            Ch3Member member2 = new Ch3Member(160L, "B");

            entityManager.persist(member1);
            entityManager.persist(member2);

            System.out.println("===============================");
            //트랜젝션 커밋 -> DB에 쿼리 호출
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }
}

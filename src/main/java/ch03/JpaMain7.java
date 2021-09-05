package ch03;

import ch02.Ch2Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain7 {
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
            //최초 DB 조회
            Ch3Member findMember1 = entityManager.find(Ch3Member.class, 101L);
            //1차 캐시에서 조회
            Ch3Member findMember2 = entityManager.find(Ch3Member.class, 101L);
            
            //영속성 엔티티 동일성 보장
            System.out.println("result : " + (findMember1 == findMember2));
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

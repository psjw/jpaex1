package ch03;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain5 {
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
            //비영속
            Ch3Member member = new Ch3Member();
            member.setId(101L);
            member.setName("HelloJPA");
            //영속 ->  영속성 컨텍스트에 의해 관리
            System.out.println("=== BEFORE ===");
            entityManager.persist(member);
            System.out.println("=== AFTER ===");
            //1차 캐쉬를 조회
            Ch3Member findMember = entityManager.find(Ch3Member.class, 101L);

            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

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

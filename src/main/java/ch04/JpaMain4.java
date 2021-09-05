package ch04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try{
            tr.begin();
            Ch4_2Member member1 = new Ch4_2Member();
            member1.setUsername("A");

            Ch4_2Member member2 = new Ch4_2Member();
            member2.setUsername("B");

            Ch4_2Member member3 = new Ch4_2Member();
            member3.setUsername("C");
            System.out.println("=============================");
//            Hibernate:
//            call next value for MEMBER_SEQ
//            Hibernate:
//            call next value for MEMBER_SEQ
            //2번 호출
            // DB_SEQ = 1   | 1
            // DB_SEQ = 51  | 2
            // DB_SEQ = 51  | 3
            em.persist(member1); // 1번  51개로 맞춤
            em.persist(member2); // Memory 호출
            em.persist(member3); // Memory 호출
            System.out.println("member1.id = "+member1.getId());
            System.out.println("member2.id = "+member2.getId());
            System.out.println("member3.id = "+member3.getId());
            System.out.println("=============================");
            tr.commit();
        }catch (Exception e){
            tr.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

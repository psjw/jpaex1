package ch04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try{
            tr.begin();
            Ch4_2Member member = new Ch4_2Member();
            member.setUsername("C");
            System.out.println("=============================");
            em.persist(member); // GenerationType.IDENTITY -> 이시점에 Insert하고 내부적으로 영속성 컨텍스트 PK로 사용
            System.out.println("member.id = "+member.getId());
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

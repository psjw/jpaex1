package ch06;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();

            Ch6_2Member member = new Ch6_2Member();
            member.setUsername("Member1");

            em.persist(member);

            Ch6_2Team team = new Ch6_2Team();
            team.setName("TeamA");
            //외래키가 변경되야 됨 (Ch6_2Member 테이블의 외래키 업데이트)
            team.getMembers().add(member);

            em.persist(team);



            //DB에서 직접 조회되는것 확인
            em.flush(); // 쿼리 DB에 날림
            em.clear(); // 1차캐시 삭제


            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

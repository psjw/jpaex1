package ch05;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try{
            tr.begin();
            //객체지향 스럽지 않음

            Ch5_3Member member = new Ch5_3Member();
            member.setUsername("member1");
            em.persist(member);

            Ch5_3Team team = new Ch5_3Team();
            team.setName("TeamA");
            //Ch5_3Member 테이블의 TEAM ID가 NULL이다.
            //연관관계 주인은 Ch5_3Member다.
            team.getMembers().add(member);
            em.persist(team);


            //DB에서 직접 조회되는것 확인
            em.flush(); // 쿼리 DB에 날림
            em.clear(); // 1차캐시 삭제


            tr.commit();
        }catch (Exception e){
            tr.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

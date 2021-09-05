package ch05;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try{
            tr.begin();
            //객체지향 스럽지 않음
            Ch5_1Team team = new Ch5_1Team();
            team.setName("TEAMA");
            em.persist(team); //PK값이 세팅되고 영속상태

            Ch5_1Member member = new Ch5_1Member();
            member.setUsername("member1");
            member.setTeamId(team.getId());
            em.persist(member);

            Ch5_1Member findMember = em.find(Ch5_1Member.class, member.getId());
            Long findTeamId = findMember.getTeamId();
            Ch5_1Team findTeam = em.find(Ch5_1Team.class, findTeamId);

            tr.commit();
        }catch (Exception e){
            tr.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

package ch05;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_5 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            //객체지향 스럽지 않음
            Ch5_3Team team = new Ch5_3Team();
            team.setName("TeamA");
            em.persist(team);

            Ch5_3Member member = new Ch5_3Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);


            //Ch5_3Team 에는 별도로 넣어준다.
            team.getMembers().add(member); //별도로 안넣어주어도 조회시 조회가 됨

            em.flush();
            em.clear();

            Ch5_3Team findTeam = em.find(Ch5_3Team.class, team.getId()); //1차 캐시
            List<Ch5_3Member> members = findTeam.getMembers();

            System.out.println("=================");
            System.out.println(findTeam);
            for (Ch5_3Member m : members) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("=================");


            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

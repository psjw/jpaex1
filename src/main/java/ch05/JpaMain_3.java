package ch05;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try{
            tr.begin();
            //객체지향 스럽지 않음
            Ch5_3Team team = new Ch5_3Team();
            team.setName("TeamA");
            em.persist(team);

            Ch5_3Member member = new Ch5_3Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);
            
            //DB에서 직접 조회되는것 확인
            em.flush(); // 쿼리 DB에 날림
            em.clear(); // 1차캐시 삭제

            Ch5_3Member findMember = em.find(Ch5_3Member.class, member.getId());
            List<Ch5_3Member> members = findMember.getTeam().getMembers();
            //양방향은 별로 좋지 않음 -> 단방향이 좋다.
            for(Ch5_3Member m : members){
                System.out.println("m = "+m.getUsername());
            }

            tr.commit();
        }catch (Exception e){
            tr.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

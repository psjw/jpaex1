package ch05;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try{
            tr.begin();
            //객체지향 스럽지 않음
            Ch5_2Team team = new Ch5_2Team();
            team.setName("TeamA");
            em.persist(team);

            Ch5_2Member member = new Ch5_2Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member); //알아서 team에서 FK값 꺼네서 사용
            
            //DB에서 직접 조회되는것 확인, 1차 캐시에서 가져오는것이아니라 DB에서 가져오기 위해 작성
            em.flush(); // 쿼리 DB에 날림
            em.clear(); // 1차캐시 삭제

            Ch5_2Member findMember = em.find(Ch5_2Member.class, member.getId());
            Ch5_2Team findTeam = findMember.getTeam();
            System.out.println("findTeam.getName() = " + findTeam.getName()); //영속성 컨텍스트에서 가져옴

            //Member의 팀변경
            Ch5_2Team newTeam = em.find(Ch5_2Team.class, 100L);
            findMember.setTeam(newTeam);

            tr.commit();
        }catch (Exception e){
            tr.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

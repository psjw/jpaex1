package ch05;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_7 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            //객체지향 스럽지 않음
            Ch5_5Team team = new Ch5_5Team();
            team.setName("TeamA");
            em.persist(team);

            Ch5_5Member member = new Ch5_5Member();
            member.setUsername("member1");
            //기존 setMethod의 관례가 있으므로 별도의 연관관계 맵핑 메서드 생성해준다.
            //member.setTeam(team);
            member.changeTeam(team);
            em.persist(member);

            //연관관계 맵핑 메서드 방법2
            //하나만 쓰도록 설정
            //team1.addMember(member6);

            //넣지 않아도 정상조회는 가능하지만
            //하단의 코드를 넣어주어야 객체지향적인 개념상 완벽
            // 문제
            // 1. flush(), clear()를 안하면 문제 -> 1차캐시에는 값세팅 안되어 있음
            // 2. test케이스 작성할 경우
            // 해결책 Members에 setTeam에 설정(연관관계 편의 메서드)
            //Ch5_3Team 에는 별도로 넣어준다.
            //team.getMembers().add(member);

//            em.flush();
//            em.clear();

            Ch5_5Team findTeam = em.find(Ch5_5Team.class, team.getId()); //1차 캐시
            List<Ch5_5Member> members = findTeam.getMembers();

            System.out.println("=================");
            //Member6 -> team
            //Team1 -> members
            //무한 루프 서로간 계속 변환 -> 참조 변수 제거 하고 사용
            // JSON 라이브러인 경우 -> 컨트롤러에서 Entity 반환하면 안됨 (Entity변경시 API Spec변경되버림)
            System.out.println(findTeam);
            for (Ch5_5Member m : members) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("=================");

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

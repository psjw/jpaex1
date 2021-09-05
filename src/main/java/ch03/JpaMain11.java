package ch03;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain11 {
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
            Ch3Member member = entityManager.find(Ch3Member.class, 200L);
            member.setName("AAAAA");
            //준영속상태가 되면서 update쿼리 안날라감
            //entityManager.detach(member);
            //영속성 컨텍스트 초기화 (1차 캐시 삭제)
            entityManager.clear();

            //다시 조회하여 영속성 컨텍스트에 올림
            Ch3Member member2 = entityManager.find(Ch3Member.class, 200L);

            System.out.println("====================");

            //커밋시점에 Entity 와 스냅샷 비교
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

package ch07;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();

            Ch7_1Movie movie = new Ch7_1Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbbb");
            movie.setName("바람과함께 사라지다");
            movie.setPrice(10000);
            em.persist(movie);
            em.flush();
            em.clear();
//            Ch7_1Movie findMovie = em.find(Ch7_1Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);
            Ch7_1Item findItem = em.find(Ch7_1Item.class, movie.getId());
            System.out.println("findItem = " + findItem); // 문제점 : union로 조회함
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

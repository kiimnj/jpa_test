package jpajava;

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeFindTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        System.out.println("트랜잭션 시작 !!!");
        Employee e1 = em.find(Employee.class, "202301");
        em.flush();
        System.out.println("DB에서 가져옴");
        System.out.println("영속 상태");
        Employee e2 = em.find(Employee.class, "202301");
        System.out.println("1차 캐시에서 가져옴");
        System.out.println("e1 == e2 ==> " + (e1==e2));

        System.out.println("커밋 전");
        tx.commit();
        System.out.println("커밋 후");
        em.close();
        emf.close();
    }
}

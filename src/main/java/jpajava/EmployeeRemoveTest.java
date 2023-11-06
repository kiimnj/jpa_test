package jpajava;

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeRemoveTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            System.out.println("트랜잭션 시작 !!!");
            Employee e1 = em.find(Employee.class, "202301");
            System.out.println("DB에서 가져옴");
            System.out.println("영속 상태");

            em.remove(e1);
            System.out.println("removed 상태");

            System.out.println("커밋 전");
            tx.commit();
            System.out.println("커밋 후");

            Employee e2 = em.find(Employee.class, "202301");
            System.out.println("DB 에서 가져옴");
            System.out.println("e2 is null ? ==> " + (e2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}

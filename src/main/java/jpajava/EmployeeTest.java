package jpajava;

import domain.EmpType;
import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            System.out.println("트랜잭션 시작 !!!");
            Employee emp = new Employee("202301", "test1", null, EmpType.B, "2023-01-01", 300L);
//            emp.setEmpId("202301");
//            emp.setEmpName("홍길동");
//            emp.setDeptId(1);
//            emp.setJoinDate("2023-01-01");
//            emp.setSalary(100_000_000L);
            System.out.println("비영속 상태");
            em.persist(emp);
            System.out.println("영속 상태");
            em.find(Employee.class, "202301");
            System.out.println("1차 캐시에서 가져옴");
            System.out.println("커밋 전");
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        }
        System.out.println("커밋 후");
        em.close();
        emf.close();
    }
}

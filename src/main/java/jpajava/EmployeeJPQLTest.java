package jpajava;

import domain.EmpType;
import domain.Employee;

import javax.persistence.*;
import java.util.List;

public class EmployeeJPQLTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        System.out.println("트랜잭션 시작 !!!");

        Employee e1 = new Employee("202306", "test6", null, EmpType.A, "2023-01-01", 200L);

        em.persist(e1);

        Employee e2 = new Employee("202307", "test7", null, EmpType.C, "2023-01-01", 100L);

        em.persist(e2);

//        String jpql = "select e from Employee e where e.deptId = :deptId";
//        em.flush(); // flushmode = auto 임
//        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
//        query.setParameter("deptId", 1);
//        List<Employee> resultList = query.getResultList();
//        System.out.println("dept 1 에는 " + resultList.size() + "명의 사원이 있음");
        
//        jpql = "select count(e), sum(e.salary), avg(e.salary), max(e.salary), min(e.salary) from Employee e" ;
//        Object singleResult = em.createQuery(jpql).getSingleResult();

        System.out.println("DB에서 가져옴");
        System.out.println("영속 상태");
        Employee e3 = em.find(Employee.class, "202301");
        System.out.println("1차 캐시에서 가져옴");

        System.out.println("커밋 전");
        tx.commit();
        System.out.println("커밋 후");
        em.close();
        emf.close();
    }
}

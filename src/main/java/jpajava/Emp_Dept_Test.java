package jpajava;

import domain.Department;
import domain.EmpType;
import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Emp_Dept_Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            System.out.println("트랜잭션 시작 !!!");

            Department dept = new Department();
            dept.setDeptName("Team1");
            em.persist(dept);  // 즉시 insert

            Employee emp = new Employee(
                    "202301", "test1", dept,
                    EmpType.B, "2023-01-01", 300L);
            em.persist(emp);  // 지연 쓰기

//            Department d1 = em.find(Department.class, dept.getDeptId());
            Employee e1 = em.find(Employee.class, emp.getEmpId());
            e1.getDepartment();

            System.out.println("1차 캐시에서 가져옴");
            System.out.println("커밋 전");
            tx.commit();
            System.out.println("커밋 후");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}

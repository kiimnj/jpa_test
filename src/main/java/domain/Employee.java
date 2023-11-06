package domain;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="emp_id", length = 6)
    private String empId;
    @Column(name="emp_name", nullable = false, length = 10)
    private String empName;
//    @Column(name="dept_id")
//    private int deptId;
    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;
    @Enumerated(EnumType.STRING)
    private EmpType empType;
    @Column(name="join_date", nullable = false, length = 10)
    private String joinDate;
    @Column(nullable = false)
    private Long salary;

    public Employee() {
    }

    public Employee(String empId, String empName, Department department, EmpType empType, String joinDate, Long salary) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.joinDate = joinDate;
        this.salary = salary;
        this.empType= empType;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public EmpType getEmpType() {
        return empType;
    }

    public void setEmpType(EmpType empType) {
        this.empType = empType;
    }
}

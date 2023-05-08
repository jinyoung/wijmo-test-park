package wijmotestpark.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import wijmotestpark.BasicApplication;
import wijmotestpark.domain.EmployeeAdded;

@Entity
@Table(name = "Employee_table")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String userName;

    @Embedded
    @AttributeOverride(
        name = "id",
        column = @Column(name = "rnakId", nullable = true)
    )
    private RnakId rnakId;

    @Embedded
    @AttributeOverride(
        name = "id",
        column = @Column(name = "departmentId", nullable = true)
    )
    private DepartmentId departmentId;

    @PostPersist
    public void onPostPersist() {
        EmployeeAdded employeeAdded = new EmployeeAdded(this);
        employeeAdded.publishAfterCommit();
    }

    public static EmployeeRepository repository() {
        EmployeeRepository employeeRepository = applicationContext()
            .getBean(EmployeeRepository.class);
        return employeeRepository;
    }

    public static ApplicationContext applicationContext() {
        return BasicApplication.applicationContext;
    }
}

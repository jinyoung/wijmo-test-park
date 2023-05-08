package wijmotestpark.domain;

import java.util.*;
import lombok.*;
import wijmotestpark.domain.*;
import wijmotestpark.infra.AbstractEvent;

@Data
@ToString
public class EmployeeAdded extends AbstractEvent {

    private Long id;
    private String userId;
    private String userName;
    private RnakId rnakId;
    private DepartmentId departmentId;

    public EmployeeAdded(Employee aggregate) {
        super(aggregate);
    }

    public EmployeeAdded() {
        super();
    }
}

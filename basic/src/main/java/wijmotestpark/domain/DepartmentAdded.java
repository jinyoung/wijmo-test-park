package wijmotestpark.domain;

import java.util.*;
import lombok.*;
import wijmotestpark.domain.*;
import wijmotestpark.infra.AbstractEvent;

@Data
@ToString
public class DepartmentAdded extends AbstractEvent {

    private Long id;
    private String name;

    public DepartmentAdded(Department aggregate) {
        super(aggregate);
    }

    public DepartmentAdded() {
        super();
    }
}

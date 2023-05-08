package wijmotestpark.domain;

import java.util.*;
import lombok.*;
import wijmotestpark.domain.*;
import wijmotestpark.infra.AbstractEvent;

@Data
@ToString
public class RankAdded extends AbstractEvent {

    private Long id;
    private String name;

    public RankAdded(Rank aggregate) {
        super(aggregate);
    }

    public RankAdded() {
        super();
    }
}

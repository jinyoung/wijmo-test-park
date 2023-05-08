package wijmotestpark.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import wijmotestpark.domain.*;

@Component
public class EmployeeHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Employee>> {

    @Override
    public EntityModel<Employee> process(EntityModel<Employee> model) {
        return model;
    }
}

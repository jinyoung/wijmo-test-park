package wijmotestpark.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import wijmotestpark.domain.*;

@RepositoryRestResource(collectionResourceRel = "ranks", path = "ranks")
public interface RankRepository
    extends PagingAndSortingRepository<Rank, Long> {}

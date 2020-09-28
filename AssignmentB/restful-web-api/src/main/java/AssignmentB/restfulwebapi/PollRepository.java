package AssignmentB.restfulwebapi;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PollRepository extends PagingAndSortingRepository<Poll, Integer>{
	
	Poll findById(@Param("id") int id);
	
}

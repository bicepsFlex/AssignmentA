package AssignmentB.restfulwebapi;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends PagingAndSortingRepository<User, String>{
	
	User findByFname(@Param("Fname") String Fname);
	
}

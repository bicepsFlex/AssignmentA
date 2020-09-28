package AssignmentB.restfulwebapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class RestController {

	@Autowired
	private PollRepository pollRepository;
	
	@PutMapping("/polls/{id}/setVotes")
	public ResponseEntity<Poll> setVotes(@RequestBody Poll poll, @PathVariable int id) {
		Optional<Poll> pollOpt = pollRepository.findById(id);
		if (!pollOpt.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		Poll pollOld = pollOpt.get();
		
		pollOld.setVoteGreen(poll.getVoteGreen());
		pollOld.setVoteRed(poll.getVoteRed());
		pollRepository.save(pollOld);
		return ResponseEntity.ok(pollOld);
	}
	
	@PutMapping("/polls/{id}/update")
	public ResponseEntity<Poll> updatePoll(@RequestBody Poll poll, @PathVariable int id){
		Optional<Poll> pollOpt = pollRepository.findById(id);
		if (!pollOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Poll pollOld = pollOpt.get();
		if(poll.getName() != null) pollOld.setName(poll.getName());
		if(poll.getDescription() != null) pollOld.setDescription(poll.getDescription());
		if(poll.isPublic() != pollOld.isPublic()) pollOld.setPublic(poll.isPublic());
		if(poll.getStatus() != null) pollOld.setStatus(poll.getStatus());
		
		pollRepository.save(pollOld);
		return ResponseEntity.ok(pollOld);
		
	}

}

package assignment.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PollDAOClass implements PollDAO {
	private static final String PERSISTENCE_UNIT_NAME = "assignment";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
	
	@Override
	public List<Poll> getAllPolls() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getPoll(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePollDescription(Poll poll, String newDesc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePoll(Poll poll) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPollVotes(Poll poll) {
		// TODO Auto-generated method stub
		return null;
	}

}

package assignment.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PollDAOClass implements PollDAO {
	private static final String PERSISTENCE_UNIT_NAME = "assignment";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
	
	@Override
	public List<Poll> getAllPolls() {
	    Query quser = em.createQuery("SELECT p FROM Poll p");
	    List<Poll> pollList = quser.getResultList();
		return pollList;
	}

	@Override
	public List<Poll> getPoll(String Name) {
		Query quser = em.createQuery("SELECT p FROM Poll p WHERE p.Name LIKE :Name");
		quser.setParameter("Name", "%"+Name+"%");
		List<Poll> polls = quser.getResultList();
		return polls;
	}

	@Override
	public void updatePollDescription(Poll poll, String newDesc) {
		em.getTransaction().begin();
		poll.setDescription(newDesc);
		em.persist(poll);
//		em.getTransaction().commit();
//		em.close();
	}

	@Override
	public void deletePoll(Poll poll) {
//		em.getTransaction().begin();
		poll.getUser().removePoll(poll);
		Query qdelete = em.createQuery("DELETE FROM Poll p WHERE p.PollID = :PollID");
		qdelete.setParameter("PollID", poll.getPollID()).executeUpdate();
//		em.getTransaction().commit();
//		em.close();
	}

	@Override
	public void pollAddVotes(Poll poll, Users user, int green, int red) {
//		em.getTransaction().begin();
		poll.setVoteGreen(green);
		poll.setVoteRed(red);
		poll.setUsersVoted(user);
//		em.merge(poll);
//		em.getTransaction().commit();
//		em.close();
	}
	
	@Override
	public String getPollVotes(Poll poll) {
		return ("Green: "+ poll.getVoteGreen() +", Red: "+ poll.getVoteRed());
	}

	public void createPoll(String Name, String Description, boolean isPublic, String Status, Users Creator) {
//		em.getTransaction().begin();
		Poll poll = new Poll();
		poll.setName(Name);
		poll.setDescription(Description);
		poll.setPublic(isPublic);
		poll.setVoteGreen(0);
		poll.setVoteRed(0);
		poll.setStatus(Status);
		poll.setTimeLimit(2);
		Creator.setPolls(poll);
		em.merge(Creator);
//		em.getTransaction().commit();
//		em.close();
	}
	
}

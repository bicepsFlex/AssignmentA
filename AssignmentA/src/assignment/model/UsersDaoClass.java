package assignment.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsersDaoClass implements UsersDao {
	private static final String PERSISTENCE_UNIT_NAME = "assignment";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();

	@Override
	public List<Users> getAllUsers() {
	    Query quser = em.createQuery("SELECT u FROM Users u");
	    List<Users> userList = quser.getResultList();
		return userList;
	}

	@Override
	public Users getUser(String Uname) {
		Query quser = em.createQuery("SELECT u FROM Users u WHERE u.Uname = :user");
		quser.setParameter("user", Uname);
		Users user = (Users)quser.getSingleResult();
		return user;
	}

	@Override
	public void updateUserFname(Users user, String newFname) {
		user.setFname(newFname);
		em.persist(user);
	}

	@Override
	public void deleteUser(Users user) {
		em.getTransaction().begin();
		Query qpolldelete = em.createQuery("SELECT p FROM Poll p WHERE p.User = :user");
		qpolldelete.setParameter("user", user);
		List<Poll> pollRes = qpolldelete.getResultList();
		if(pollRes.size() > 0) {
			for(Poll poll : pollRes) {
				em.remove(poll);
			}
		}
		Query qdelete = em.createQuery("DELETE FROM Users u WHERE u.Uname = :user");
		qdelete.setParameter("user", user.getUname()).executeUpdate();
	}

	@Override
	public List<Poll> getUserPolls(Users user) {
	    Query quserpoll = em.createQuery("SELECT p FROM Poll p WHERE p.User = :user");
	    quserpoll.setParameter("user", user);
	    List<Poll> userpollList = quserpoll.getResultList();
		return userpollList;
	}

}

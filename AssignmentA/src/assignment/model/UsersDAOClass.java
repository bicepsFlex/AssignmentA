package assignment.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsersDAOClass implements UsersDAO {
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
//		em.getTransaction().begin();
		user.setFname(newFname);
		em.persist(user);
//		em.getTransaction().commit();
//		em.close();
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
//		em.getTransaction().commit();
//		em.close();
	}

	@Override
	public List<Poll> getUserPolls(Users user) {
		return user.getPolls();
	}

	public void createUser(String Uname, String Fname, String Lname, String Password, String Email) {
//		em.getTransaction().begin();
		Users user = new Users();
		user.setUname(Uname);
		user.setFname(Fname);
		user.setLname(Lname);
		user.setPassword(Password);
		user.setEmail(Email);
		user.setAdmin(true);
		em.persist(user);
//		em.getTransaction().commit();
//		em.close();
	}
}

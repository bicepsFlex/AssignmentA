package assignment.main;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import assignment.model.Poll;
import assignment.model.Users;


public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "assignment";
    private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

//        createUser("bicepsFlex","Jarek","Pasiak","12345","wojapak@gmail.com");

        Query qus = em.createQuery("select u from Users u WHERE u.Uname = :Uname");
        qus.setParameter("Uname", "xhexorikx");
        Users user = (Users)qus.getSingleResult();
        
        createPoll("Test", "Test Poll", false, "Past", user);
//        Query qdelete = em.createQuery("SELECT p FROM Poll p where p.Status = :Status");
//        qdelete.setParameter("Status", "Future");
//        List<Poll> delList = qdelete.getResultList();
//        em.getTransaction().begin();
//        for(Poll delpoll : delList) {
//        	em.remove(delpoll);
//        }
//        em.getTransaction().commit();
        
        Query qsearch = em.createQuery("SELECT p FROM Poll p where p.User = :User");
        qsearch.setParameter("User", user);
        List<Poll> searchList = qsearch.getResultList();
        em.getTransaction().begin();
        for(Poll searchPoll : searchList) {
        	System.out.println(searchPoll);
        }
        em.persist(user);
        em.getTransaction().commit();
        
        // read the existing entries and write to console
//        Query quser = em.createQuery("select u from Users u");
//        List<Users> userList = quser.getResultList();
//        for (Users users : userList) {
//            System.out.println(users);
//        }
//        Query qpoll = em.createQuery("SELECT p FROM Poll p");
//        List<Poll> pollList = qpoll.getResultList();
//        for (Poll polls : pollList) {
//        	System.out.println(polls);
//        }

        em.close();
	}
	
	private static void createUser(String Uname, String Fname, String Lname, String Password, String Email) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		Users user = new Users();
		user.setUname(Uname);
		user.setFname(Fname);
		user.setLname(Lname);
		user.setPassword(Password);
		user.setEmail(Email);
		user.setAdmin(true);
		em.persist(user);
		em.getTransaction().commit();
	}
	
	private static void createPoll(String Name, String Description, boolean isPublic, String Status, Users Creator) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		Poll poll = new Poll();
		poll.setName(Name);
		poll.setDescription(Description);
		poll.setPublic(isPublic);
		poll.setVoteGreen(0);
		poll.setVoteRed(0);
		poll.setStatus(Status);
		poll.setTimeLimit(2);
		poll.setUser(Creator);
		Creator.setPolls(poll);
		em.persist(poll);
		em.getTransaction().commit();
	}

}

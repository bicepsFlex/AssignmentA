package assignment.main;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.jpa.jpql.parser.TrimExpression.Specification;

import assignment.model.Poll;
import assignment.model.PollDAO;
import assignment.model.PollDAOClass;
import assignment.model.Users;
import assignment.model.UsersDAO;
import assignment.model.UsersDAOClass;


public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "assignment";
    private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

//        createUser("xHexorikx","Wojtek","Pasiak","54321","wojtpa@gmail.com");
//        createUser("bicepsFlex","Jarek","Pasiak","12345","wojapa@gmail.com");
        
        UsersDAOClass uDao = new UsersDAOClass();
        Users user = uDao.getUser("bicepsFlex");
        
//        createPoll("Second poll", "Let's make one more", true, "Future", user);
//        PDAO();
        UDAO();
        
        em.close();
	}
	
	/**
	 * Creates a user with given parameters
	 * @param Uname Username of the User
	 * @param Fname Users first name
	 * @param Lname Users last name
	 * @param Password Password for the user
	 * @param Email User Email address
	 */
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
	
	/**
	 * Creates a Poll with given parameters
	 * @param Name Name of the poll
	 * @param Description Description to describe the poll
	 * @param isPublic =true if poll is to be public
	 * @param Status Status of the poll {Past, Present, Future}
	 * @param Creator User that created the poll
	 */
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
		Creator.setPolls(poll);
		em.merge(Creator);
		em.getTransaction().commit();
	}
	
	private static void PDAO() {
        PollDAO pdao = new PollDAOClass();
        
		List<Poll> plist = pdao.getAllPolls();
        System.out.println("List of all Polls:");
        for (Poll polls : plist) {
            System.out.println(polls);
        }
        
        List<Poll> specPoll = pdao.getPoll("F");
        System.out.println("List of Polls including specific string in name:");
        for (Poll specPolls : specPoll) {
        	System.out.println(specPolls);
        }
        
        pdao.updatePollDescription(plist.get(2), "new Description");
        List<Poll> plist1 = pdao.getAllPolls();
        System.out.println("List of all Polls after updating one Description:");
        for (Poll polls : plist1) {
            System.out.println(polls);
        }
        
        pdao.deletePoll(plist.get(0));
        List<Poll> plist2 = pdao.getAllPolls();
        System.out.println("List of all Polls afte deleting one Poll:");
        for (Poll polls : plist2) {
            System.out.println(polls);
        }

        UsersDAO uDao = new UsersDAOClass();
        Users user = uDao.getUser("bicepsFlex");
        
        pdao.pollAddVotes(plist.get(0), user, 2, 1);
        
        int poll = 0;
        System.out.println("All votes on poll: "+ plist.get(poll).getPollID());
        System.out.println(pdao.getPollVotes(plist.get(poll)));
	}

	private static void UDAO() {
        UsersDAO udao = new UsersDAOClass();
        
        List<Users> ulist = udao.getAllUsers();
        System.out.println("List of all Users:");
        for (Users users : ulist) {
            System.out.println(users);
        }
        
        Users oneUser = udao.getUser("bicepsFlex");
        System.out.println("One specific user:");
        System.out.println(oneUser);
        
        udao.updateUserFname(ulist.get(1), "biceps");
        System.out.println("Updated First name to all caps:");
        List<Users> ulist1 = udao.getAllUsers();
        for (Users users : ulist1) {
            System.out.println(users);
        }

        udao.deleteUser(ulist.get(1));
        System.out.println("Delete One user:");
        List<Users> ulist2 = udao.getAllUsers();
        for (Users users : ulist2) {
            System.out.println(users);
        }
        
        int user = 1;
        List<Poll> pulist = udao.getUserPolls(ulist.get(user));
        System.out.println("List of Polls for " + ulist.get(user).getUname() + " :");
        for (Poll users : pulist) {
            System.out.println(users);
        }
	}
}

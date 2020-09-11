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
        
        
        Users user = new Users();
        user.setUname("bicepsFlex");
        user.setFname("Jarek");/*
        em.getTransaction().begin();
        Poll poll = new Poll();
        poll.setName("First Poll");
        poll.setDescription("Testing JPA");
        poll.setPublic(true);
        poll.setVoteGreen(0);
        poll.setVoteRed(0);
        poll.setStatus("Future");
        poll.setTimeLimit(2);
        poll.setUname(user);
        em.persist(poll);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        Users user = new Users();
        user.setUname("bicepsFlex");
        user.setFname("Jarek");
        user.setLname("Pasiak");
        user.setPassword("1234");
        user.setEmail("wojapa@gmail.com");
        user.setAdmin(true);
        em.persist(user);
        em.getTransaction().commit();
        */
        // read the existing entries and write to console
        Query quser = em.createQuery("select u from Users u");
        List<Users> userList = quser.getResultList();
        for (Users users : userList) {
            System.out.println(users);
        }/*
        Query qdelete = em.createQuery("SELECT p FROM Poll p where p.Status = :Status");
        qdelete.setParameter("Status", "Future");
        List<Poll> delList = qdelete.getResultList();
        em.getTransaction().begin();
        for(Poll delpoll : delList) {
        	em.remove(delpoll);
        }
        em.getTransaction().commit();
        */
        Query qpoll = em.createQuery("SELECT p FROM Poll p");
        List<Poll> pollList = qpoll.getResultList();
        for (Poll polls : pollList) {
        	System.out.println(polls);
        }/*
        Query qrelation = em.createQuery("SELECT p FROM Poll p WHERE p.Uname = :Uname");
        qrelation.setParameter("Uname", user);
        List<Poll> relList = qrelation.getResultList();
        for (Poll polls : relList) {
        	System.out.println(polls);
        }*/
        
        System.out.println("Size: " + userList.size());

        em.close();
	}

}

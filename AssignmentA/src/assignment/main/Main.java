package assignment.main;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import assignment.model.Poll;
import assignment.model.PollDAO;
import assignment.model.PollDAOClass;
import assignment.model.Users;
import assignment.model.UsersDAO;
import assignment.model.UsersDAOClass;


public class Main {
	    
	public static void main(String[] args) {
        
        UDAO();
//        PDAO();
	}
	
	private static void PDAO() {
        PollDAO pdao = new PollDAOClass();
        
        UsersDAO uDao = new UsersDAOClass();
        Users user = uDao.getUser("bicepsFlex");
        
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
        System.out.println("List of all Polls after deleting one Poll:");
        for (Poll polls : plist2) {
            System.out.println(polls);
        }
        
        pdao.createPoll("Second poll", "Let's make one more", true, "Future", user);
        
        pdao.pollAddVotes(plist.get(0), user, 2, 1);
        
        int poll = 0;
        System.out.println("All votes on poll: "+ plist.get(poll).getPollID());
        System.out.println(pdao.getPollVotes(plist.get(poll)));
        
	}

	private static void UDAO() {
        UsersDAO udao = new UsersDAOClass();
        
        udao.createUser("DAT250","Software","Engineering","12345","uib@hvl.no");
        
        List<Users> ulist = udao.getAllUsers();
        System.out.println("List of all Users:");
        for (Users users : ulist) {
            System.out.println(users);
        }
        
        Users oneUser = udao.getUser("bicepsFlex");
        System.out.println("One specific user:");
        System.out.println(oneUser);
        
        udao.updateUserFname(ulist.get(1), "biceps");
        System.out.println("Updated First name to a new given name:");
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

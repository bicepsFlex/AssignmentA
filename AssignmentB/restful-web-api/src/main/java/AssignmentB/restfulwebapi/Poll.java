package AssignmentB.restfulwebapi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Poll {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PollID;
	private String Name;
	private String Description;
	private boolean isPublic;
	private int VoteGreen;
	private int VoteRed;
	private String Status;
	private int TimeLimit;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	private User User;

	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<User> usersVoted = new ArrayList<User>();
	
	public int getPollID() {
		return PollID;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		this.Description = description;
	}
	
	public boolean isPublic() {
		return isPublic;
	}
	
	public void setPublic(boolean Public) {
		this.isPublic = Public;
	}
	
	public int getVoteGreen() {
		return VoteGreen;
	}
	
	public void setVoteGreen(int voteGreen) {
		this.VoteGreen += voteGreen;
	}
	
	public int getVoteRed() {
		return VoteRed;
	}
	
	public void setVoteRed(int voteRed) {
		this.VoteRed += voteRed;
	}
	
	public String getStatus() {
		return Status;
	}
	
	public void setStatus(String status) {
		this.Status = status;
	}
	
	public int getTimeLimit() {
		return TimeLimit;
	}
	
	public void setTimeLimit(int timeLimit) {
		this.TimeLimit = timeLimit;
	}
	
	@Override
	public String toString() {
		return "ID = "+ PollID + ", Name = "+ Name +", Description = "+ Description +", Public = "+ isPublic +", Amount of green votes = "+ VoteGreen +
				", Amount of red votes = "+ VoteRed +", Status = "+ Status;
	}
	
	@ManyToOne
	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		this.User = user;
	}

	public List<User> getUsersVoted() {
		return usersVoted;
	}

	public void setUsersVoted(User userVoted) {
		this.usersVoted.add(userVoted);
	}

}

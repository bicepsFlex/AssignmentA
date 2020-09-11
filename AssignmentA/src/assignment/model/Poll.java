package assignment.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
	
	private Users Uname;
	
	private List<Users> usersVoted = new ArrayList<Users>();
	
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
		this.VoteGreen = voteGreen;
	}
	
	public int getVoteRed() {
		return VoteRed;
	}
	
	public void setVoteRed(int voteRed) {
		this.VoteRed = voteRed;
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
				", Amount of red votes = "+ VoteRed +", Status = "+ Status +", Creator = "+ Uname;
	}
	
	@ManyToOne
	public Users getUname() {
		return Uname;
	}

	public void setUname(Users uname) {
		this.Uname = uname;
	}

	
	@ManyToMany
	public List<Users> getUsersVoted() {
		return usersVoted;
	}

	public void setUsersVoted(List<Users> usersVoted) {
		this.usersVoted = usersVoted;
	}

}

package assignment.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Users {
	@Id
	private String Uname;
	private String Fname;
	private String Lname;
	private String Password;
	private String Email;
	private boolean admin;

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<Poll> polls = new ArrayList<Poll>();

	@ManyToMany(mappedBy = "usersVoted", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<Poll> pollsVoted = new ArrayList<Poll>();

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		this.Uname = uname;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		this.Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		this.Lname = lname;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Poll> getPolls() {
		return polls;
	}

	public void setPolls(Poll polls) {
		this.polls.add(polls);
	}
	
	public List<Poll> getPollsVoted() {
		return pollsVoted;
	}

	public void setPollsVoted(List<Poll> pollsVoted) {
		this.pollsVoted.addAll(pollsVoted);
	}

	@Override
	public String toString() {
		return "Uname=" + Uname + ", Fname=" + Fname + ", Lname=" + Lname + ", Password=" + Password + ", Email="
				+ Email + ", admin=" + admin + ", pollsVoted=" + pollsVoted;
	}
	
}

package assignment.model;

import java.util.List;

public interface PollDAO {
	public List<Poll> getAllPolls();
	public Users getPoll(String Name);
	public void updatePollDescription(Poll poll, String newDesc);
	public void deletePoll(Poll poll);
	public String getPollVotes(Poll poll);

}

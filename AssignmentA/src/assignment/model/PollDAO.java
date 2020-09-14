package assignment.model;

import java.util.List;

/**
 * Different methods for Poll entity
 * @author Jarek & Wojtek
 */
public interface PollDAO {
	
	/**
	 *Returns all Polls from Polls table
	 *@return List of polls
	 */
	public List<Poll> getAllPolls();
	
	/**
	 *Returns Polls with a specific String in Name
	 *@param Name String to look for in Poll name
	 *@return List of polls
	 */
	public List<Poll> getPoll(String Name);
	
	/**
	 *Updates the description of Poll
	 *@param poll Poll to update
	 *@param newDesc The new description you want for the poll
	 */
	public void updatePollDescription(Poll poll, String newDesc);
	
	/**
	 *Delete a poll from table
	 *@param poll to delete
	 */
	public void deletePoll(Poll poll);
	
	/**
	 *Adds votes to given poll
	 *@param poll Poll to add votes to
	 *@param user The user that gave these votes
	 *@param green Amount of green votes
	 *@param red Amount of red votes
	 */
	public void pollAddVotes(Poll poll, Users user, int green, int red);
	
	/**
	 * Returns the amount of votes for given poll
	 * @param poll the poll you want to see votes for
	 * @return String with amount of votes
	 */
	public String getPollVotes(Poll poll);

	/**
	 * Creates a Poll with given parameters
	 * @param Name Name of the poll
	 * @param Description Description to describe the poll
	 * @param isPublic =true if poll is to be public
	 * @param Status Status of the poll {Past, Present, Future}
	 * @param Creator User that created the poll
	 */
	public void createPoll(String Name, String Description, boolean isPublic, String Status, Users Creator);

}

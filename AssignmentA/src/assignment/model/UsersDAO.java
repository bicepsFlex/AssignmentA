package assignment.model;

import java.util.List;

public interface UsersDAO {
	
	/**
	 * Returns all users that are registered
	 * @return List of all users from table
	 */
	public List<Users> getAllUsers();
	
	/**
	 * Returns one specific user
	 * @param Uname Username of the user
	 * @return User as Users object
	 */
	public Users getUser(String Uname);
	
	/**
	 * Updates Users first name
	 * @param user User to update
	 * @param newFname New first name
	 */
	public void updateUserFname(Users user, String newFname);
	
	/**
	 * Deletes a user
	 * @param user User to delete
	 */
	public void deleteUser(Users user);
	
	/**
	 * Returns Polls the user has created
	 * @param user User which you want the polls of
	 * @return List of polls
	 */
	public List<Poll> getUserPolls(Users user);
}

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
	 * @return User as 
	 */
	public Users getUser(String Uname);
	
	/**
	 * @param user
	 * @param newFname
	 */
	public void updateUserFname(Users user, String newFname);
	
	/**
	 * @param user
	 */
	public void deleteUser(Users user);
	
	/**
	 * @param user
	 * @return
	 */
	public List<Poll> getUserPolls(Users user);
}

package assignment.model;

import java.util.List;

public interface UsersDao {
	public List<Users> getAllUsers();
	public Users getUser(String Uname);
	public void updateUserFname(Users user, String newFname);
	public void deleteUser(Users user);
	public List<Poll> getUserPolls(Users user);
}

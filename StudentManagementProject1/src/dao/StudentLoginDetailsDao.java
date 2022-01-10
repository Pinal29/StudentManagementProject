package dao;

import model.StudentUserDetails;

public interface StudentLoginDetailsDao {
	public boolean signUp(StudentUserDetails user);
	public boolean signIn(StudentUserDetails user);
	public boolean updateUser(String username);
	public boolean deleteUser(String username);

}

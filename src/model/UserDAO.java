package model;
import java.util.List;

public interface UserDAO {
	public boolean addUser( User student );
    public void deleteUser( int studentId );
    public void updateUser( User student );
    public List<User> getAllUsers();
    public User getUserById( int studentId );
    public User getStudentByName( int studentId );
    public List<User> getUsersLike(String name);
}
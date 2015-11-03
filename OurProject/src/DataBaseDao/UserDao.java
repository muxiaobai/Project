package DataBaseDao;

import java.util.List;

import DataBaseTable.User;

public interface UserDao {
	public boolean doCreate(User User) throws Exception;

	public boolean doDelete(int user_id) throws Exception;

	public List<User> findAll(String keyWord) throws Exception;

	public User findById(int user_id) throws Exception;

}

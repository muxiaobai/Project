package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.UserDao;
import DataBaseImpl.UserDaoImpl;
import DataBaseTable.User;

public class UserDaoProxy implements UserDao {
	private lianjie dbc = null;
	private UserDao dao = null;

	public UserDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new UserDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(User User) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(User.getUser_id()) == null) {
				flag = this.dao.doCreate(User);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int user_id) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(user_id) == null) {
				flag = this.dao.doDelete(user_id);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<User> findAll(String keyWord) throws Exception {
		List<User> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public User findById(int user_id) throws Exception {
		User User = null;
		try {
			User = this.dao.findById(user_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return User;
	}

}

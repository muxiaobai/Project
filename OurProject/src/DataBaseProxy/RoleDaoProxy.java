package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.RoleDao;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Role;

//Role代理类
public class RoleDaoProxy implements RoleDao {
	private lianjie dbc = null;
	private RoleDao dao = null;

	public RoleDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new RoleDaoImpl(this.dbc.getConnection());
	}

	public boolean doCreate(Role role) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(role.getRole_id()) == null) {
				flag = this.dao.doCreate(role);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int role_id) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(role_id) == null) {
				flag = this.dao.doDelete(role_id);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}


	public List<Role> findAll(String keyWord) throws Exception {
		List<Role> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public Role findById(int role_id) throws Exception {
		Role role = null;
		try {
			role = this.dao.findById(role_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return role;
	}
}
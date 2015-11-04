package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.DepartmentDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.DepartmentDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Department;
import DataBaseTable.Role;

public class DepartmentDaoProxy implements DepartmentDao {
	private lianjie dbc = null;
	private DepartmentDao dao = null;

	public DepartmentDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new DepartmentDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Department department) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(department.getDepartment_id()) == null) {
				flag = this.dao.doCreate(department);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Department> findAll(String keyWord) throws Exception {
		List<Department> all = null;
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
	public Department findById(int department_id) throws Exception {
		Department department = null;
		try {
			department = this.dao.findById(department_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return department;
	}

}

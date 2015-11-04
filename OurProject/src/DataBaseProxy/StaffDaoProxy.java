package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.StaffDao;
import DataBaseImpl.StaffDaoImpl;
import DataBaseTable.Staff;

public class StaffDaoProxy implements StaffDao {
	private lianjie dbc = null;
	private StaffDao dao = null;

	public StaffDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new StaffDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Staff Staff) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Staff.getStaff_id()) == null) {
				flag = this.dao.doCreate(Staff);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int staff_id) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(staff_id) == null) {
				flag = this.dao.doDelete(staff_id);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Staff> findAll(String keyWord) throws Exception {
		List<Staff> all = null;
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
	public Staff findById(int staff_id) throws Exception {
		Staff Staff = null;
		try {
			Staff = this.dao.findById(staff_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Staff;
	}

}

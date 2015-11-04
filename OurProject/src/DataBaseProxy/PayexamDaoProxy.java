package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.PayexamDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.PayexamDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Payexam;
import DataBaseTable.Role;

public class PayexamDaoProxy implements PayexamDao {

	private lianjie dbc = null;
	private PayexamDao dao = null;

	public PayexamDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new PayexamDaoImpl(this.dbc.getConnection());
	}

	
	@Override
	
		public boolean doCreate(Payexam Payexam) throws Exception {
			boolean flag = false;
			try {
				if (this.dao.findById(Payexam.getPayexam_id()) == null) {
					flag = this.dao.doCreate(Payexam);
				}
			} catch (Exception e) {
				throw e;
			} finally {
				this.dbc.close();
			}
			return flag;
	}

	@Override
	public List<Payexam> findAll(String keyWord) throws Exception {
		List<Payexam> all = null;
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
	public Payexam findById(int payexam_id) throws Exception {
		Payexam Payexam = null;
		try {
			Payexam = this.dao.findById(payexam_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Payexam;
	}

}

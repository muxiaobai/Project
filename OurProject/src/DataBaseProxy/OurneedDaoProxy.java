package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.OurneedDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.OurneedDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Ourneed;
import DataBaseTable.Role;

public class OurneedDaoProxy implements OurneedDao {

	private lianjie dbc = null;
	private OurneedDao dao = null;

	public OurneedDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new OurneedDaoImpl(this.dbc.getConnection());
	}
	
	@Override
	public boolean doCreate(Ourneed Ourneed) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Ourneed.getOurneed_id()) == null) {
				flag = this.dao.doCreate(Ourneed);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Ourneed> findAll(String keyWord) throws Exception {
		List<Ourneed> all = null;
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
	public Ourneed findById(int ourneed_id) throws Exception {
		Ourneed Ourneed= null;
		try {
			Ourneed = this.dao.findById(ourneed_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Ourneed;
	}

}

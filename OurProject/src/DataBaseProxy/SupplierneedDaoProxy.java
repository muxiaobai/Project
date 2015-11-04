package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.SupplierneedDao;
import DataBaseImpl.SupplierneedDaoImpl;
import DataBaseTable.Supplierneed;

public class SupplierneedDaoProxy implements SupplierneedDao {
	private lianjie dbc = null;
	private SupplierneedDao dao = null;

	public SupplierneedDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new SupplierneedDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Supplierneed Supplierneed) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Supplierneed.getSupplierneed_id()) == null) {
				flag = this.dao.doCreate(Supplierneed);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int supplierneed_id) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(supplierneed_id) == null) {
				flag = this.dao.doDelete(supplierneed_id);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Supplierneed> findAll(String keyWord) throws Exception {
		List<Supplierneed> all = null;
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
	public Supplierneed findById(int supplierneed_id) throws Exception {
		Supplierneed Supplierneed = null;
		try {
			Supplierneed = this.dao.findById(supplierneed_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Supplierneed;
	}

}

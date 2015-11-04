package DataBaseProxy;

import java.util.List;
import DataBaseConn.lianjie;
import DataBaseDao.GovnmtDao;
import DataBaseImpl.GovnmtDaoImpl;
import DataBaseTable.Govnmt;


public class GovnmtDaoProxy implements GovnmtDao {
	private lianjie dbc = null;
	private GovnmtDao dao = null;

	public GovnmtDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new GovnmtDaoImpl(this.dbc.getConnection());
	}

	public boolean doCreate(Govnmt Govnmt) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Govnmt.getGovnmt_id()) == null) {
				flag = this.dao.doCreate(Govnmt);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public List<Govnmt> findAll(String keyWord) throws Exception {
		List<Govnmt> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public Govnmt findById(int govnmt_id) throws Exception {
		Govnmt Govnmt = null;
		try {
			Govnmt = this.dao.findById(govnmt_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Govnmt;
	}
}

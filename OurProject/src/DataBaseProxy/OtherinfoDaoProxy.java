package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.OtherinfoDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.OtherinfoDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Otherinfo;
import DataBaseTable.Role;

public class OtherinfoDaoProxy implements OtherinfoDao {

	private lianjie dbc = null;
	private OtherinfoDao dao = null;

	public OtherinfoDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new OtherinfoDaoImpl(this.dbc.getConnection());
	}
	
	@Override
	public boolean doCreate(Otherinfo Otherinfo) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Otherinfo.getOtherinfo_id()) == null) {
				flag = this.dao.doCreate(Otherinfo);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Otherinfo> findAll(String keyWord) throws Exception {
		List<Otherinfo> all = null;
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
	public Otherinfo findById(int otherinfo_id) throws Exception {
		Otherinfo Otherinfo = null;
		try {
			Otherinfo = this.dao.findById(otherinfo_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Otherinfo;
	}

}

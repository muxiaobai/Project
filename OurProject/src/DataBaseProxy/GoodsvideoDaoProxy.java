package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.GoodsvideoDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.GoodsvideoDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Goodsvideo;
import DataBaseTable.Role;

public class  GoodsvideoDaoProxy implements  GoodsvideoDao {
	private lianjie dbc = null;
	private GoodsvideoDao dao = null;

	public GoodsvideoDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new GoodsvideoDaoImpl(this.dbc.getConnection());
	}

	public boolean doCreate(Goodsvideo Goodsvideo) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Goodsvideo.getGoodsvideo_id()) == null) {
				flag = this.dao.doCreate(Goodsvideo);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public List<Goodsvideo> findAll(String keyWord) throws Exception {
		List<Goodsvideo> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public Goodsvideo findById(int goodsvideo_id) throws Exception {
		Goodsvideo Goodsvideo = null;
		try {
			Goodsvideo = this.dao.findById(goodsvideo_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Goodsvideo;
	}
}

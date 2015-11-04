package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.BkgoodsDao;

import DataBaseImpl.BkgoodsDaoImpl;
import DataBaseTable.Bkgoods;


public class BkgoodsDaoProxy implements BkgoodsDao {
	private lianjie dbc = null;
	private BkgoodsDao dao = null;

	public BkgoodsDaoProxy() throws Exception {
	this.dbc = new lianjie();
    this.dao = new BkgoodsDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Bkgoods bkgoods) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(bkgoods.getBkgoods_id()) == null) {
				flag = this.dao.doCreate(bkgoods);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Bkgoods> findAll(String keyWord) throws Exception {
		List<Bkgoods> all = null;
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
	public Bkgoods findById(int bkgoods_id) throws Exception {
		Bkgoods bkgoods = null;
		try {
			bkgoods = this.dao.findById(bkgoods_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return bkgoods;
	}

}

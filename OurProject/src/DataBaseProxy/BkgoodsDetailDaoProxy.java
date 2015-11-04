package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.BkgoodsDetailDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.BkgoodsDetailDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.BkgoodsDetail;
import DataBaseTable.Role;

public class BkgoodsDetailDaoProxy implements BkgoodsDetailDao {
	private lianjie dbc = null;
	private BkgoodsDetailDao dao = null;

	public BkgoodsDetailDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new BkgoodsDetailDaoImpl(this.dbc.getConnection());
		}
	@Override
	public boolean doCreate(BkgoodsDetail bkgoodsdetail) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(bkgoodsdetail.getBkgoodsdetail_id()) == null) {
				flag = this.dao.doCreate(bkgoodsdetail);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}
	
	@Override
	public List<BkgoodsDetail> findAll(String keyWord) throws Exception {
		List<BkgoodsDetail> all = null;
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
	public BkgoodsDetail findById(int bkgoodsdetail_id) throws Exception {
		BkgoodsDetail bkgoodsdetail = null;
		try {
			bkgoodsdetail = this.dao.findById(bkgoodsdetail_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return bkgoodsdetail;
	}

}

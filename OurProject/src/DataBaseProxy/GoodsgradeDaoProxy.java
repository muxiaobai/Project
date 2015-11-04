package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.GoodsgradeDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.GoodsgradeDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Goodsgrade;
import DataBaseTable.Role;

public class GoodsgradeDaoProxy implements GoodsgradeDao {

	private lianjie dbc = null;
	private  GoodsgradeDao dao = null;
	
	public GoodsgradeDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new GoodsgradeDaoImpl(this.dbc.getConnection());
	}
	
	public boolean doCreate(Goodsgrade Goodsgrade) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Goodsgrade.getGoodsgrade_id()) == null) {
				flag = this.dao.doCreate(Goodsgrade);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public List<Goodsgrade> findAll(String keyWord) throws Exception {
		List<Goodsgrade> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}
	
	public Goodsgrade findById(int goodsgrade_id) throws Exception {
		Goodsgrade Goodsgrade = null;
		try {
			Goodsgrade = this.dao.findById(goodsgrade_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Goodsgrade;
	}

}

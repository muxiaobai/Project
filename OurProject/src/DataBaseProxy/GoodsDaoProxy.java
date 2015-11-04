package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.GoodsDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.GoodsDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Goods;
import DataBaseTable.Role;

public class GoodsDaoProxy implements GoodsDao {
	private lianjie dbc = null;
	private GoodsDao dao = null;

	public GoodsDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new GoodsDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Goods goods) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(goods.getGoods_id()) == null) {
				flag = this.dao.doCreate(goods);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
		

	}

	@Override
	public List<Goods> findAll(String keyWord) throws Exception {
		List<Goods> all = null;
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
	public Goods findById(int goods_id) throws Exception {
		Goods goods = null;
		try {
			goods = this.dao.findById(goods_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return goods;
	}

}

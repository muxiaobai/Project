package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.GoodsinfoDao;
import DataBaseImpl.GoodsinfoDaoImpl;
import DataBaseTable.Goodsinfo;
import DataBaseTable.Role;

public class GoodsinfoDaoProxy implements GoodsinfoDao {
  
	private lianjie dbc = null;
	private GoodsinfoDao dao = null;
	
	public GoodsinfoDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new GoodsinfoDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Goodsinfo Goodsinfo) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Goodsinfo.getGoodsinfo_id()) == null) {
				flag = this.dao.doCreate(Goodsinfo);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Goodsinfo> findAll(String keyWord) throws Exception {
		List<Goodsinfo> all = null;
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
	public Goodsinfo findById(int goodsinfo_id) throws Exception {
		Goodsinfo Goodsinfo = null;
		try {
			Goodsinfo = this.dao.findById(goodsinfo_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Goodsinfo;
	}

}

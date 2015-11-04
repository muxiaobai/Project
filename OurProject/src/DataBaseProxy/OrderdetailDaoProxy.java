package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.OrderdetailDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.OrderdetailDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Orderdetail;
import DataBaseTable.Role;

public class OrderdetailDaoProxy implements OrderdetailDao {

	private lianjie dbc = null;
	private OrderdetailDao dao = null;

	public OrderdetailDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new OrderdetailDaoImpl(this.dbc.getConnection());
	}
	
	@Override
	public boolean doCreate(Orderdetail Orderdetail) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Orderdetail.getDetail_id()) == null) {
				flag = this.dao.doCreate(Orderdetail);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Orderdetail> findAll(String keyWord) throws Exception {
		List<Orderdetail> all = null;
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
	public Orderdetail findById(int detail_id) throws Exception {
		Orderdetail Orderdetail = null;
		try {
			Orderdetail = this.dao.findById(detail_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Orderdetail;
	}

}

package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.OrderDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.OrderDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Order;
import DataBaseTable.Role;

public class OrderDaoProxy implements OrderDao {
 
	
	private lianjie dbc = null;
	private OrderDao dao = null;
	public OrderDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new  OrderDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate( Order  Order) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById( Order.getOrder_id()) == null) {
				flag = this.dao.doCreate( Order);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Order> findAll(String keyWord) throws Exception {
		List<Order> all = null;
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
	public Order findById(int order_id) throws Exception {
		Order Order = null;
		try {
			Order = this.dao.findById(order_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Order;
	}

}

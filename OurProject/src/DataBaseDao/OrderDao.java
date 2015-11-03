package DataBaseDao;

import java.util.List;

import DataBaseTable.Order;


public interface OrderDao {
	public boolean doCreate(Order Order) throws Exception;

	public List<Order> findAll(String keyWord) throws Exception;

	public Order findById(int order_id) throws Exception;
}

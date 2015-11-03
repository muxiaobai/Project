package DataBaseDao;

import java.util.List;

import DataBaseTable.Orderdetail;


public interface OrderdetailDao {
	public boolean doCreate(Orderdetail Orderdetail) throws Exception;

	public List<Orderdetail> findAll(String keyWord) throws Exception;

	public Orderdetail findById(int orderdetail_id) throws Exception;
}

package DataBaseDao;

import java.util.List;

import DataBaseTable.Suppliergoods;


public interface SuppliergoodsDao {
	public boolean doCreate(Suppliergoods Suppliergoods) throws Exception;

	public boolean doDelete(int suppliergoods_id) throws Exception;

	public List<Suppliergoods> findAll(String keyWord) throws Exception;

	public Suppliergoods findById(int suppliergoods_id) throws Exception;

}

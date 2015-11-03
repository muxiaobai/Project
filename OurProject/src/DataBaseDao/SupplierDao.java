package DataBaseDao;

import java.util.List;

import DataBaseTable.Supplier;

public interface SupplierDao {
	public boolean doCreate(Supplier Supplier) throws Exception;

	public boolean doDelete(int supplier_id) throws Exception;

	public List<Supplier> findAll(String keyWord) throws Exception;

	public Supplier findById(int supplier_id) throws Exception;

}

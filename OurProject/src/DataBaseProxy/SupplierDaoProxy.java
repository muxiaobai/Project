package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.SupplierDao;
import DataBaseImpl.SupplierDaoImpl;
import DataBaseTable.Supplier;

public class SupplierDaoProxy implements SupplierDao {
	private lianjie dbc = null;
	private  SupplierDao dao = null;

	public SupplierDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new SupplierDaoImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(Supplier Supplier) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Supplier.getSupplier_id()) == null) {
				flag = this.dao.doCreate(Supplier);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int supplier_id) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(supplier_id) == null) {
				flag = this.dao.doDelete(supplier_id);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Supplier> findAll(String keyWord) throws Exception {
		List<Supplier> all = null;
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
	public Supplier findById(int supplier_id) throws Exception {
		Supplier Supplier = null;
		try {
			Supplier = this.dao.findById(supplier_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Supplier;
	}

}

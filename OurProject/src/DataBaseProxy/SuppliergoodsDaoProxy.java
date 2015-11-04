package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.SuppliergoodsDao;
import DataBaseImpl.SuppliergoodsDaoImpl;
import DataBaseTable.Suppliergoods;

public class SuppliergoodsDaoProxy implements SuppliergoodsDao {
	private lianjie dbc = null;
	private SuppliergoodsDao dao = null;

	public SuppliergoodsDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new SuppliergoodsDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Suppliergoods Suppliergoods) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Suppliergoods.getSuppliergoods_id()) == null) {
				flag = this.dao.doCreate(Suppliergoods);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int suppliergoods_id) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(suppliergoods_id) == null) {
				flag = this.dao.doDelete(suppliergoods_id);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Suppliergoods> findAll(String keyWord) throws Exception {
		List<Suppliergoods> all = null;
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
	public Suppliergoods findById(int suppliergoods_id) throws Exception {
		Suppliergoods Suppliergoods = null;
		try {
			Suppliergoods = this.dao.findById(suppliergoods_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Suppliergoods;
	}

}

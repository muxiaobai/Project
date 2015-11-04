package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.ContractMediaDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.ContractMediaDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.ContractMedia;
import DataBaseTable.Role;

public class ContractMediaDaoProxy implements ContractMediaDao {
	private lianjie dbc = null;
	private ContractMediaDao dao = null;

	public ContractMediaDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new ContractMediaDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(ContractMedia contractmedia) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(contractmedia.getContractmedia_id()) == null) {
				flag = this.dao.doCreate(contractmedia);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<ContractMedia> findAll(String keyWord) throws Exception {
		List<ContractMedia> all = null;
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
	public ContractMedia findById(int contractmedia_id) throws Exception {
		ContractMedia contractmedia = null;
		try {
			contractmedia = this.dao.findById(contractmedia_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return contractmedia;
	}

}

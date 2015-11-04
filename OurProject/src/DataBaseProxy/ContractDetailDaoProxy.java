package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.ContractDetailDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.ContractDetailDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.ContractDetail;
import DataBaseTable.Role;

public class ContractDetailDaoProxy implements ContractDetailDao {
	private lianjie dbc = null;
	private ContractDetailDao dao = null;

	public ContractDetailDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new ContractDetailDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(ContractDetail contractdetail) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(contractdetail.getContractdetail_id()) == null) {
				flag = this.dao.doCreate(contractdetail);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<ContractDetail> findAll(String keyWord) throws Exception {
		List<ContractDetail> all = null;
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
	public ContractDetail findById(int contractdetail_id) throws Exception {
		ContractDetail contractdetail = null;
		try {
			contractdetail = this.dao.findById(contractdetail_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return contractdetail;
	}

}

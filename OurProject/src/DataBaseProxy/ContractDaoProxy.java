package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.ContractDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.ContractDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Contract;
import DataBaseTable.Role;

public class ContractDaoProxy implements ContractDao {
	private lianjie dbc = null;
	private ContractDao dao = null;

	public ContractDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new ContractDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Contract contract) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(contract.getContract_id()) == null) {
				flag = this.dao.doCreate(contract);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Contract> findAll(String keyWord) throws Exception {
		List<Contract> all = null;
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
	public Contract findById(int contract_id) throws Exception {
		Contract contract = null;
		try {
			contract = this.dao.findById(contract_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return contract;
	}

}

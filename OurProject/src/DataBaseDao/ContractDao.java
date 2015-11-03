package DataBaseDao;

import java.util.List;

import DataBaseTable.Contract;


public interface ContractDao {
	public boolean doCreate(Contract contract) throws Exception;

	public List<Contract> findAll(String keyWord) throws Exception;

	public Contract findById(int contract_id) throws Exception;
}

package DataBaseDao;

import java.util.List;

import DataBaseTable.Contract;
import DataBaseTable.ContractDetail;

public interface ContractDetailDao {
	public boolean doCreate(ContractDetail contractdetail) throws Exception;

	public List<ContractDetail> findAll(String keyWord) throws Exception;

	public ContractDetail findById(int contractdetail_id) throws Exception;
}

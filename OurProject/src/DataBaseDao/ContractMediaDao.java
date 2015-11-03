package DataBaseDao;

import java.util.List;

import DataBaseTable.ContractMedia;

public interface ContractMediaDao {
	public boolean doCreate(ContractMedia contractmedia) throws Exception;

	public List<ContractMedia> findAll(String keyWord) throws Exception;

	public ContractMedia findById(int contractmedia_id) throws Exception;
}

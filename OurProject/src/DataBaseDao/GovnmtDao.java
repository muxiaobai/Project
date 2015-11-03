package DataBaseDao;

import java.util.List;

import DataBaseTable.Govnmt;

public interface GovnmtDao {
	public boolean doCreate(Govnmt Govnmt) throws Exception;

	public List<Govnmt> findAll(String keyWord) throws Exception;

	public Govnmt findById(int govnmt_id) throws Exception;
}

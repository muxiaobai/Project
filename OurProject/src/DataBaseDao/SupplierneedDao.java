package DataBaseDao;

import java.util.List;

import DataBaseTable.Supplierneed;

public interface SupplierneedDao {
	public boolean doCreate(Supplierneed Supplierneed) throws Exception;

	public boolean doDelete(int supplierneed_id) throws Exception;

	public List<Supplierneed> findAll(String keyWord) throws Exception;

	public Supplierneed findById(int supplierneed_id) throws Exception;

}

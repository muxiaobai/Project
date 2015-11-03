package DataBaseDao;

import java.util.List;

import DataBaseTable.Ourneed;
import DataBaseTable.Role;

public interface OurneedDao {
	public boolean doCreate(Ourneed Ourneed) throws Exception;

	public List<Ourneed> findAll(String keyWord) throws Exception;

	public Ourneed findById(int ourneed_id) throws Exception;
}

package DataBaseDao;

import java.util.List;

import DataBaseTable.Otherinfo;
import DataBaseTable.Role;

public interface OtherinfoDao {
	public boolean doCreate(Otherinfo Otherinfo) throws Exception;

	public List<Otherinfo> findAll(String keyWord) throws Exception;

	public Otherinfo findById(int otherinfo_id) throws Exception;
}

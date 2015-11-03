package DataBaseDao;

import java.util.List;

import DataBaseTable.Payexam;
import DataBaseTable.Role;

public interface PayexamDao {
	public boolean doCreate(Payexam Payexam) throws Exception;

	public List<Payexam> findAll(String keyWord) throws Exception;

	public Payexam findById(int payexam_id) throws Exception;
}

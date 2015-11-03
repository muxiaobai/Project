package DataBaseDao;

import java.util.List;
import DataBaseTable.Staff;

public interface StaffDao {
	public boolean doCreate(Staff Staff) throws Exception;

	public boolean doDelete(int staff_id) throws Exception;

	public List<Staff> findAll(String keyWord) throws Exception;

	public Staff findById(int staff_id) throws Exception;

}

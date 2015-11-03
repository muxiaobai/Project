package DataBaseDao;

import java.util.List;

import DataBaseTable.Department;


public interface DepartmentDao {
	public boolean doCreate(Department department) throws Exception;

	public List<Department> findAll(String keyWord) throws Exception;

	public Department findById(int department_id) throws Exception;
}

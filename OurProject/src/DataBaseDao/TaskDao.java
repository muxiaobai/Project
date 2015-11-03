package DataBaseDao;

import java.util.List;

import DataBaseTable.Task;

public interface TaskDao {
	public boolean doCreate(Task Task) throws Exception;

	public boolean doDelete(int task_id) throws Exception;

	public List<Task> findAll(String keyWord) throws Exception;

	public Task findById(int task_id) throws Exception;

}

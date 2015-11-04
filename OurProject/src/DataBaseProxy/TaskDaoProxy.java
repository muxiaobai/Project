package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.TaskDao;
import DataBaseImpl.TaskDaoImpl;
import DataBaseTable.Task;

public class TaskDaoProxy implements TaskDao {
	private lianjie dbc = null;
	private TaskDao dao = null;

	public TaskDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new TaskDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Task Task) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Task.getTask_id()) == null) {
				flag = this.dao.doCreate(Task);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int task_id) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(task_id) == null) {
				flag = this.dao.doDelete(task_id);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Task> findAll(String keyWord) throws Exception {
		List<Task> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public Task findById(int task_id) throws Exception {
		Task Task = null;
		try {
			Task = this.dao.findById(task_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Task;
	}

}

package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.TaskDao;
import DataBaseTable.Task;

public class TaskDaoImpl implements TaskDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public TaskDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Task Task) throws Exception {

		boolean flag = false;
		String sql = "INSERT INTO t_task(task_staffid,task_supplierid,task_num,task_unit,task_state,task_categoryid,task_time,task_offtime) VALUES (?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Task.getTask_staffid());
		this.pstmt.setInt(2, Task.getTask_supplierid());
		this.pstmt.setInt(3, Task.getTask_num());
		this.pstmt.setString(4, Task.getTask_unit());
		this.pstmt.setString(5, Task.getTask_state());
		this.pstmt.setInt(6, Task.getTask_categoryid());
		this.pstmt.setTimestamp(7, Task.getTask_time());
		this.pstmt.setTimestamp(8, Task.getTask_offtime());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doDelete(int task_id) throws Exception {
		boolean flag = false;
		String sql = "delete from t_task where task_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, task_id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Task> findAll(String keyWord) throws Exception {
		List<Task> result = new ArrayList<Task>();
		String sql = "SELECT * FROM t_task WHERE  supplierid  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Task Task = null;
		while (rs.next()) {
			Task = new Task();
			Task.setTask_id(rs.getInt("task_id"));
			Task.setTask_staffid(rs.getInt("task_staffid"));
			Task.setTask_supplierid(rs.getInt("task_supplierid"));
			Task.setTask_num(rs.getInt("task_num"));
			Task.setTask_unit(rs.getString("task_unit"));
			Task.setTask_state(rs.getString("task_state"));
			Task.setTask_categoryid(rs.getInt("task_categoryid"));
			Task.setTask_time(rs.getTimestamp("task_time"));
			Task.setTask_offtime(rs.getTimestamp("task_offtime"));
			result.add(Task);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public Task findById(int task_id) throws Exception {
		Task Task = null;
		String sql = "SELECT * FROM t_task WHERE task_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, task_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Task = new Task();
			Task.setTask_id(rs.getInt("task_id"));
			Task.setTask_staffid(rs.getInt("task_staffid"));
			Task.setTask_supplierid(rs.getInt("task_supplierid"));
			Task.setTask_num(rs.getInt("task_num"));
			Task.setTask_unit(rs.getString("task_unit"));
			Task.setTask_state(rs.getString("task_state"));
			Task.setTask_categoryid(rs.getInt("task_categoryid"));
			Task.setTask_time(rs.getTimestamp("task_time"));
			Task.setTask_offtime(rs.getTimestamp("task_offtime"));
		}
		this.pstmt.close();
		return Task;
	}

}

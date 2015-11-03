package DataBaseTable;

import java.sql.Timestamp;
//任务
public class Task {
	private int task_id;
	private int task_staffid;
	private int task_supplierid;
	private int task_num;
	private String task_unit;
	private String task_state;
	private int task_categoryid;
	private Timestamp task_time;
	private Timestamp task_offtime;
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public int getTask_staffid() {
		return task_staffid;
	}
	public void setTask_staffid(int task_staffid) {
		this.task_staffid = task_staffid;
	}
	public int getTask_supplierid() {
		return task_supplierid;
	}
	public void setTask_supplierid(int task_supplierid) {
		this.task_supplierid = task_supplierid;
	}
	public int getTask_num() {
		return task_num;
	}
	public void setTask_num(int task_num) {
		this.task_num = task_num;
	}
	public String getTask_unit() {
		return task_unit;
	}
	public void setTask_unit(String task_unit) {
		this.task_unit = task_unit;
	}
	public String getTask_state() {
		return task_state;
	}
	public void setTask_state(String task_state) {
		this.task_state = task_state;
	}
	public int getTask_categoryid() {
		return task_categoryid;
	}
	public void setTask_categoryid(int task_categoryid) {
		this.task_categoryid = task_categoryid;
	}
	public Timestamp getTask_time() {
		return task_time;
	}
	public void setTask_time(Timestamp task_time) {
		this.task_time = task_time;
	}
	public Timestamp getTask_offtime() {
		return task_offtime;
	}
	public void setTask_offtime(Timestamp task_offtime) {
		this.task_offtime = task_offtime;
	}
	
}

package DataBaseTable;

import java.sql.Timestamp;

public class Payexam {
	private int payexam_id;
	private int payexam_contractid;
	private int payexam_cashier_staffid;
	private int payexam_approver_staffid;
	private Timestamp payexam_time;
	private String payexam_result;
	private String payexam_reason;
	private Timestamp payexam_postponetime;
	public int getPayexam_id() {
		return payexam_id;
	}
	public void setPayexam_id(int payexam_id) {
		this.payexam_id = payexam_id;
	}
	public int getPayexam_contractid() {
		return payexam_contractid;
	}
	public void setPayexam_contractid(int payexam_contractid) {
		this.payexam_contractid = payexam_contractid;
	}
	public int getPayexam_cashier_staffid() {
		return payexam_cashier_staffid;
	}
	public void setPayexam_cashier_staffid(int payexam_cashier_staffid) {
		this.payexam_cashier_staffid = payexam_cashier_staffid;
	}
	public int getPayexam_approver_staffid() {
		return payexam_approver_staffid;
	}
	public void setPayexam_approver_staffid(int payexam_approver_staffid) {
		this.payexam_approver_staffid = payexam_approver_staffid;
	}
	public Timestamp getPayexam_time() {
		return payexam_time;
	}
	public void setPayexam_time(Timestamp payexam_time) {
		this.payexam_time = payexam_time;
	}
	public String getPayexam_result() {
		return payexam_result;
	}
	public void setPayexam_result(String payexam_result) {
		this.payexam_result = payexam_result;
	}
	public String getPayexam_reason() {
		return payexam_reason;
	}
	public void setPayexam_reason(String payexam_reason) {
		this.payexam_reason = payexam_reason;
	}
	public Timestamp getPayexam_postponetime() {
		return payexam_postponetime;
	}
	public void setPayexam_postponetime(Timestamp payexam_postponetime) {
		this.payexam_postponetime = payexam_postponetime;
	}
	
}

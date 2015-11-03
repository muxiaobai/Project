package DataBaseTable;

import java.sql.Date;

public class Contract {
	private int contract_id;
	private String contract_number;
	private int contract_supplierid;
	private Double contract_sum;
	private int contract_staffid;
	private Date contract_time;
	private String contract_context;
	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	public String getContract_number() {
		return contract_number;
	}
	public void setContract_number(String contract_number) {
		this.contract_number = contract_number;
	}
	public int getContract_supplierid() {
		return contract_supplierid;
	}
	public void setContract_supplierid(int contract_supplierid) {
		this.contract_supplierid = contract_supplierid;
	}
	public Double getContract_sum() {
		return contract_sum;
	}
	public void setContract_sum(Double contract_sum) {
		this.contract_sum = contract_sum;
	}
	public int getContract_staffid() {
		return contract_staffid;
	}
	public void setContract_staffid(int contract_staffid) {
		this.contract_staffid = contract_staffid;
	}
	public Date getContract_time() {
		return contract_time;
	}
	public void setContract_time(Date contract_time) {
		this.contract_time = contract_time;
	}
	public String getContract_context() {
		return contract_context;
	}
	public void setContract_context(String contract_context) {
		this.contract_context = contract_context;
	}
}

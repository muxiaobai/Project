package DataBaseTable;
import java.sql.Timestamp;

public class Bkgoods {
	private int bkgoods_id;
	private String bkgoods_number;
	private int bkgoods_stationid;
	private int bkgoods_orderid;
	private Timestamp bkgoods_time;
	private double bkgoods_money;
	private int bkgoods_state;
	public int getBkgoods_id() {
		return bkgoods_id;
	}
	public void setBkgoods_id(int bkgoods_id) {
		this.bkgoods_id = bkgoods_id;
	}
	public String getBkgoods_number() {
		return bkgoods_number;
	}
	public void setBkgoods_number(String bkgoods_number) {
		this.bkgoods_number = bkgoods_number;
	}
	public int getBkgoods_stationid() {
		return bkgoods_stationid;
	}
	public void setBkgoods_stationid(int bkgoods_stationid) {
		this.bkgoods_stationid = bkgoods_stationid;
	}
	public int getBkgoods_orderid() {
		return bkgoods_orderid;
	}
	public void setBkgoods_orderid(int bkgoods_orderid) {
		this.bkgoods_orderid = bkgoods_orderid;
	}
	public Timestamp getBkgoods_time() {
		return bkgoods_time;
	}
	public void setBkgoods_time(Timestamp bkgoods_time) {
		this.bkgoods_time = bkgoods_time;
	}
	public double getBkgoods_money() {
		return bkgoods_money;
	}
	public void setBkgoods_money(double bkgoods_money) {
		this.bkgoods_money = bkgoods_money;
	}
	public int getBkgoods_state() {
		return bkgoods_state;
	}
	public void setBkgoods_state(int bkgoods_state) {
		this.bkgoods_state = bkgoods_state;
	}

}

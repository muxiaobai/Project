package DataBaseTable;
//供应商需求
import java.sql.Timestamp;

public class Supplierneed {
	private int supplierneed_id;
	private int supplierneed_supplierid;
	private int supplierneed_number;
	private String supplierneed_unit;
	private double supplierneed_highprice;
	private double supplierneed_lowprice;
	private Timestamp supplierneed_begintime;
	private Timestamp supplierneed_endtime;
	private String supplierneed_state;
	private Timestamp supplierneed_statetime;
	private String supplierneed_reason;
	public int getSupplierneed_id() {
		return supplierneed_id;
	}
	public void setSupplierneed_id(int supplierneed_id) {
		this.supplierneed_id = supplierneed_id;
	}
	public int getSupplierneed_supplierid() {
		return supplierneed_supplierid;
	}
	public void setSupplierneed_supplierid(int supplierneed_supplierid) {
		this.supplierneed_supplierid = supplierneed_supplierid;
	}
	public int getSupplierneed_number() {
		return supplierneed_number;
	}
	public void setSupplierneed_number(int supplierneed_number) {
		this.supplierneed_number = supplierneed_number;
	}
	public String getSupplierneed_unit() {
		return supplierneed_unit;
	}
	public void setSupplierneed_unit(String supplierneed_unit) {
		this.supplierneed_unit = supplierneed_unit;
	}
	public double getSupplierneed_highprice() {
		return supplierneed_highprice;
	}
	public void setSupplierneed_highprice(double supplierneed_highprice) {
		this.supplierneed_highprice = supplierneed_highprice;
	}
	public double getSupplierneed_lowprice() {
		return supplierneed_lowprice;
	}
	public void setSupplierneed_lowprice(double supplierneed_lowprice) {
		this.supplierneed_lowprice = supplierneed_lowprice;
	}
	public Timestamp getSupplierneed_begintime() {
		return supplierneed_begintime;
	}
	public void setSupplierneed_begintime(Timestamp supplierneed_begintime) {
		this.supplierneed_begintime = supplierneed_begintime;
	}
	public Timestamp getSupplierneed_endtime() {
		return supplierneed_endtime;
	}
	public void setSupplierneed_endtime(Timestamp supplierneed_endtime) {
		this.supplierneed_endtime = supplierneed_endtime;
	}
	public String getSupplierneed_state() {
		return supplierneed_state;
	}
	public void setSupplierneed_state(String supplierneed_state) {
		this.supplierneed_state = supplierneed_state;
	}
	public Timestamp getSupplierneed_statetime() {
		return supplierneed_statetime;
	}
	public void setSupplierneed_statetime(Timestamp supplierneed_statetime) {
		this.supplierneed_statetime = supplierneed_statetime;
	}
	public String getSupplierneed_reason() {
		return supplierneed_reason;
	}
	public void setSupplierneed_reason(String supplierneed_reason) {
		this.supplierneed_reason = supplierneed_reason;
	}
	
	
	
}

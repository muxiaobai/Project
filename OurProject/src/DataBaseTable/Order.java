package DataBaseTable;

import java.sql.Timestamp;

public class Order {
	private int order_id;
	private String order_number;
	private int order_userid;
	private double order_paysum;
	private String order_province;
	private String order_city;
	private String order_country;
	private String order_address;
	private String order_stationnumber;
	private int order_pmtl_offer ;
    private Timestamp order_place_time;
    private Timestamp order_pay_time;
    private int order_state;
	
    
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id =  order_id;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public int getOrder_userid() {
		return order_userid;
	}
	public void setOrder_userid(int order_userid) {
		this.order_userid =  order_userid;
	}
	public double getOrder_paysum() {
		return order_paysum;
	}
	public void setOrder_paysum(double order_paysum) {
		this.order_paysum =  order_paysum;
	}
	public String getOrder_province() {
		return order_province;
	}
	public void setOrder_province(String order_province) {
		this.order_province = order_province;
	}
	public String getOrder_city(){
		return order_city;
	}
	public void setOrder_city(String order_city) {
		this.order_city = order_city;
	}
	public String getOrder_country(){
		return order_country;
	}
	public void setOrder_country(String order_country) {
		this.order_country = order_country;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public String getOrder_stationnumber() {
		return order_stationnumber;
	}
	public void setOrder_stationnumber(String order_stationnumber) {
		this.order_stationnumber = order_stationnumber;
	}
	public int getOrder_pmtl_offer() {
		return order_pmtl_offer;
	}
	public void setOrder_pmtl_offer(int order_pmtl_offer) {
		this.order_pmtl_offer =  order_pmtl_offer;
	}
	public Timestamp getOrder_place_time() {
		return order_place_time;
	}
	public void setOrder_place_time( Timestamp order_place_time) {
		this.order_place_time =  order_place_time;
	}
	public Timestamp getOrder_pay_time() {
		return order_pay_time;
	}
	public void setOrder_pay_time( Timestamp order_pay_time) {
		this.order_pay_time =  order_pay_time;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state =  order_id;
	}
}

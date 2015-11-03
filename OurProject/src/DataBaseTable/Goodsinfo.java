package DataBaseTable;

import java.sql.Timestamp;

public class Goodsinfo {
	private int goodsinfo_id;
	private Timestamp goodsinfo_time;
	private int goodsinfo_categoryid;
	private double goodsinfo_highprice;
	private double goodsinfo_lowprice;
	private int goodsinfo_staffid;
	
	
	public int getGoodsinfo_id() {
		return goodsinfo_id;
	}
	public void setGoodsinfo_id(int goodsinfo_id) {
		this.goodsinfo_id = goodsinfo_id;
	}
	public Timestamp getGoodsinfo_time() {
		return goodsinfo_time;
	}
	public void setGoodsinfo_time(Timestamp goodsinfo_time) {
		this.goodsinfo_time = goodsinfo_time;
	}
	public int getGoodsinfo_categoryid() {
		return goodsinfo_categoryid;
	}
	public void setGoodsinfo_categoryid(int goodsinfo_categoryid) {
		this.goodsinfo_categoryid = goodsinfo_categoryid;
	}
	public double getGoodsinfo_highprice() {
		return goodsinfo_highprice;
	}
	public void setGoodsinfo_highprice(double goodsinfo_highprice) {
		this.goodsinfo_highprice = goodsinfo_highprice;
	}
	public double getGoodsinfo_lowprice() {
		return goodsinfo_lowprice;
	}
	public void setGoodsinfo_lowprice(double goodsinfo_lowprice) {
		this.goodsinfo_lowprice = goodsinfo_lowprice;
	}
	public int getGoodsinfo_staffid() {
		return goodsinfo_staffid;
	}
	public void setGoodsinfo_staffid(int goodsinfo_staffid) {
		this.goodsinfo_staffid = goodsinfo_staffid;
	}
}

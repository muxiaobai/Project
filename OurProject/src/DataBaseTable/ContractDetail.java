package DataBaseTable;

public class ContractDetail {
	private int contractdetail_id;
	private int contractdetail_contractid;

	private int contractdetail_supplygoodsid;
	private Double contractdetail_price;
	private int contractdetail_num;
	private String contractdetail_unit;
	private String contractdetail_url;
	public int getContractdetail_id() {
		return contractdetail_id;
	}
	public void setContractdetail_id(int contractdetail_id) {
		this.contractdetail_id = contractdetail_id;
	}
	public int getContractdetail_supplygoodsid() {
		return contractdetail_supplygoodsid;
	}
	public void setContractdetail_supplygoodsid(int contractdetail_supplygoodsid) {
		this.contractdetail_supplygoodsid = contractdetail_supplygoodsid;
	}
	public Double getContractdetail_price() {
		return contractdetail_price;
	}
	public void setContractdetail_price(Double contractdetail_price) {
		this.contractdetail_price = contractdetail_price;
	}
	public int getContractdetail_num() {
		return contractdetail_num;
	}
	public void setContractdetail_num(int contractdetail_num) {
		this.contractdetail_num = contractdetail_num;
	}
	public String getContractdetail_unit() {
		return contractdetail_unit;
	}
	public void setContractdetail_unit(String contractdetail_unit) {
		this.contractdetail_unit = contractdetail_unit;
	}
	public String getContractdetail_url() {
		return contractdetail_url;
	}
	public void setContractdetail_url(String contractdetail_url) {
		this.contractdetail_url = contractdetail_url;
		
	}
	public int getContractdetail_contractid() {
		return contractdetail_contractid;
	}
	public void setContractdetail_contractid(int contractdetail_contractid) {
		this.contractdetail_contractid = contractdetail_contractid;
	}
}

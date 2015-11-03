package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.ContractDetailDao;
import DataBaseTable.ContractDetail;
import DataBaseTable.Role;

public class ContractDetailDaoImpl implements ContractDetailDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public ContractDetailDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(ContractDetail conractdetail) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_conractdetail(conractdetail_contractid,conractdetail_supplygoodsid,conractdetail_price,conractdetail_num,conractdetail_unit,conractdetail_url) VALUES (?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, conractdetail.getContractdetail_contractid());
		this.pstmt.setInt(2, conractdetail.getContractdetail_supplygoodsid());
		this.pstmt.setDouble(3, conractdetail.getContractdetail_price());
		this.pstmt.setInt(4, conractdetail.getContractdetail_num());
		this.pstmt.setString(5, conractdetail.getContractdetail_unit());
		this.pstmt.setString(6, conractdetail.getContractdetail_url());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<ContractDetail> findAll(String keyWord) throws Exception {
		List<ContractDetail> result = new ArrayList<ContractDetail>();
		String sql = "SELECT * FROM t_contractdetail WHERE contractdetail_id LIKE ?  OR contractdetail_contractid  LIKE ? OR contractdetail_supplygoodsid  LIKE ? OR contractdetail_price LIKE ? OR contractdetail_num  LIKE ? OR contractdetail_unit LIKE ? OR contractdetail_url  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		this.pstmt.setString(7, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		ContractDetail contractdetail = null;
		while (rs.next()) {
			contractdetail = new ContractDetail();
			contractdetail.setContractdetail_id(rs.getInt("contractdetail_id"));
			contractdetail.setContractdetail_contractid(rs.getInt("contractdetail_contractid"));
			contractdetail.setContractdetail_supplygoodsid(rs.getInt("contractdetail_supplygoodsid"));
			contractdetail.setContractdetail_price(rs.getDouble("contractdetail_price"));
			contractdetail.setContractdetail_num(rs.getInt("contractdetail_num"));
			contractdetail.setContractdetail_unit(rs.getString("contractdetail_unit"));
			contractdetail.setContractdetail_url(rs.getString("contractdetail_url"));
			result.add(contractdetail);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public ContractDetail findById(int contractdetail_id) throws Exception {
		ContractDetail contractdetail = null;
		String sql = "SELECT * FROM t_contractdetail WHERE contractdetail_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, contractdetail_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			contractdetail = new ContractDetail();
			contractdetail.setContractdetail_id(rs.getInt("contractdetail_id"));
			contractdetail.setContractdetail_contractid(rs.getInt("contractdetail_contractid"));
			contractdetail.setContractdetail_supplygoodsid(rs.getInt("contractdetail_supplygoodsid"));
			contractdetail.setContractdetail_price(rs.getDouble("contractdetail_price"));
			contractdetail.setContractdetail_num(rs.getInt("contractdetail_num"));
			contractdetail.setContractdetail_unit(rs.getString("contractdetail_unit"));
			contractdetail.setContractdetail_url(rs.getString("contractdetail_url"));
		}
		this.pstmt.close();
		return contractdetail;
	}

}

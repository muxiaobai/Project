package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.ContractMediaDao;
import DataBaseTable.ContractMedia;
import DataBaseTable.Role;

public class ContractMediaDaoImpl implements ContractMediaDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public ContractMediaDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(ContractMedia contractmedia) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_contractmedia(contractmedia_contractid,contractmedia_title,contractmedia_url) VALUES (?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, contractmedia.getContractmedia_contractid());
		this.pstmt.setString(2, contractmedia.getContractmedia_title());
		this.pstmt.setString(1, contractmedia.getContractmedia_url());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<ContractMedia> findAll(String keyWord) throws Exception {
		List<ContractMedia> result = new ArrayList<ContractMedia>();
		String sql = "SELECT * FROM t_contractmedia WHERE contractmedia_id LIKE ?  OR contractmedia_contractid LIKE ?  OR contractmedia_title  LIKE ? OR contractmedia_url  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		ContractMedia contractmedia = null;
		while (rs.next()) {
			contractmedia = new ContractMedia();
			contractmedia.setContractmedia_contractid(rs.getInt("contractmedia_id"));
			contractmedia.setContractmedia_contractid(rs.getInt("contractmedia_contractid"));
			contractmedia.setContractmedia_title(rs.getString("contractmedia_title"));
			contractmedia.setContractmedia_url(rs.getString("contractmedia_url"));
			result.add(contractmedia);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public ContractMedia findById(int contractmedia_id) throws Exception {
		ContractMedia contractmedia = null;
		String sql = "SELECT * FROM t_contractmedia WHERE contractmedia_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, contractmedia_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			contractmedia = new ContractMedia();
			contractmedia.setContractmedia_contractid(rs.getInt("contractmedia_id"));
			contractmedia.setContractmedia_contractid(rs.getInt("contractmedia_contractid"));
			contractmedia.setContractmedia_title(rs.getString("contractmedia_title"));
			contractmedia.setContractmedia_url(rs.getString("contractmedia_url"));
		}
		this.pstmt.close();
		return contractmedia;
	}

}

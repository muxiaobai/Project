package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.ContractDao;
import DataBaseTable.Contract;
import DataBaseTable.Role;

public class ContractDaoImpl implements ContractDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public ContractDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Contract contract) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_contract(contract_number,contract_supplierid,contract_sum,contract_staffid,contract_time,contract_context) VALUES (?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, contract.getContract_number());
		this.pstmt.setInt(2, contract.getContract_supplierid());
		this.pstmt.setDouble(2, contract.getContract_sum());
		this.pstmt.setInt(2, contract.getContract_staffid());
		this.pstmt.setDate(2, contract.getContract_time());
		this.pstmt.setString(2, contract.getContract_context());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Contract> findAll(String keyWord) throws Exception {
		List<Contract> result = new ArrayList<Contract>();
		String sql = "SELECT * FROM t_contract WHERE  contract_id LIKE ?  OR contract_number  LIKE ? OR contract_supplierid  LIKE ? OR contract_sum  LIKE ? OR contract_staffid  LIKE ? OR contract_time  LIKE ? OR contract_context  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		this.pstmt.setString(7, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Contract contract = null;
		while (rs.next()) {
			contract = new Contract();
			contract.setContract_id(rs.getInt("contract_id"));
			contract.setContract_number(rs.getString("contract_number"));
			contract.setContract_supplierid(rs.getInt("contract_supplierid"));
			contract.setContract_sum(rs.getDouble("contract_sum"));
			contract.setContract_staffid(rs.getInt("contract_staffid"));
			contract.setContract_id(rs.getInt("contract_time"));
			contract.setContract_id(rs.getInt("contract_context"));
			result.add(contract);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public Contract findById(int contract_id) throws Exception {
		Contract contract = null;
		String sql = "SELECT * FROM t_contract WHERE contract_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, contract_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			contract = new Contract();
			contract.setContract_id(rs.getInt("contract_id"));
			contract.setContract_number(rs.getString("contract_number"));
			contract.setContract_supplierid(rs.getInt("contract_supplierid"));
			contract.setContract_sum(rs.getDouble("contract_sum"));
			contract.setContract_staffid(rs.getInt("contract_staffid"));
			contract.setContract_id(rs.getInt("contract_time"));
			contract.setContract_id(rs.getInt("contract_context"));
		}
		this.pstmt.close();
		return contract;
	}

}

package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.PayexamDao;
import DataBaseTable.Payexam;
import DataBaseTable.Role;

public class PayexamDaoImpl implements PayexamDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public PayexamDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(Payexam Payexam) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_payexam(payexam_contractid,payexam_cashier_staffid,payexam_approver_staffid,payexam_time,payexam_result,payexam_reason,payexam_postponetime) VALUES (?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Payexam.getPayexam_contractid());
		this.pstmt.setInt(2, Payexam.getPayexam_cashier_staffid());
		this.pstmt.setInt(3, Payexam.getPayexam_approver_staffid());
		this.pstmt.setTimestamp(4, Payexam.getPayexam_time());
		this.pstmt.setString(5, Payexam.getPayexam_result());
		this.pstmt.setString(6, Payexam.getPayexam_reason());
		this.pstmt.setTimestamp(7, Payexam.getPayexam_postponetime());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Payexam> findAll(String keyWord) throws Exception {
		List<Payexam> result = new ArrayList<Payexam>();
		String sql = "SELECT * FROM t_payexam WHERE  payexam_id LIKE ?  OR payexam_contractid LIKE ?  OR payexam_cashier_staffid LIKE ?  OR payexam_approver_staffid LIKE ?  OR payexam_time LIKE ?  OR payexam_result LIKE ?  OR payexam_reason LIKE ?  OR payexam_postponetime LIKE ?  ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		this.pstmt.setString(7, "%" + keyWord + "%");
		this.pstmt.setString(8, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Payexam Payexam = null;
		while (rs.next()) {
			Payexam = new Payexam();
			Payexam.setPayexam_id(rs.getInt("payexam_id"));
			Payexam.setPayexam_contractid(rs.getInt("payexam_contractid"));
			Payexam.setPayexam_cashier_staffid(rs.getInt("payexam_cashier_staffid"));
			Payexam.setPayexam_approver_staffid(rs.getInt("payexam_approver_staffid"));
			Payexam.setPayexam_time(rs.getTimestamp("payexam_time"));
			Payexam.setPayexam_result(rs.getString("payexam_result"));
			Payexam.setPayexam_reason(rs.getString("payexam_reason"));
			Payexam.setPayexam_postponetime(rs.getTimestamp("payexam_postponetime"));
			result.add(Payexam);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Payexam findById(int payexam_id) throws Exception {
		Payexam Payexam= null;
		String sql = "SELECT * FROM t_payexam WHERE payexam_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,payexam_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Payexam = new Payexam();
			Payexam.setPayexam_id(rs.getInt("payexam_id"));
			Payexam.setPayexam_contractid(rs.getInt("payexam_contractid"));
			Payexam.setPayexam_cashier_staffid(rs.getInt("payexam_cashier_staffid"));
			Payexam.setPayexam_approver_staffid(rs.getInt("payexam_approver_staffid"));
			Payexam.setPayexam_time(rs.getTimestamp("payexam_time"));
			Payexam.setPayexam_result(rs.getString("payexam_result"));
			Payexam.setPayexam_reason(rs.getString("payexam_reason"));
			Payexam.setPayexam_postponetime(rs.getTimestamp("payexam_postponetime"));
		
		}
		this.pstmt.close();
		return Payexam;
	}

}

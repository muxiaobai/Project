package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.StaffDao;
import DataBaseTable.Staff;

public class StaffDaoImpl implements StaffDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public StaffDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Staff Staff) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_staff(staff_number,staff_password,staff_idcard,staff_birth,staff_sex,staff_education,staff_tel,staff_email,staff_department,staff_role,staff_into,staff_remark,staff_province,staff_city,staff_country,staff_street,staff_address) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, Staff.getStaff_number());
		this.pstmt.setString(2, Staff.getStaff_password());
		this.pstmt.setString(3, Staff.getStaff_idcard());
		this.pstmt.setDate(4, Staff.getStaff_birth());
		this.pstmt.setInt(5, Staff.getStaff_sex());
		this.pstmt.setString(5, Staff.getStaff_education());
		this.pstmt.setString(6, Staff.getStaff_tel());
		this.pstmt.setString(7, Staff.getStaff_email());
		this.pstmt.setInt(8, Staff.getStaff_department());
		this.pstmt.setInt(9, Staff.getStaff_role());
		this.pstmt.setDate(10, Staff.getStaff_into());
		this.pstmt.setString(11, Staff.getStaff_remark());
		this.pstmt.setString(12, Staff.getStaff_province());
		this.pstmt.setString(13, Staff.getStaff_city());
		this.pstmt.setString(14, Staff.getStaff_country());
		this.pstmt.setString(15, Staff.getStaff_street());
		this.pstmt.setString(16, Staff.getStaff_address());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}

	@Override
	public boolean doDelete(int staff_id) throws Exception {
		boolean flag = false;
		String sql = "delete from t_staff where staff_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, staff_id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Staff> findAll(String keyWord) throws Exception {
		List<Staff> result = new ArrayList<Staff>();
		String sql = "SELECT * FROM t_staff WHERE   "
				+ " OR staff_number   LIKE ?  OR staff_password   LIKE ?  "
				+ "OR staff_name   LIKE ? OR  staff_idcard  LIKE ? "
				+ "OR  staff_birth  LIKE ?  OR staff_education   LIKE ? OR   staff_tel LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		this.pstmt.setString(7, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Staff Staff = null;
		while (rs.next()) {
			Staff = new Staff();
			Staff.setStaff_id(rs.getInt("staff_id"));
			Staff.setStaff_number(rs.getString("staff_number"));
			Staff.setStaff_password(rs.getString("staff_password"));
			Staff.setStaff_name(rs.getString("staff_name"));
			Staff.setStaff_idcard(rs.getString("staff_idcard"));
			Staff.setStaff_birth(rs.getDate("staff_birth"));
			Staff.setStaff_sex(rs.getInt("staff_sex"));
			Staff.setStaff_education(rs.getString("staff_education"));
			Staff.setStaff_tel(rs.getString("staff_tel"));
			Staff.setStaff_email(rs.getString("staff_email"));
			Staff.setStaff_department(rs.getInt("staff_department"));
			Staff.setStaff_role(rs.getInt("staff_role"));
			Staff.setStaff_into(rs.getDate("staff_into"));
			Staff.setStaff_remark(rs.getString("staff_remark"));
			Staff.setStaff_province(rs.getString("staff_province"));
			Staff.setStaff_city(rs.getString("staff_city"));
			Staff.setStaff_country(rs.getString("staff_country"));
			Staff.setStaff_street(rs.getString("staff_street"));
			Staff.setStaff_address(rs.getString("staff_address"));	
			result.add(Staff);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Staff findById(int staff_id) throws Exception {
		Staff Staff = null;
		String sql = "SELECT * FROM t_staff  WHERE staff_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, staff_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
		
			Staff = new Staff();
			Staff.setStaff_id(rs.getInt("staff_id"));
			Staff.setStaff_number(rs.getString("staff_number"));
			Staff.setStaff_password(rs.getString("staff_password"));
			Staff.setStaff_name(rs.getString("staff_name"));
			Staff.setStaff_idcard(rs.getString("staff_idcard"));
			Staff.setStaff_birth(rs.getDate("staff_birth"));
			Staff.setStaff_sex(rs.getInt("staff_sex"));
			Staff.setStaff_education(rs.getString("staff_education"));
			Staff.setStaff_tel(rs.getString("staff_tel"));
			Staff.setStaff_email(rs.getString("staff_email"));
			Staff.setStaff_department(rs.getInt("staff_department"));
			Staff.setStaff_role(rs.getInt("staff_role"));
			Staff.setStaff_into(rs.getDate("staff_into"));
			Staff.setStaff_remark(rs.getString("staff_remark"));
			Staff.setStaff_province(rs.getString("staff_province"));
			Staff.setStaff_city(rs.getString("staff_city"));
			Staff.setStaff_country(rs.getString("staff_country"));
			Staff.setStaff_street(rs.getString("staff_street"));
			Staff.setStaff_address(rs.getString("staff_address"));	
		
			}
		this.pstmt.close();
		return Staff;
	}

}

package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.DepartmentDao;
import DataBaseTable.Department;
import DataBaseTable.Role;

public class DepartmentDaoImpl implements DepartmentDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public DepartmentDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Department department) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_department(department_name,department_remark) VALUES (?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, department.getDepartment_name());
		this.pstmt.setString(2, department.getDepartment_remark());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Department> findAll(String keyWord) throws Exception {
		List<Department> result = new ArrayList<Department>();
		String sql = "SELECT * FROM t_department WHERE  department_id LIKE ?  OR department_name  LIKE ? OR department_remark  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Department department = null;
		while (rs.next()) {
			department = new Department();
			department.setDepartment_id(rs.getInt("department_id"));
			department.setDepartment_name(rs.getString("department_name"));
			department.setDepartment_name(rs.getString("department_reamrk"));
			result.add(department);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public Department findById(int department_id) throws Exception {
		Department department = null;
		String sql = "SELECT * FROM t_department WHERE department_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, department_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			department = new Department();
			department.setDepartment_id(rs.getInt("department_id"));
			department.setDepartment_name(rs.getString("department_name"));
			department.setDepartment_name(rs.getString("department_reamrk"));
		}
		this.pstmt.close();
		return department;
	}

}

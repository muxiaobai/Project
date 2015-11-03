package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.RoleDao;
import DataBaseTable.Role;
//Role实现类
public class RoleDaoImpl implements RoleDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public RoleDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Role role) throws Exception {

		boolean flag = false;
		String sql = "INSERT INTO t_role(role_id,role_name) VALUES (?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, role.getRole_id());
		this.pstmt.setString(2, role.getRole_name());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}
	@Override
	public boolean doDelete(int role_id) throws Exception {
		boolean flag = false;
		String sql = "delete from t_role where role_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, role_id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
		
	}

	
	@Override
	public List<Role> findAll(String keyWord) throws Exception {
		List<Role> result = new ArrayList<Role>();
		String sql = "SELECT * FROM t_role WHERE  role_id LIKE ?  OR role_name  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Role role = null;
		while (rs.next()) {
			role = new Role();
			role.setRole_id(rs.getInt("role_id"));
			role.setRole_name(rs.getString("role_name"));
			result.add(role);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public Role findById(int role_id) throws Exception {
		Role role = null;
		String sql = "SELECT * FROM t_role WHERE role_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, role_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			role = new Role();
			role.setRole_id(rs.getInt("role_id"));
			role.setRole_name(rs.getString("role_name"));
		}
		this.pstmt.close();
		return role;
	}

	
}

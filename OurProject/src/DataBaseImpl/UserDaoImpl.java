package DataBaseImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.UserDao;
import DataBaseTable.User;
public class UserDaoImpl implements UserDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(User User) throws Exception {

		boolean flag = false;
		String sql = "INSERT INTO t_user(user_name,user_state,user_province,user_city,user_country,user_street,user_address,user_qq,user_weibo,user_weixin,user_zhifubao,user_idcard,user_tel,user_type,user_point) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, User.getUser_name());
		this.pstmt.setInt(2, User.getUser_state());
		this.pstmt.setString(3, User.getUser_province());
		this.pstmt.setString(4, User.getUser_city());
		this.pstmt.setString(5, User.getUser_country());
		this.pstmt.setString(6, User.getUser_street());
		this.pstmt.setString(7, User.getUser_address());
		this.pstmt.setString(8, User.getUser_qq());
		this.pstmt.setString(9, User.getUser_weibo());
		this.pstmt.setString(10, User.getUser_weixin());
		this.pstmt.setString(11, User.getUser_zhifubao());
		this.pstmt.setString(12, User.getUser_idcard());
		this.pstmt.setString(13, User.getUser_tel());
		this.pstmt.setString(14, User.getUser_type());
		this.pstmt.setDouble(15, User.getUser_point());
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doDelete(int user_id) throws Exception {
		boolean flag = false;
		String sql = "delete from t_user where user_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, user_id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<User> findAll(String keyWord) throws Exception {
		List<User> result = new ArrayList<User>();
		String sql = "SELECT * FROM t_user WHERE  user_name LIKE ?  OR user_address  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		User User = null;
		while (rs.next()) {
			User = new User();
			User.setUser_id(rs.getInt("user_id"));
			User.setUser_name(rs.getString("user_name"));
			User.setUser_state(rs.getInt("user_state"));
			User.setUser_province(rs.getString("user_province"));
			User.setUser_city(rs.getString("user_city"));
			User.setUser_country(rs.getString("user_country"));
			User.setUser_street(rs.getString("user_street"));
			User.setUser_address(rs.getString("user_address"));
			User.setUser_qq(rs.getString("user_qq"));
			User.setUser_weixin(rs.getString("user_weixin"));
			User.setUser_weixin(rs.getString("user_weixin"));
			User.setUser_zhifubao(rs.getString("user_zhifubao"));
			User.setUser_idcard(rs.getString("user_idcard"));
			User.setUser_tel(rs.getString("user_tel"));
			User.setUser_type(rs.getString("user_type"));
			User.setUser_point(rs.getDouble("user_point"));
			result.add(User);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public User findById(int user_id) throws Exception {
		User User = null;
		String sql = "SELECT * FROM t_user WHERE user_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, user_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			User = new User();
			User.setUser_id(rs.getInt("user_id"));
			User.setUser_name(rs.getString("user_name"));
			User.setUser_state(rs.getInt("user_state"));
			User.setUser_province(rs.getString("user_province"));
			User.setUser_city(rs.getString("user_city"));
			User.setUser_country(rs.getString("user_country"));
			User.setUser_street(rs.getString("user_street"));
			User.setUser_address(rs.getString("user_address"));
			User.setUser_qq(rs.getString("user_qq"));
			User.setUser_weixin(rs.getString("user_weixin"));
			User.setUser_weixin(rs.getString("user_weixin"));
			User.setUser_zhifubao(rs.getString("user_zhifubao"));
			User.setUser_idcard(rs.getString("user_idcard"));
			User.setUser_tel(rs.getString("user_tel"));
			User.setUser_type(rs.getString("user_type"));
			User.setUser_point(rs.getDouble("user_point"));
		}
		this.pstmt.close();
		return User;
	}

}

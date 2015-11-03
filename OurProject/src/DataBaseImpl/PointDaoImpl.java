package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseTable.Point;
import DataBaseTable.Role;
import DataBaseDao.PointDao;

public class PointDaoImpl implements PointDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public PointDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Point point) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_point(point_orderid,point_reduce,point_raise,point_state) VALUES (?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, point.getPoint_orderid());
		this.pstmt.setDouble(2, point.getPoint_reduce());
		this.pstmt.setDouble(3, point.getPoint_raise());
		this.pstmt.setInt(4, point.getPoint_state());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Point> findAll(String keyWord) throws Exception {
		List<Point> result = new ArrayList<Point>();
		String sql = "SELECT * FROM t_point WHERE  point_id LIKE ?  OR point_orderid  LIKE ? OR point_reduce  LIKE ? OR point_raise  LIKE ? OR point_state LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Point point = null;
		while (rs.next()) {
			point = new Point();
			point.setPoint_id(rs.getInt("point_id"));
			point.setPoint_orderid(rs.getInt("point_orderid"));
			point.setPoint_reduce(rs.getDouble("point_reduce"));
			point.setPoint_raise(rs.getDouble("point_raise"));
			point.setPoint_id(rs.getInt("point_state"));
			result.add(point);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Point findById(int point_id) throws Exception {
		Point point = null;
		String sql = "SELECT * FROM t_point WHERE point_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, point_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			point = new Point();
			point.setPoint_id(rs.getInt("point_id"));
			point.setPoint_orderid(rs.getInt("point_orderid"));
			point.setPoint_reduce(rs.getDouble("point_reduce"));
			point.setPoint_raise(rs.getDouble("point_raise"));
			point.setPoint_id(rs.getInt("point_state"));

		}
		this.pstmt.close();
		return point;
	}

}

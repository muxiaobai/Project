package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.SupplierneedDao;
import DataBaseTable.Supplierneed;

public class SupplierneedDaoImpl implements SupplierneedDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public SupplierneedDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Supplierneed Supplierneed) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_supplierneed(supplierneed_supplierid,supplierneed_nummber,supplierneed_unit,supplierneed_hightime,supplierneed_lowprice,supplierneed_begintime,supplierneed_endtime,supplierneed_state,supplierneed_reason) VALUES (?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Supplierneed.getSupplierneed_supplierid());
		this.pstmt.setInt(2, Supplierneed.getSupplierneed_number());
		this.pstmt.setString(3,Supplierneed.getSupplierneed_unit() );
		this.pstmt.setDouble(4,Supplierneed.getSupplierneed_highprice());
		this.pstmt.setDouble(5,Supplierneed.getSupplierneed_lowprice());
		this.pstmt.setTimestamp(6, Supplierneed.getSupplierneed_begintime());	
		this.pstmt.setTimestamp(7, Supplierneed.getSupplierneed_endtime());
		this.pstmt.setString(8, Supplierneed.getSupplierneed_state());
		this.pstmt.setTimestamp(9, Supplierneed.getSupplierneed_statetime());
		this.pstmt.setString(10	,Supplierneed.getSupplierneed_reason() );
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doDelete(int supplierneed_id) throws Exception {
		boolean flag = false;
		String sql = "delete from t_supplierneed_id where supplierneed_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, supplierneed_id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Supplierneed> findAll(String keyWord) throws Exception {
		List<Supplierneed> result = new ArrayList<Supplierneed>();
		String sql = "SELECT * FROM t_supplierneed WHERE  supplierneed_reason LIKE ?  OR supplierneed_begintime  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Supplierneed Supplierneed = null;
		while (rs.next()) {
			Supplierneed = new Supplierneed();
			Supplierneed.setSupplierneed_id(rs.getInt("supplierneed_id"));
			Supplierneed.setSupplierneed_supplierid(rs.getInt("supplierneed_supplierid"));
			Supplierneed.setSupplierneed_number(rs.getInt("supplierneed_number"));
			Supplierneed.setSupplierneed_unit(rs.getString("supplierneed_unit"));
			Supplierneed.setSupplierneed_highprice(rs.getDouble("supplierneed_highprice"));
			Supplierneed.setSupplierneed_lowprice(rs.getDouble("supplierneed_lowprice"));
			Supplierneed.setSupplierneed_begintime(rs.getTimestamp("supplierneed_begintime"));
			Supplierneed.setSupplierneed_endtime(rs.getTimestamp("supplierneed_endtime"));
			Supplierneed.setSupplierneed_state(rs.getString("supplierneed_state"));
			Supplierneed.setSupplierneed_statetime(rs.getTimestamp("supplierneed_statetime"));
			Supplierneed.setSupplierneed_reason(rs.getString("supplierneed_reason"));
			result.add(Supplierneed);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Supplierneed findById(int supplierneed_id) throws Exception {
		Supplierneed Supplierneed = null;
		String sql = "SELECT * FROM t_supplierneed WHERE supplierneed_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, supplierneed_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Supplierneed = new Supplierneed();
			Supplierneed.setSupplierneed_id(rs.getInt("supplierneed_id"));
			Supplierneed.setSupplierneed_supplierid(rs.getInt("supplierneed_supplierid"));
			Supplierneed.setSupplierneed_number(rs.getInt("supplierneed_number"));
			Supplierneed.setSupplierneed_unit(rs.getString("supplierneed_unit"));
			Supplierneed.setSupplierneed_highprice(rs.getDouble("supplierneed_highprice"));
			Supplierneed.setSupplierneed_lowprice(rs.getDouble("supplierneed_lowprice"));
			Supplierneed.setSupplierneed_begintime(rs.getTimestamp("supplierneed_begintime"));
			Supplierneed.setSupplierneed_endtime(rs.getTimestamp("supplierneed_endtime"));
			Supplierneed.setSupplierneed_state(rs.getString("supplierneed_state"));
			Supplierneed.setSupplierneed_statetime(rs.getTimestamp("supplierneed_statetime"));
			Supplierneed.setSupplierneed_reason(rs.getString("supplierneed_reason"));
		
		}
		this.pstmt.close();
		return Supplierneed;
	}

}

package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.OurneedDao;
import DataBaseTable.Ourneed;
import DataBaseTable.Role;

public class OurneedDaoImpl implements OurneedDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public OurneedDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(Ourneed Ourneed) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_ourneed(ourneed_categoryid,ourneed_publishtime,ourneed_begintime,ourneed_endtime,ourneed_number,ourneed_highprice,ourneed_lowprice,ourneed_unit,ourneed_tel,ourneed_detail) VALUES (?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Ourneed.getOurneed_categoryid());
		this.pstmt.setTimestamp(2, Ourneed.getOurneed_publishtime());
		this.pstmt.setTimestamp(3, Ourneed.getOurneed_begintime());
		this.pstmt.setTimestamp(4, Ourneed.getOurneed_endtime());
		this.pstmt.setInt(5, Ourneed.getOurneed_number());
		this.pstmt.setDouble(6, Ourneed.getOurneed_highprice());
		this.pstmt.setDouble(7, Ourneed.getOurneed_lowprice());
		this.pstmt.setString(8, Ourneed.getOurneed_unit());
		this.pstmt.setString(9, Ourneed.getOurneed_tel());
		this.pstmt.setString(10, Ourneed.getOurneed_detail());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Ourneed> findAll(String keyWord) throws Exception {
		List<Ourneed> result = new ArrayList<Ourneed>();
		String sql = "SELECT * FROM t_ourneed WHERE  ourneed_id LIKE ?  OR ourneed_categoryid LIKE ?  OR ourneed_publishtime LIKE ?  OR ourneed_begintime LIKE ?  OR ourneed_endtime LIKE ?  OR ourneed_number LIKE ?  OR ourneed_highprice LIKE ?  OR ourneed_lowprice LIKE ?  OR ourneed_unit LIKE ?  OR ourneed_tel LIKE ?  OR ourneed_detail";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6,"%" + keyWord + "%");
		this.pstmt.setString(7, "%" + keyWord + "%");
		this.pstmt.setString(8, "%" + keyWord + "%");
		this.pstmt.setString(9, "%" + keyWord + "%");
		this.pstmt.setString(10, "%" + keyWord + "%");
		this.pstmt.setString(11, "%" + keyWord + "%");
	
		ResultSet rs = this.pstmt.executeQuery();
		Ourneed Ourneed = null;
		while (rs.next()) {
			Ourneed = new Ourneed();
			Ourneed.setOurneed_id(rs.getInt("ourneed_id"));
			Ourneed.setOurneed_categoryid(rs.getInt("ourneed_categoryid"));
		    Ourneed.setOurneed_publishtime(rs.getTimestamp("ourneed_publishtime"));
		    Ourneed.setOurneed_begintime(rs.getTimestamp("ourneed_begintime"));
		    Ourneed.setOurneed_endtime(rs.getTimestamp("ourneed_endtime"));
		    Ourneed.setOurneed_number(rs.getInt("ourneed_number"));
		    Ourneed.setOurneed_highprice(rs.getDouble("ourneed_highprice"));
		    Ourneed.setOurneed_lowprice(rs.getDouble("ourneed_lowprice"));
		    Ourneed.setOurneed_unit(rs.getString("ourneed_unit"));
		    Ourneed.setOurneed_tel(rs.getString("ourneed_tel"));
		    Ourneed.setOurneed_detail(rs.getString("ourneed_detail"));
			result.add(Ourneed);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Ourneed findById(int ourneed_id) throws Exception {
		Ourneed Ourneed = null;
		String sql = "SELECT * FROM t_ourneed WHERE ourneed_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, ourneed_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Ourneed = new Ourneed();
			Ourneed.setOurneed_id(rs.getInt("ourneed_id"));
			Ourneed.setOurneed_categoryid(rs.getInt("ourneed_categoryid"));
		    Ourneed.setOurneed_publishtime(rs.getTimestamp("ourneed_publishtime"));
		    Ourneed.setOurneed_begintime(rs.getTimestamp("ourneed_begintime"));
		    Ourneed.setOurneed_endtime(rs.getTimestamp("ourneed_endtime"));
		    Ourneed.setOurneed_number(rs.getInt("ourneed_number"));
		    Ourneed.setOurneed_highprice(rs.getDouble("ourneed_highprice"));
		    Ourneed.setOurneed_lowprice(rs.getDouble("ourneed_lowprice"));
		    Ourneed.setOurneed_unit(rs.getString("ourneed_unit"));
		    Ourneed.setOurneed_tel(rs.getString("ourneed_tel"));
		    Ourneed.setOurneed_detail(rs.getString("ourneed_detail"));
		}
		this.pstmt.close();
		return Ourneed;
	}

}

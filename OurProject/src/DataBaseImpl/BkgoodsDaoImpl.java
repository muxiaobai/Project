package DataBaseImpl;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DataBaseDao.BkgoodsDao;
import DataBaseTable.Bkgoods;
import DataBaseTable.Role;

public class BkgoodsDaoImpl implements BkgoodsDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public BkgoodsDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Bkgoods bkgoods) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_bkgoods(bkgoods_number,bkgoods_stationid,bkgoods_orderid,bkgoods_time,bkgoods_money,bkgoods_state) VALUES (?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, bkgoods.getBkgoods_number());
		this.pstmt.setInt(2, bkgoods.getBkgoods_stationid());
		this.pstmt.setInt(3, bkgoods.getBkgoods_orderid());
		this.pstmt.setTimestamp(4, bkgoods.getBkgoods_time());
		this.pstmt.setDouble(5, bkgoods.getBkgoods_money());
		this.pstmt.setInt(6, bkgoods.getBkgoods_state());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}

	@Override
	public List<Bkgoods> findAll(String keyWord) throws Exception {
		List<Bkgoods> result = new ArrayList<Bkgoods>();
		String sql = "SELECT * FROM t_bkgoods WHERE  bkgoods_id LIKE ?  OR bkgoods_number  LIKE ? OR bkgoods_stationid  LIKE ? OR bkgoods_orderid  LIKE ? OR bkgoods_time  LIKE ? OR bkgoods_money  LIKE ? OR bkgoods_state  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		this.pstmt.setString(7, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Bkgoods bkgoods = null;
		while (rs.next()) {
			bkgoods = new Bkgoods();
			bkgoods.setBkgoods_id(rs.getInt("bkgoods_id"));
			bkgoods.setBkgoods_number(rs.getString("bkgoods_number"));
			bkgoods.setBkgoods_stationid(rs.getInt("bkgoods_stationid"));
			bkgoods.setBkgoods_orderid(rs.getInt("bkgoods_orderid"));
			bkgoods.setBkgoods_time(rs.getTimestamp("bkgoods_time"));
			bkgoods.setBkgoods_money(rs.getDouble("bkgoods_money"));
			bkgoods.setBkgoods_state(rs.getInt("bkgoods_state"));
			result.add(bkgoods);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public Bkgoods findById(int bkgoods_id) throws Exception {
		Bkgoods bkgoods = null;
		String sql = "SELECT * FROM t_bkgoods WHERE bkgoods_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, bkgoods_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			bkgoods = new Bkgoods();
			bkgoods.setBkgoods_id(rs.getInt("bkgoods_id"));
			bkgoods.setBkgoods_number(rs.getString("bkgoods_number"));
			bkgoods.setBkgoods_stationid(rs.getInt("bkgoods_stationid"));
			bkgoods.setBkgoods_orderid(rs.getInt("bkgoods_orderid"));
			bkgoods.setBkgoods_time(rs.getTimestamp("bkgoods_time"));
			bkgoods.setBkgoods_money(rs.getDouble("bkgoods_money"));
			bkgoods.setBkgoods_state(rs.getInt("bkgoods_state"));
		}
		this.pstmt.close();
		return bkgoods;
	}
	}



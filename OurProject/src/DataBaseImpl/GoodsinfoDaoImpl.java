package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import DataBaseDao.GoodsinfoDao;
import DataBaseTable.Goodsinfo;
import DataBaseTable.Role;

public class GoodsinfoDaoImpl implements GoodsinfoDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public GoodsinfoDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Goodsinfo Goodsinfo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_goodsinfo(goodsinfo_id,goodsinfo_time,goodsinfo_categoryid,goodsinfo_highprice,goodsinfo_lowprice,goodsinfo_staffid) VALUES (?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Goodsinfo.getGoodsinfo_id());
		this.pstmt.setTimestamp(2, Goodsinfo.getGoodsinfo_time());
		this.pstmt.setInt(3, Goodsinfo.getGoodsinfo_categoryid());
		this.pstmt.setDouble(4, Goodsinfo.getGoodsinfo_highprice());
		this.pstmt.setDouble(5, Goodsinfo.getGoodsinfo_lowprice());
		this.pstmt.setInt(6, Goodsinfo.getGoodsinfo_staffid());
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Goodsinfo> findAll(String keyWord) throws Exception {
		List<Goodsinfo> result = new ArrayList<Goodsinfo>();
		String sql = "SELECT * FROM t_goodsinfo WHERE  goodsinfo_id LIKE ?  OR goodsinfo_time  LIKE ? OR goodsinfo_categoryid LIKE ? OR goodsinfo_highprice  LIKE ? OR goodsinfo_lowprice  LIKE ? OR goodsinfo_staffid  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Goodsinfo  Goodsinfo  = null;
		while (rs.next()) {
			Goodsinfo  = new Goodsinfo ();
			Goodsinfo.setGoodsinfo_id(rs.getInt("goodsinfo_id"));
			Goodsinfo.setGoodsinfo_time(rs.getTimestamp("goodsinfo_time"));
			Goodsinfo.setGoodsinfo_categoryid(rs.getInt("goodsinfo_categoryid"));
			Goodsinfo.setGoodsinfo_highprice(rs.getDouble("goodsinfo_highprice"));
			Goodsinfo.setGoodsinfo_lowprice(rs.getDouble("goodsinfo_lowprice"));
			Goodsinfo.setGoodsinfo_staffid(rs.getInt("goodsinfo_staffid"));
			result.add(Goodsinfo);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public Goodsinfo findById(int goodsinfo_id) throws Exception {
		Goodsinfo Goodsinfo = null;
		String sql = "SELECT * FROM t_goodsinfo WHERE goodsinfo_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, goodsinfo_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Goodsinfo = new Goodsinfo();
			Goodsinfo.setGoodsinfo_id(rs.getInt("goodsinfo_id"));
			Goodsinfo.setGoodsinfo_time(rs.getTimestamp("Goodsinfo_time"));
			Goodsinfo.setGoodsinfo_categoryid(rs.getInt("goodsinfo_categoryid"));
			Goodsinfo.setGoodsinfo_highprice(rs.getDouble("goodsinfo_highprice"));
			Goodsinfo.setGoodsinfo_lowprice(rs.getDouble("goodsinfo_lowprice"));
			Goodsinfo.setGoodsinfo_staffid(rs.getInt("goodsinfo_staffid"));
		}
		this.pstmt.close();
		return Goodsinfo;
	}

}

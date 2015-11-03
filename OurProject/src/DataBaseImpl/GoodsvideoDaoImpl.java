package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.GoodsvideoDao;
import DataBaseTable.Goodsvideo;
import DataBaseTable.Role;

public class GoodsvideoDaoImpl implements GoodsvideoDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public GoodsvideoDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Goodsvideo Goodsvideo ) throws Exception {

		boolean flag = false;
		String sql = "INSERT INTO t_goodsvideo(goodsvideo_id,goodsvideo_goodid,goodsvideo_url) VALUES (?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Goodsvideo.getGoodsvideo_id());
		this.pstmt.setInt(2, Goodsvideo.getGoodsvideo_goodid());
		this.pstmt.setString(3, Goodsvideo.getGoodsvideo_url());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}

	@Override
	public List<Goodsvideo> findAll(String keyWord) throws Exception {
		List<Goodsvideo> result = new ArrayList<Goodsvideo>();
		String sql = "SELECT * FROM t_goodsvideo WHERE  goodsvideo_id LIKE ?  OR goodsvideo_goodid  LIKE ? OR goodsvideo_url LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Goodsvideo Goodsvideo= null;
		while (rs.next()) {
			Goodsvideo= new Goodsvideo();
			Goodsvideo.setGoodsvideo_id(rs.getInt("goodsvideo_id"));
			Goodsvideo.setGoodsvideo_goodid(rs.getInt("goodsvideo_goodid"));
			Goodsvideo.setGoodsvideo_url(rs.getString("goodsvideo_url"));
			result.add(Goodsvideo);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public Goodsvideo findById(int goodsvideo_id) throws Exception {
		Goodsvideo Goodsvideo= null;
		String sql = "SELECT * FROM t_goodsvideo WHERE goodsvideo_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, goodsvideo_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Goodsvideo= new Goodsvideo();
			Goodsvideo.setGoodsvideo_id(rs.getInt("goodsvideo_id"));
			Goodsvideo.setGoodsvideo_goodid(rs.getInt("goodsvideo_goodid"));
			Goodsvideo.setGoodsvideo_url(rs.getString("goodsvideo_url"));
			
		}
		this.pstmt.close();
		return Goodsvideo;
	}

}

package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.GoodsgradeDao;
import DataBaseTable.Goodsgrade;
import DataBaseTable.Role;

public class GoodsgradeDaoImpl implements GoodsgradeDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public GoodsgradeDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(Goodsgrade Goodsgrade) throws Exception {

		boolean flag = false;
		String sql = "INSERT INTO t_goodsgrade(goodsgrade_id,goodsgrade_name,goodsgrade_category) VALUES (?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Goodsgrade.getGoodsgrade_id());
		this.pstmt.setString(2, Goodsgrade.getGoodsgrade_name());
		this.pstmt.setInt(3, Goodsgrade.getGoodsgrade_category());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Goodsgrade> findAll(String keyWord) throws Exception {
		List<Goodsgrade> result = new ArrayList<Goodsgrade>();
		String sql = "SELECT * FROM t_goodsgrade WHERE  goodsgrade_id LIKE ?  OR goodsgrade_name  LIKE ? OR goodsgrade_category LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Goodsgrade Goodsgrade = null;
		while (rs.next()) {
			Goodsgrade = new Goodsgrade();
			Goodsgrade.setGoodsgrade_id(rs.getInt("goodsgrade_id"));
			Goodsgrade.setGoodsgrade_name(rs.getString("goodsgrade_name"));
			Goodsgrade.setGoodsgrade_category(rs.getInt("goodsgrade_category"));
			result.add(Goodsgrade);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public Goodsgrade findById(int goodsgrade_id) throws Exception {
		Goodsgrade Goodsgrade = null;
		String sql = "SELECT * FROM t_goodsgrade WHERE goodsgrade_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, goodsgrade_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Goodsgrade = new Goodsgrade();
			Goodsgrade.setGoodsgrade_id(rs.getInt("goodsgrade_id"));
			Goodsgrade.setGoodsgrade_name(rs.getString("goodsgrade_name"));
			Goodsgrade.setGoodsgrade_category(rs.getInt("goodsgrade_category"));
		}
		this.pstmt.close();
		return Goodsgrade;
	}

}

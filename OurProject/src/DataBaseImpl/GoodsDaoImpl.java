package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.GoodsDao;
import DataBaseTable.Goods;
import DataBaseTable.Role;

public class GoodsDaoImpl implements GoodsDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public GoodsDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Goods goods) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_goods(goods_category,goods_grade,goods_name,goods_price,goods_producetime,goods_place,goods_inventory,goods_unit,goods_anothername,goods_video,goods_vantage,goods_type,goods_saletime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, goods.getGoods_category());
		this.pstmt.setInt(2, goods.getGoods_grade());
		this.pstmt.setString(3, goods.getGoods_name());
		this.pstmt.setDouble(4, goods.getGoods_price());
		this.pstmt.setTimestamp(5, goods.getGoods_producetime());
		this.pstmt.setString(6, goods.getGoods_place());
		this.pstmt.setInt(7, goods.getGoods_inventory());
		this.pstmt.setString(8, goods.getGoods_unit());
		this.pstmt.setString(9, goods.getGoods_anothername());
		this.pstmt.setInt(10, goods.getGoods_video());
		this.pstmt.setString(11, goods.getGoods_vantage());
		this.pstmt.setInt(12, goods.getGoods_type());
		this.pstmt.setTimestamp(13, goods.getGoods_saletime());
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Goods> findAll(String keyWord) throws Exception {
		List<Goods> result = new ArrayList<Goods>();
		String sql = "SELECT * FROM t_goods WHERE  goods_id LIKE ? OR goods_category  LIKE ? OR goods_grade  LIKE ? OR goods_name  LIKE ? OR goods_price  LIKE ? OR goods_producetime  LIKE ? OR goods_place  LIKE ? OR goods_inventory  LIKE ? OR goods_unit  LIKE ? OR goods_anothername  LIKE ? OR goods_video  LIKE ? OR goods_vantage  LIKE ? OR goods_type  LIKE ? OR goods_saletime  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		this.pstmt.setString(7, "%" + keyWord + "%");
		this.pstmt.setString(8, "%" + keyWord + "%");
		this.pstmt.setString(9, "%" + keyWord + "%");
		this.pstmt.setString(10, "%" + keyWord + "%");
		this.pstmt.setString(11, "%" + keyWord + "%");
		this.pstmt.setString(12, "%" + keyWord + "%");
		this.pstmt.setString(13, "%" + keyWord + "%");
		this.pstmt.setString(14, "%" + keyWord + "%");
		
		ResultSet rs = this.pstmt.executeQuery();
		Goods goods = null;
		while (rs.next()) {
			goods = new Goods();
			goods.setGoods_id(rs.getInt("goods_id"));
			goods.setGoods_category(rs.getInt("goods_category"));
			goods.setGoods_grade(rs.getInt("goods_grade"));
			goods.setGoods_name(rs.getString("goods_name"));
			goods.setGoods_price(rs.getDouble("goods_price"));
			goods.setGoods_producetime(rs.getTimestamp("goods_producetime"));
			goods.setGoods_place(rs.getString("goods_place"));
			goods.setGoods_inventory(rs.getInt("goods_inventory"));
			goods.setGoods_unit(rs.getString("goods_unit"));
			goods.setGoods_anothername(rs.getString("goods_anothername"));
			goods.setGoods_video(rs.getInt("goods_video"));
			goods.setGoods_vantage(rs.getString("goods_vantage"));
			goods.setGoods_type(rs.getInt("goods_type"));
			goods.setGoods_saletime(rs.getTimestamp("goods_saletime"));

			result.add(goods);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Goods findById(int goods_id) throws Exception {
		Goods goods = null;
		String sql = "SELECT * FROM t_goods WHERE goods_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, goods_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			goods = new Goods();
			goods.setGoods_id(rs.getInt("goods_id"));
			goods.setGoods_category(rs.getInt("goods_category"));
			goods.setGoods_grade(rs.getInt("goods_grade"));
			goods.setGoods_name(rs.getString("goods_name"));
			goods.setGoods_price(rs.getDouble("goods_price"));
			goods.setGoods_producetime(rs.getTimestamp("goods_producetime"));
			goods.setGoods_place(rs.getString("goods_place"));
			goods.setGoods_inventory(rs.getInt("goods_inventory"));
			goods.setGoods_unit(rs.getString("goods_unit"));
			goods.setGoods_anothername(rs.getString("goods_anothername"));
			goods.setGoods_video(rs.getInt("goods_video"));
			goods.setGoods_vantage(rs.getString("goods_vantage"));
			goods.setGoods_type(rs.getInt("goods_type"));
			goods.setGoods_saletime(rs.getTimestamp("goods_saletime"));
		}
		this.pstmt.close();
		return goods;
	}

}

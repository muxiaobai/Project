package DataBaseImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.GoodsEvaluationDao;
import DataBaseTable.GoodsEvaluation;


public class GoodsEvaluationDaoImpl implements GoodsEvaluationDao{
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public GoodsEvaluationDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(GoodsEvaluation GoodsEvaluation) throws Exception {

		boolean flag = false;
		String sql = "INSERT INTO t_goods_evaluation(goods_evaluation_id,goods_evaluation_goodsid,goods_evaluation_orderid, goods_evaluation_degree,goods_evaluation_detail) VALUES (?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, GoodsEvaluation.getGoods_evaluation_id());
		this.pstmt.setInt(2, GoodsEvaluation.getGoods_evaluation_goodsid());
		this.pstmt.setInt(3, GoodsEvaluation.getGoods_evaluation_orderid() );
		this.pstmt.setInt(4, GoodsEvaluation.getGoods_evaluation_degree());
		this.pstmt.setString(5, GoodsEvaluation.getGoods_evaluation_detail());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}

	@Override
	public List<GoodsEvaluation> findAll(String keyWord) throws Exception {
		List<GoodsEvaluation> result = new ArrayList<GoodsEvaluation>();
		String sql = "SELECT * FROM t_goods_evaluation WHERE  goods_evaluation_id LIKE ?  OR goods_evaluation_goodsid  LIKE ? OR goods_evaluation_orderid LIKE ? OR goods_evaluation_degree LIKE ? OR goods_evaluation_detail LIKE ?" ;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		GoodsEvaluation GoodsEvaluation = null;
		while (rs.next()) {
			GoodsEvaluation = new GoodsEvaluation();
			GoodsEvaluation.setGoods_evaluation_id(rs.getInt("goods_evaluation_id"));
			GoodsEvaluation.setGoods_evaluation_goodsid(rs.getInt("goods_evaluation_goodsid"));
			GoodsEvaluation.setGoods_evaluation_orderid(rs.getInt("goods_evaluation_orderid"));
			GoodsEvaluation.setGoods_evaluation_degree(rs.getInt("goods_evaluation_degree"));
			GoodsEvaluation.setGoods_evaluation_detail(rs.getString("goods_evaluation_detail"));
			result.add(GoodsEvaluation);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public GoodsEvaluation findById(int goods_evaluation_id) throws Exception {
		GoodsEvaluation GoodsEvaluation = null;
		String sql = "SELECT * FROM t_goods_evaluation WHERE  goods_evaluation_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, goods_evaluation_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			GoodsEvaluation = new GoodsEvaluation();
			GoodsEvaluation.setGoods_evaluation_id(rs.getInt("goods_evaluation_id"));
			GoodsEvaluation.setGoods_evaluation_goodsid(rs.getInt("goods_evaluation_goodsid"));
			GoodsEvaluation.setGoods_evaluation_orderid(rs.getInt("goods_evaluation_orderid"));
			GoodsEvaluation.setGoods_evaluation_degree(rs.getInt("goods_evaluation_degree"));
			GoodsEvaluation.setGoods_evaluation_detail(rs.getString("goods_evaluation_detail"));
		}
		this.pstmt.close();
		return GoodsEvaluation;
	}

}

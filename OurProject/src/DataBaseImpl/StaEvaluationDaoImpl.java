package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.StaEvaluationDao;
import DataBaseTable.StaEvaluation;

public class StaEvaluationDaoImpl implements StaEvaluationDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public StaEvaluationDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(StaEvaluation StaEvaluation) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_sta_evaluation(sta_evalution_staid,sta_evaluation_orderid,sta_evaluation_attitude,sta_evaluation_distance,sta_evaluation_evnmt) VALUES (?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, StaEvaluation.getSta_evaluation_staid());
		this.pstmt.setInt(2, StaEvaluation.getSta_evaluation_orderid());
		this.pstmt.setInt(3, StaEvaluation.getSta_evaluation_attitude());
		this.pstmt.setInt(4, StaEvaluation.getSta_evaluation_distance());
		this.pstmt.setInt(5, StaEvaluation.getSta_evaluation_evnmt());		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}
	@Override
	public boolean doDelete(int sta_evaluation_id) throws Exception {
		boolean flag = false;
		String sql = "delete from t_sta_evaluation where sta_evaluation_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, sta_evaluation_id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<StaEvaluation> findAll(String keyWord) throws Exception {
		List<StaEvaluation> result = new ArrayList<StaEvaluation>();
		String sql = "SELECT * FROM t_role WHERE  role_id LIKE ?  OR role_name  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		StaEvaluation StaEvaluation = null;
		while (rs.next()) {
			StaEvaluation = new StaEvaluation();
			StaEvaluation.setSta_evaluation_id(rs.getInt("sta_evaluation_id"));
			StaEvaluation.setSta_evaluation_staid(rs.getInt("sta_evaluation_staid"));
			StaEvaluation.setSta_evaluation_orderid(rs.getInt("sta_evaluation_orderid"));
			StaEvaluation.setSta_evaluation_attitude(rs.getInt("sta_evaluation_attitude"));
			StaEvaluation.setSta_evaluation_distance(rs.getInt("sta_evaluation_distance"));
			
			result.add(StaEvaluation);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public StaEvaluation findById(int sta_evaluation_id) throws Exception {
		StaEvaluation StaEvaluation = null;
		String sql = "SELECT * FROM t_role WHERE role_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, sta_evaluation_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			StaEvaluation = new StaEvaluation();
			StaEvaluation.setSta_evaluation_id(rs.getInt("sta_evaluation_id"));
			StaEvaluation.setSta_evaluation_staid(rs.getInt("sta_evaluation_staid"));
			StaEvaluation.setSta_evaluation_orderid(rs.getInt("sta_evaluation_orderid"));
			StaEvaluation.setSta_evaluation_attitude(rs.getInt("sta_evaluation_attitude"));
			StaEvaluation.setSta_evaluation_distance(rs.getInt("sta_evaluation_distance"));
			
		}
		this.pstmt.close();
		return StaEvaluation;
	}
	
}

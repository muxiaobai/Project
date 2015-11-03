package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.GovnmtDao;
import DataBaseTable.Govnmt;


public class GovnmtDaoImpl implements GovnmtDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public GovnmtDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public boolean doCreate(Govnmt Govnmt) throws Exception {

		boolean flag = false;
		String sql = "INSERT INTO t_govnmt(govnmt_id,govnmt_type,govnmt_number,govnmt_name,govnmt_farnumber) VALUES (?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Govnmt.getGovnmt_id());
		this.pstmt.setString(2, Govnmt.getGovnmt_type());
		this.pstmt.setString(3, Govnmt.getGovnmt_number());
		this.pstmt.setString(4, Govnmt.getGovnmt_name());
		this.pstmt.setString(5, Govnmt.getGovnmt_farnumber());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}

	@Override
	public List<Govnmt> findAll(String keyWord) throws Exception {
		List<Govnmt> result = new ArrayList<Govnmt>();
		String sql = "SELECT * FROM t_govnmt WHERE govnmt_id LIKE ?  OR govnmt_type  LIKE ?  OR govnmt_number  LIKE ?  OR govnmt_name  LIKE ? OR govnmt_farnumber  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Govnmt Govnmt = null;
		while (rs.next()) {
			Govnmt = new Govnmt();
			Govnmt.setGovnmt_id(rs.getInt("govnmt_id"));
			Govnmt.setGovnmt_type(rs.getString("govnmt_type"));
			Govnmt.setGovnmt_number(rs.getString("govnmt_number"));
			Govnmt.setGovnmt_name(rs.getString("govnmt_name"));
			Govnmt.setGovnmt_farnumber(rs.getString("govnmt_farnumber"));
			result.add(Govnmt);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public Govnmt findById(int govnmt_id) throws Exception {
		Govnmt Govnmt = null;
		String sql = "SELECT * FROM t_govnmt WHERE govnmt_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, govnmt_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Govnmt = new Govnmt();
			Govnmt.setGovnmt_id(rs.getInt("govnmt_id"));
			Govnmt.setGovnmt_type(rs.getString("govnmt_type"));
			Govnmt.setGovnmt_number(rs.getString("govnmt_number"));
			Govnmt.setGovnmt_name(rs.getString("govnmt_name"));
			Govnmt.setGovnmt_farnumber(rs.getString("govnmt_farnumber"));
		}
		this.pstmt.close();
		return Govnmt;
	}

}

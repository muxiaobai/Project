package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.OtherinfoDao;
import DataBaseTable.Otherinfo;
import DataBaseTable.Role;

public class OtherinfoDaoImpl implements OtherinfoDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public OtherinfoDaoImpl(Connection conn) {
		this.conn = conn;
	}

	
	@Override
	public boolean doCreate(Otherinfo Otherinfo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_otherinfo(otherinfo_staffid,otherinfo_text) VALUES (?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Otherinfo.getOtherinfo_staffid());
		this.pstmt.setString(2, Otherinfo.getOtherinfo_text());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Otherinfo> findAll(String keyWord) throws Exception {
		List<Otherinfo> result = new ArrayList<Otherinfo>();
		String sql = "SELECT * FROM t_otherinfo WHERE  otherinfo_id LIKE ?  OR otherinfo_text  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Otherinfo Otherinfo = null;
		while (rs.next()) {
			Otherinfo = new Otherinfo();
			Otherinfo.setOtherinfo_id(rs.getInt("otherinfo_id"));
			Otherinfo.setOtherinfo_text(rs.getString("otherinfo_text"));
			result.add(Otherinfo);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Otherinfo findById(int otherinfo_id) throws Exception {
		Otherinfo Otherinfo = null;
		String sql = "SELECT * FROM t_otherinfo WHERE otherinfo_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,otherinfo_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Otherinfo = new Otherinfo();
			Otherinfo.setOtherinfo_id(rs.getInt("otherinfo_id"));
			Otherinfo.setOtherinfo_text(rs.getString("otherinfo_text"));
		}
		this.pstmt.close();
		return Otherinfo;
	}

}

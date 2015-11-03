package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.BkgoodsDetailDao;
import DataBaseTable.BkgoodsDetail;
import DataBaseTable.Role;


public class BkgoodsDetailDaoImpl implements BkgoodsDetailDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public BkgoodsDetailDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(BkgoodsDetail bkgoodsdetail) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_bkgoodsdetail(bkgoodsdetail_bkgoodsid,bkgoodsdetail_num,bkgoodsdetail_unit) VALUES (?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, bkgoodsdetail.getBkgoodsdetail_bkgoodsid());
		this.pstmt.setInt(2, bkgoodsdetail.getBkgoodsdetail_num());
		this.pstmt.setString(3, bkgoodsdetail.getBkgoodsdetail_unit());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<BkgoodsDetail> findAll(String keyWord) throws Exception {
		List<BkgoodsDetail> result = new ArrayList<BkgoodsDetail>();
		String sql = "SELECT * FROM t_bkgoodsdetail WHERE  bkgoodsdetail_id LIKE ?  OR bkgoodsdetail_bkgoodsid  LIKE ? OR bkgoodsdetail_num LIKE ? OR bkgoodsdetail_unit LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		BkgoodsDetail bkgoodsdetail = null;
		while (rs.next()) {
			bkgoodsdetail = new BkgoodsDetail();
			bkgoodsdetail.setBkgoodsdetail_id(rs.getInt("bkgoodsdetail_id"));
			bkgoodsdetail.setBkgoodsdetail_bkgoodsid(rs.getInt("bkgoodsdetail_bkgoodsid"));
			bkgoodsdetail.setBkgoodsdetail_num(rs.getInt("bkgoodsdetail_num"));
			bkgoodsdetail.setBkgoodsdetail_unit(rs.getString("bkgoodsdetail_unit"));
			result.add(bkgoodsdetail);
		}
		this.pstmt.close();
		return result;


	}

	@Override
	public BkgoodsDetail findById(int bkgoodsdetail_id) throws Exception {
		BkgoodsDetail bkgoodsdetail = null;
		String sql = "SELECT * FROM t_bkgoodsdetail WHERE bkgoodsdetail_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, bkgoodsdetail_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			bkgoodsdetail = new BkgoodsDetail();
			bkgoodsdetail.setBkgoodsdetail_id(rs.getInt("bkgoodsdetail_id"));
			bkgoodsdetail.setBkgoodsdetail_bkgoodsid(rs.getInt("bkgoodsdetail_bkgoodsid"));
			bkgoodsdetail.setBkgoodsdetail_num(rs.getInt("bkgoodsdetail_num"));
			bkgoodsdetail.setBkgoodsdetail_unit(rs.getString("bkgoodsdetail_unit"));
		}
		this.pstmt.close();
		return bkgoodsdetail;
	}

}

package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.OrderdetailDao;
import DataBaseTable.Orderdetail;
import DataBaseTable.Role;

public class OrderdetailDaoImpl implements OrderdetailDao {

	
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public OrderdetailDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(Orderdetail Orderdetail) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_orderdetail(detail_orderid,detail_goodsid,detail_goodsnumber,detail_goodsprice) VALUES (?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Orderdetail.getDetail_orderid());
		this.pstmt.setInt(2, Orderdetail.getDetail_goodsid());
		this.pstmt.setInt(3, Orderdetail.getDetail_goodsnumber());
		this.pstmt.setDouble(4, Orderdetail.getDetail_goodsprice());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Orderdetail> findAll(String keyWord) throws Exception {
		List<Orderdetail> result = new ArrayList<Orderdetail>();
		String sql = "SELECT * FROM t_orderdetail WHERE  detail_id LIKE ?  OR detail_orderid  LIKE ? OR detail_goodsid  LIKE ? OR detail_goodsnumber  LIKE ? OR detail_goodsprice  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Orderdetail Orderdetail = null;
		while (rs.next()) {
			Orderdetail = new Orderdetail();
			Orderdetail.setDetail_id(rs.getInt("detail_id"));
			Orderdetail.setDetail_orderid(rs.getInt("detail_orderid"));
			Orderdetail.setDetail_goodsid(rs.getInt("detail_goodsid"));
			Orderdetail.setDetail_goodsnumber(rs.getInt("detail_goodsnumber"));
			Orderdetail.setDetail_goodsprice(rs.getDouble("detail_goodsprice"));
			result.add(Orderdetail);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Orderdetail findById(int detail_id) throws Exception {
		Orderdetail Orderdetail = null;
		String sql = "SELECT * FROM t_orderdetail WHERE detail_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, detail_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Orderdetail = new Orderdetail();
			Orderdetail.setDetail_id(rs.getInt("detail_id"));
			Orderdetail.setDetail_orderid(rs.getInt("detail_orderid"));
			Orderdetail.setDetail_goodsid(rs.getInt("detail_goodsid"));
			Orderdetail.setDetail_goodsnumber(rs.getInt("detail_goodsnumber"));
			Orderdetail.setDetail_goodsprice(rs.getDouble("detail_goodsprice"));
		}
		this.pstmt.close();
		return Orderdetail;
	}

}

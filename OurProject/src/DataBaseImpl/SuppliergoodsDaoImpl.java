package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.SuppliergoodsDao;
import DataBaseTable.Suppliergoods;

public class SuppliergoodsDaoImpl implements SuppliergoodsDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public SuppliergoodsDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Suppliergoods Suppliergoods) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_suppliergoodss(suppliergoods_number,suppliergoods_supplierid,suppliergoods_categoryid,suppliergoods_highprice,suppliergoods_lowprice,suppliergoods_sum,suppliergoods_unit,suppliergoods_detail) VALUES (?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, Suppliergoods.getSuppliergoods_number());
		this.pstmt.setInt(2, Suppliergoods.getSuppliergoods_supplierid());
		this.pstmt.setInt(3, Suppliergoods.getSuppliergoods_categoryid());		
		this.pstmt.setDouble(4, Suppliergoods.getSuppliergoods_highprice());
		this.pstmt.setDouble(5, Suppliergoods.getSuppliergoods_lowprice());
		this.pstmt.setDouble(6, Suppliergoods.getSuppliergoods_sum());
		this.pstmt.setString(7, Suppliergoods.getSuppliergoods_unit());
		this.pstmt.setString(8, Suppliergoods.getSuppliergoods_detail());

		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}

	@Override
	public boolean doDelete(int suppliergoods_id) throws Exception {
		boolean flag = false;
		String sql = "delete from t_suppliergoods where suppliergoods_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, suppliergoods_id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Suppliergoods> findAll(String keyWord) throws Exception {
		List<Suppliergoods> result = new ArrayList<Suppliergoods>();
		String sql = "SELECT * FROM t_suppliergoods WHERE  detail LIKE ?  ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");

		ResultSet rs = this.pstmt.executeQuery();
		Suppliergoods Suppliergoods = null;
		while (rs.next()) {
			Suppliergoods = new Suppliergoods();
			Suppliergoods.setSuppliergoods_id(rs.getInt("suppliergoods_id"));
			Suppliergoods.setSuppliergoods_number(rs.getString("suppliergoods_number"));
			Suppliergoods.setSuppliergoods_supplierid(rs.getInt("suppliergoods_supplierid"));
			Suppliergoods.setSuppliergoods_categoryid(rs.getInt("suppliergoods_categoryid"));
			Suppliergoods.setSuppliergoods_highprice(rs.getDouble("suppliergoods_highprice"));
			Suppliergoods.setSuppliergoods_lowprice(rs.getDouble("suppliergoods_lowprice"));
			Suppliergoods.setSuppliergoods_sum(rs.getDouble("suppliergoods_sum"));
			Suppliergoods.setSuppliergoods_unit(rs.getString("suppliergoods_unit"));
			Suppliergoods.setSuppliergoods_detail(rs.getString("suppliergoods_detail"));
			result.add(Suppliergoods);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Suppliergoods findById(int suppliergoods_id) throws Exception {
		Suppliergoods Suppliergoods = null;
		String sql = "SELECT * FROM t_suppliergoods WHERE suppliergoods_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, suppliergoods_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Suppliergoods = new Suppliergoods();
			Suppliergoods.setSuppliergoods_id(rs.getInt("suppliergoods_id"));
			Suppliergoods.setSuppliergoods_number(rs.getString("suppliergoods_number"));
			Suppliergoods.setSuppliergoods_supplierid(rs.getInt("suppliergoods_supplierid"));
			Suppliergoods.setSuppliergoods_categoryid(rs.getInt("suppliergoods_categoryid"));
			Suppliergoods.setSuppliergoods_highprice(rs.getDouble("suppliergoods_highprice"));
			Suppliergoods.setSuppliergoods_lowprice(rs.getDouble("suppliergoods_lowprice"));
			Suppliergoods.setSuppliergoods_sum(rs.getDouble("suppliergoods_sum"));
			Suppliergoods.setSuppliergoods_unit(rs.getString("suppliergoods_unit"));
			Suppliergoods.setSuppliergoods_detail(rs.getString("suppliergoods_detail"));
			
		}
		this.pstmt.close();
		return Suppliergoods;
	}

}

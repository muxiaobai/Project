package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.SupplierDao;
import DataBaseTable.Supplier;

public class SupplierDaoImpl implements SupplierDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public SupplierDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Supplier Supplier) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_supplier(supplier_userid,supplier_yingyezhizhao,supplier_shuiwu,supplier_jigou,supplier_liutong,supplier_anquan,supplier_renzheng,supplier_jingyingaddr,supplier_shengchanaddr) VALUES (?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Supplier.getSupplier_userid());
		this.pstmt.setString(2, Supplier.getSupplier_yingyezhizhao());
		this.pstmt.setString(3, Supplier.getSupplier_shuiwu());
		this.pstmt.setString(4, Supplier.getSupplier_jigou());
		this.pstmt.setString(5, Supplier.getSupplier_liutong());
		this.pstmt.setString(6, Supplier.getSupplier_anquan());
		this.pstmt.setString(7, Supplier.getSupplier_renzheng());
		this.pstmt.setString(8, Supplier.getSupplier_jingyingaddr());
		this.pstmt.setString(9, Supplier.getSupplier_shengchanaddr());
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}

	@Override
	public boolean doDelete(int supplier_id) throws Exception {
		boolean flag = false;
		String sql = "delete from t_supplier where supplier_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, supplier_id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Supplier> findAll(String keyWord) throws Exception {
		List<Supplier> result = new ArrayList<Supplier>();
		String sql = "SELECT * FROM t_supplier WHERE supplier_userid  LIKE ?  OR supplier_jingyingaddr  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Supplier Supplier = null;
		while (rs.next()) {
			Supplier = new Supplier();
			Supplier.setSupplier_id(rs.getInt("supplier_id"));
			Supplier.setSupplier_userid(rs.getInt("supplier_userid"));
			Supplier.setSupplier_yingyezhizhao(rs.getString("supplier_yingyezhizhao"));
			Supplier.setSupplier_shuiwu(rs.getString("supplier_shuiwu"));
			Supplier.setSupplier_jigou(rs.getString("supplier_jigou"));
			Supplier.setSupplier_liutong(rs.getString("supplier_liutong"));
			Supplier.setSupplier_anquan(rs.getString("supplier_anquan"));
			Supplier.setSupplier_renzheng(rs.getString("supplier_renzheng"));
			Supplier.setSupplier_jingyingaddr(rs.getString("supplier_jingyingaddr"));
			Supplier.setSupplier_shengchanaddr(rs.getString("supplier_shengchanaddr"));
			result.add(Supplier);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Supplier findById(int supplier_id) throws Exception {
		Supplier Supplier = null;
		String sql = "SELECT * FROM t_supplier WHERE supplier_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, supplier_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Supplier = new Supplier();
			Supplier.setSupplier_id(rs.getInt("supplier_id"));
			Supplier.setSupplier_userid(rs.getInt("supplier_userid"));
			Supplier.setSupplier_yingyezhizhao(rs.getString("supplier_yingyezhizhao"));
			Supplier.setSupplier_shuiwu(rs.getString("supplier_shuiwu"));
			Supplier.setSupplier_jigou(rs.getString("supplier_jigou"));
			Supplier.setSupplier_liutong(rs.getString("supplier_liutong"));
			Supplier.setSupplier_anquan(rs.getString("supplier_anquan"));
			Supplier.setSupplier_renzheng(rs.getString("supplier_renzheng"));
			Supplier.setSupplier_jingyingaddr(rs.getString("supplier_jingyingaddr"));
			Supplier.setSupplier_shengchanaddr(rs.getString("supplier_shengchanaddr"));
			
		}
		this.pstmt.close();
		return Supplier;
	}

}

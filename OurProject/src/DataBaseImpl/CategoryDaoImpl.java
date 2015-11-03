package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.CategoryDao;
import DataBaseTable.Category;
import DataBaseTable.Role;

public class CategoryDaoImpl implements CategoryDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public CategoryDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Category category) throws Exception {

		boolean flag = false;
		String sql = "INSERT INTO t_category(category_number,category_name,category_fanumber,category_displayorder) VALUES (?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, category.getCategory_number());
		this.pstmt.setString(2, category.getCategory_name());
		this.pstmt.setInt(3, category.getCategory_fanumber());
		this.pstmt.setString(4, category.getCategory_displayorder());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}

	@Override
	public List<Category> findAll(String keyWord) throws Exception {
		List<Category> result = new ArrayList<Category>();
		String sql = "SELECT * FROM t_category WHERE  category_id LIKE ?  OR category_number LIKE ? OR category_name  LIKE ? OR category_fanumber  LIKE ? OR category_displayorder  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Category category = null;
		while (rs.next()) {
			category = new Category();
			category.setCategory_id(rs.getInt("category_id"));
			category.setCategory_number(rs.getInt("category_number"));
			category.setCategory_name(rs.getString("category_name"));
			category.setCategory_fanumber(rs.getInt("category_fanumber"));
			category.setCategory_displayorder(rs.getString("category_displayorder"));
			result.add(category);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public Category findById(int category_id) throws Exception {
		Category category = null;
		String sql = "SELECT * FROM t_category WHERE category_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, category_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			category = new Category();
			category.setCategory_id(rs.getInt("category_id"));
			category.setCategory_number(rs.getInt("category_number"));
			category.setCategory_name(rs.getString("category_name"));
			category.setCategory_fanumber(rs.getInt("category_fanumber"));
			category.setCategory_displayorder(rs.getString("category_displayorder"));
		}
		this.pstmt.close();
		return category;
	}

}

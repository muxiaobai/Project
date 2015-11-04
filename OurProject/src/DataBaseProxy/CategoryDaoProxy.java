package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.CategoryDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.CategoryDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Category;
import DataBaseTable.Role;

public class CategoryDaoProxy implements CategoryDao {
	private lianjie dbc = null;
	private CategoryDao dao = null;

	public CategoryDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new CategoryDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Category category) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(category.getCategory_id()) == null) {
				flag = this.dao.doCreate(category);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Category> findAll(String keyWord) throws Exception {
		List<Category> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public Category findById(int category_id) throws Exception {
		Category category = null;
		try {
			category = this.dao.findById(category_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return category;
	}

}

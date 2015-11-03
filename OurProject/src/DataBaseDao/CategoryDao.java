package DataBaseDao;
import java.util.List;

import DataBaseTable.Category;

public interface CategoryDao {
	public boolean doCreate(Category category) throws Exception;

	public List<Category> findAll(String keyWord) throws Exception;

	public Category findById(int category_id) throws Exception;
}

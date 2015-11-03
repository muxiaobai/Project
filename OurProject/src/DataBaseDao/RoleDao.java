package DataBaseDao;

import java.util.List;
import DataBaseTable.Role;
//Role操作接口
public interface RoleDao {
	public boolean doCreate(Role role) throws Exception;
	public boolean doDelete(int role_id) throws Exception;
	
	public List<Role> findAll(String keyWord) throws Exception;

	public Role findById(int role_id) throws Exception;
}

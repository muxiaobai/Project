package DataBaseDao;

import java.util.List;

import DataBaseTable.Goodsvideo;


public interface GoodsvideoDao {
	public boolean doCreate(Goodsvideo Goodsvideo) throws Exception;

	public List<Goodsvideo> findAll(String keyWord) throws Exception;

	public Goodsvideo findById(int goodsvideo_id) throws Exception;

}

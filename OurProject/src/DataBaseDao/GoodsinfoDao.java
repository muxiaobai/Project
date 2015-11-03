package DataBaseDao;

import java.util.List;

import DataBaseTable.Goodsinfo;
public interface GoodsinfoDao {
	
	public boolean doCreate(Goodsinfo Goodsinfo) throws Exception;

	public List<Goodsinfo> findAll(String keyWord) throws Exception;

	public Goodsinfo findById(int goodsinfo_id) throws Exception;
}

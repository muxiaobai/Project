package DataBaseDao;

import java.util.List;

import DataBaseTable.Goods;


public interface GoodsDao {
	public boolean doCreate(Goods goods) throws Exception;

	public List<Goods> findAll(String keyWord) throws Exception;

	public Goods findById(int goods_id) throws Exception;
}

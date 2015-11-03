package DataBaseDao;

import java.util.List;
import DataBaseTable.Goodsgrade;

public interface GoodsgradeDao {
	
		public boolean doCreate(Goodsgrade Goodsgrade) throws Exception;

		public List<Goodsgrade> findAll(String keyWord) throws Exception;

		public Goodsgrade findById(int goodsgrade_id) throws Exception;
	}
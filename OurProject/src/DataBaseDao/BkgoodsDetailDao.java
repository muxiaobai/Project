package DataBaseDao;

import java.util.List;

import DataBaseTable.BkgoodsDetail;

public interface BkgoodsDetailDao {
	public boolean doCreate(BkgoodsDetail bkgoodsdetail) throws Exception;

	public List<BkgoodsDetail> findAll(String keyWord) throws Exception;

	public BkgoodsDetail findById(int bkgoodsdetail_id) throws Exception;
}

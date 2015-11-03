package DataBaseDao;

import java.util.List;

import DataBaseTable.Bkgoods;


  public interface BkgoodsDao {
	public boolean doCreate(Bkgoods bkgoods) throws Exception;

	public List<Bkgoods> findAll(String keyWord) throws Exception;

	public Bkgoods findById(int bkgoods_id) throws Exception;
}

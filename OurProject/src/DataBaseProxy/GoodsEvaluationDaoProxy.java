package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.GoodsEvaluationDao;
import DataBaseImpl.GoodsEvaluationDaoImpl;
import DataBaseTable.GoodsEvaluation;
import DataBaseTable.Role;

public class GoodsEvaluationDaoProxy implements GoodsEvaluationDao {

	private lianjie dbc = null;
	private  GoodsEvaluationDao dao = null;
	public GoodsEvaluationDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new GoodsEvaluationDaoImpl(this.dbc.getConnection());
	}
	
	
	public boolean doCreate(GoodsEvaluation GoodsEvaluation) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById( GoodsEvaluation.getGoods_evaluation_id()) == null) {
				flag = this.dao.doCreate( GoodsEvaluation);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public List<GoodsEvaluation> findAll(String keyWord) throws Exception {
		List<GoodsEvaluation> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}
	public GoodsEvaluation findById(int goods_evaluation_id) throws Exception {
		GoodsEvaluation GoodsEvaluation = null;
		try {
			GoodsEvaluation = this.dao.findById(goods_evaluation_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return GoodsEvaluation;
	}
}

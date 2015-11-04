package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.StaEvaluationDao;
import DataBaseImpl.StaEvaluationDaoImpl;
import DataBaseTable.StaEvaluation;

public class StaEvaluationDaoProxy implements StaEvaluationDao {
	private lianjie dbc = null;
	private StaEvaluationDao dao = null;

	public StaEvaluationDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new StaEvaluationDaoImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(StaEvaluation StaEvaluation) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(StaEvaluation.getSta_evaluation_id()) == null) {
				flag = this.dao.doCreate(StaEvaluation);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int sta_evaluation_id) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(sta_evaluation_id) == null) {
				flag = this.dao.doDelete(sta_evaluation_id);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<StaEvaluation> findAll(String keyWord) throws Exception {
		List<StaEvaluation> all = null;
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
	public StaEvaluation findById(int sta_evaluation_id) throws Exception {
		StaEvaluation StaEvaluation = null;
		try {
			StaEvaluation = this.dao.findById(sta_evaluation_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return StaEvaluation;
	}

}

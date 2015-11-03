package DataBaseDao;

import java.util.List;

import DataBaseTable.StaEvaluation;

public interface StaEvaluationDao {
	public boolean doCreate(StaEvaluation StaEvaluation) throws Exception;

	public boolean doDelete(int sta_evaluation_id) throws Exception;

	public List<StaEvaluation> findAll(String keyWord) throws Exception;

	public StaEvaluation findById(int sta_evaluation_id) throws Exception;
}

package DataBaseDao;

import java.util.List;

import DataBaseTable.GoodsEvaluation;

	    public interface GoodsEvaluationDao {
		public boolean doCreate(GoodsEvaluation GoodsEvaluation) throws Exception;

		public List<GoodsEvaluation> findAll(String keyWord) throws Exception;

		public GoodsEvaluation findById(int goods_evaluation_id) throws Exception;
	}


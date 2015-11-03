package DataBaseDao;

import java.util.List;

import DataBaseTable.Point;





public interface PointDao {
	public boolean doCreate(Point point) throws Exception;

	public List<Point> findAll(String keyWord) throws Exception;

	public Point findById(int point_id) throws Exception;
}

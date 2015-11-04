package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.PointDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.PointDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Point;
import DataBaseTable.Role;

public class PointDaoProxy implements PointDao {
	private lianjie dbc = null;
	private PointDao dao = null;

	public PointDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new PointDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Point point) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(point.getPoint_id()) == null) {
				flag = this.dao.doCreate(point);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Point> findAll(String keyWord) throws Exception {
		List<Point> all = null;
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
	public Point findById(int point_id) throws Exception {
		Point point = null;
		try {
			point = this.dao.findById(point_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return point;
	}

}

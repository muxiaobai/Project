package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.StationDao;
import DataBaseImpl.StationDaoImpl;
import DataBaseTable.Station;

public class StationDaoProxy implements StationDao {
	private lianjie dbc = null;
	private StationDao dao = null;

	public StationDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new StationDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Station Station) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Station.getStation_id()) == null) {
				flag = this.dao.doCreate(Station);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int station_id) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(station_id) == null) {
				flag = this.dao.doDelete(station_id);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Station> findAll(String keyWord) throws Exception {
		List<Station> all = null;
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
	public Station findById(int station_id) throws Exception {
		Station Station = null;
		try {
			Station = this.dao.findById(station_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Station;
	}

}

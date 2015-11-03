package DataBaseDao;

import java.util.List;

import DataBaseTable.Station;

public interface StationDao {
	public boolean doCreate(Station Station) throws Exception;
	public boolean doDelete(int station_id) throws Exception;
	
	public List<Station> findAll(String keyWord) throws Exception;

	public Station findById(int station_id) throws Exception;
}

package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.StationDao;
import DataBaseTable.Station;

public class StationDaoImpl implements StationDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public StationDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Station Station) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_station(station_number,station_name,station_province,station_city,station_street,station_address,station_leaderid) VALUES (?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, Station.getStation_number());
		this.pstmt.setString(2, Station.getStation_name());
		this.pstmt.setString(3, Station.getStation_province());
		this.pstmt.setString(4, Station.getStation_city());
		this.pstmt.setString(5, Station.getStation_country());
		this.pstmt.setString(6, Station.getStation_street());
		this.pstmt.setString(7, Station.getStation_address());
		this.pstmt.setInt(8, Station.getStation_leaderid());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doDelete(int station_id) throws Exception {
			boolean flag = false;
			String sql = "delete from t_station where station_id=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, station_id);
			if (this.pstmt.executeUpdate() > 0) {
				flag = true;
			}
			this.pstmt.close();
			return flag;
	

	}

	@Override
	public List<Station> findAll(String keyWord) throws Exception {
		List<Station> result = new ArrayList<Station>();
		String sql = "SELECT * FROM t_station WHERE   station_name like ? OR station_province  LIKE ? OR station_city LIKE ? OR station_country  LIKE ? OR station_street  LIKE ? OR station_address  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Station Station = null;
		while (rs.next()) {
			Station = new Station();
			Station.setStation_id(rs.getInt("station_id"));
			Station.setStation_name(rs.getString("station_name"));
			Station.setStation_number(rs.getString("station_number"));
			Station.setStation_province(rs.getString("station_province"));
			Station.setStation_city(rs.getString("station_city"));
			Station.setStation_street(rs.getString("station_street"));
			Station.setStation_address(rs.getString("station_address"));
			Station.setStation_leaderid(rs.getInt("station_leaderid"));
			result.add(Station);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Station findById(int station_id) throws Exception {
		Station Station = null;
		String sql = "SELECT * FROM t_station WHERE station_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, station_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Station = new Station();
			Station.setStation_id(rs.getInt("station_id"));
			Station.setStation_name(rs.getString("station_name"));
			Station.setStation_number(rs.getString("station_number"));
			Station.setStation_province(rs.getString("station_province"));
			Station.setStation_city(rs.getString("station_city"));
			Station.setStation_street(rs.getString("station_street"));
			Station.setStation_address(rs.getString("station_address"));
			Station.setStation_leaderid(rs.getInt("station_leaderid"));
		}
		this.pstmt.close();
		return Station;
	}

}

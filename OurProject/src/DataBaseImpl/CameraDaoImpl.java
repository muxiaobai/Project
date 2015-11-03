package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.CameraDao;
import DataBaseTable.Camera;
import DataBaseTable.Role;

public class CameraDaoImpl implements CameraDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public CameraDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Camera camera) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_camera(camera_num,camera_supplierid) VALUES (?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, camera.getCamera_num());
		this.pstmt.setInt(2, camera.getCamera_supplierid());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Camera> findAll(String keyWord) throws Exception {
		List<Camera> result = new ArrayList<Camera>();
		String sql = "SELECT * FROM t_camera WHERE  camera_id LIKE ?  OR camera_num  LIKE ? OR camera_supplierid  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Camera camera = null;
		while (rs.next()) {
			camera = new Camera();
			camera.setCamera_id(rs.getInt("camera_id"));
			camera.setCamera_num(rs.getString("camera_num"));
			camera.setCamera_id(rs.getInt("camera_supplierid"));
			
			result.add(camera);
		}
		this.pstmt.close();
		return result;

	}

	@Override
	public Camera findById(int camera_id) throws Exception {
		Camera camera = null;
		String sql = "SELECT * FROM t_role WHERE role_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, camera_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			camera = new Camera();
			camera.setCamera_id(rs.getInt("camera_id"));
			camera.setCamera_num(rs.getString("camera_num"));
			camera.setCamera_id(rs.getInt("camera_supplierid"));
		}
		this.pstmt.close();
		return camera;
	}

}

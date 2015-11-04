package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.CameraDao;
import DataBaseDao.RoleDao;
import DataBaseImpl.CameraDaoImpl;
import DataBaseImpl.RoleDaoImpl;
import DataBaseTable.Camera;
import DataBaseTable.Role;

public class CameraDaoProxy implements CameraDao {
	private lianjie dbc = null;
	private CameraDao dao = null;

	public CameraDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new CameraDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Camera camera) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(camera.getCamera_id()) == null) {
				flag = this.dao.doCreate(camera);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Camera> findAll(String keyWord) throws Exception {
		List<Camera> all = null;
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
	public Camera findById(int camera_id) throws Exception {
		Camera camera = null;
		try {
			camera = this.dao.findById(camera_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return camera;
	}

}

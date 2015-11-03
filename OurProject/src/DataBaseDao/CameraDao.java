package DataBaseDao;

import java.util.List;

import DataBaseTable.Camera;

public interface CameraDao {
	public boolean doCreate(Camera camera) throws Exception;

	public List<Camera> findAll(String keyWord) throws Exception;

	public Camera findById(int camera_id) throws Exception;
}

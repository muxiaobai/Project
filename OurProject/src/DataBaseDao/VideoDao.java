package DataBaseDao;

import java.util.List;

import DataBaseTable.Video;

public interface VideoDao {
	public boolean doCreate(Video Video) throws Exception;

	public boolean doDelete(int video_id) throws Exception;

	public List<Video> findAll(String keyWord) throws Exception;

	public Video findById(int video_id) throws Exception;
}

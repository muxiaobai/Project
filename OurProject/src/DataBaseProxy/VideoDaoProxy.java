package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.VideoDao;
import DataBaseImpl.VideoDaoImpl;
import DataBaseTable.Video;

public class VideoDaoProxy implements VideoDao {
	private lianjie dbc = null;
	private VideoDao dao = null;

	public VideoDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new VideoDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Video Video) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(Video.getVideo_id()) == null) {
				flag = this.dao.doCreate(Video);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int video_id) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(video_id) == null) {
				flag = this.dao.doDelete(video_id);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Video> findAll(String keyWord) throws Exception {
		List<Video> all = null;
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
	public Video findById(int video_id) throws Exception {
		Video Video = null;
		try {
			Video = this.dao.findById(video_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return Video;
	}

}

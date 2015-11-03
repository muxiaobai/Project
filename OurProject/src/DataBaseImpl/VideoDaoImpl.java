package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.VideoDao;
import DataBaseTable.Video;

public class VideoDaoImpl implements VideoDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public VideoDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Video Video) throws Exception {

		boolean flag = false;
		String sql = "INSERT INTO t_video(video_supplierid,video_govnmtid,video_begintime,video_endtime,video_playtime,video_url) VALUES (?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, Video.getVideo_supplierid());
		this.pstmt.setInt(2, Video.getVideo_govnmtid());
		this.pstmt.setTimestamp(3, Video.getVideo_begintime());
		this.pstmt.setTimestamp(4, Video.getVideo_endtime());
		this.pstmt.setInt(5,Video.getVideo_playtime());
		this.pstmt.setString(6, Video.getVideo_url());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}

	@Override
	public boolean doDelete(int video_id) throws Exception {
		boolean flag = false;
		String sql = "delete from t_video where video_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, video_id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Video> findAll(String keyWord) throws Exception {
		List<Video> result = new ArrayList<Video>();
		String sql = "SELECT * FROM t_video WHERE  role_id LIKE ?  OR role_name  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Video Video = null;
		while (rs.next()) {
			Video = new Video();
			Video.setVideo_id(rs.getInt("video_id"));
			Video.setVideo_supplierid(rs.getInt("video_supplierid"));
			Video.setVideo_govnmtid(rs.getInt("video_govnmtid"));
			Video.setVideo_begintime(rs.getTimestamp("video_begintime"));
			Video.setVideo_endtime(rs.getTimestamp("video_endtime"));
			Video.setVideo_playtime(rs.getInt("video_playtime"));
			Video.setVideo_url(rs.getString("video_url"));
			result.add(Video);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Video findById(int video_id) throws Exception {
		Video Video = null;
		String sql = "SELECT * FROM t_video WHERE video_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, video_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Video = new Video();
			Video.setVideo_id(rs.getInt("video_id"));
			Video.setVideo_supplierid(rs.getInt("video_supplierid"));
			Video.setVideo_govnmtid(rs.getInt("video_govnmtid"));
			Video.setVideo_begintime(rs.getTimestamp("video_begintime"));
			Video.setVideo_endtime(rs.getTimestamp("video_endtime"));
			Video.setVideo_playtime(rs.getInt("video_playtime"));
			Video.setVideo_url(rs.getString("video_url"));
			
		}
		this.pstmt.close();
		return Video;
	}

}

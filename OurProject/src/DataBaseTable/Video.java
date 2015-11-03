package DataBaseTable;

import java.sql.Timestamp;

public class Video {
	private int video_id;
	private int video_supplierid;
	private int video_govnmtid;
	private Timestamp video_begintime;
	private Timestamp video_endtime;
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public int getVideo_supplierid() {
		return video_supplierid;
	}
	public void setVideo_supplierid(int video_supplierid) {
		this.video_supplierid = video_supplierid;
	}
	public int getVideo_govnmtid() {
		return video_govnmtid;
	}
	public void setVideo_govnmtid(int video_govnmtid) {
		this.video_govnmtid = video_govnmtid;
	}
	public Timestamp getVideo_begintime() {
		return video_begintime;
	}
	public void setVideo_begintime(Timestamp video_begintime) {
		this.video_begintime = video_begintime;
	}
	public Timestamp getVideo_endtime() {
		return video_endtime;
	}
	public void setVideo_endtime(Timestamp video_endtime) {
		this.video_endtime = video_endtime;
	}
	public int getVideo_playtime() {
		return video_playtime;
	}
	public void setVideo_playtime(int video_playtime) {
		this.video_playtime = video_playtime;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	private int video_playtime;
	private  String video_url;
	
}

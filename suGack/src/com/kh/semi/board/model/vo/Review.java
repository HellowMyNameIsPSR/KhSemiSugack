package com.kh.semi.board.model.vo;

import java.sql.Date;

public class Review implements java.io.Serializable{
	
	private int cid;
	private Date writeDate;
	private String content;
	private int bno;
	private int writerId;
	private int writeLevel;
	private String starPoint;
	private String writer;
	
	public Review() {}
	
	public Review(int cid, Date writeDate, String content, int bno, int writerId, int writeLevel,  String starPoint,
			String writer) {
		super();
		this.cid = cid;
		this.writeDate = writeDate;
		this.content = content;
		this.bno = bno;
		this.writerId = writerId;
		this.writeLevel = writeLevel;
		this.starPoint = starPoint;
		this.writer = writer;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	public int getWriteLevel() {
		return writeLevel;
	}
	public void setWriteLevel(int writeLevel) {
		this.writeLevel = writeLevel;
	}
	public  String getStarPoint() {
		return starPoint;
	}
	public void setStarPoint(String starPoint) {
		this.starPoint = starPoint;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "Review [cid=" + cid + ", writeDate=" + writeDate + ", content=" + content + ", bno=" + bno
				+ ", writerId=" + writerId + ", writeLevel=" + writeLevel + ", starPoint=" + starPoint + ", writer="
				+ writer + "]";
	}
	
	
	

}

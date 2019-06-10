package com.yc.novelclient.bean;

import java.util.Date;

/**
 * 最新章节
 * sm
 */
public class NearChapter {

	private long id;
	
	private long nid;
	
	private String novelName;
	
	private String author;
	
	private String type;
	
	private String nearChapter;
	
	private Date updateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNid() {
		return nid;
	}

	public void setNid(long nid) {
		this.nid = nid;
	}

	public String getNovelName() {
		return novelName;
	}

	public void setNovelName(String novelName) {
		this.novelName = novelName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNearChapter() {
		return nearChapter;
	}

	public void setNearChapter(String nearChapter) {
		this.nearChapter = nearChapter;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "NearChapter [id=" + id + ", nid=" + nid + ", novelName=" + novelName + ", author=" + author + ", type="
				+ type + ", nearChapter=" + nearChapter + ", updateTime=" + updateTime + "]";
	}
	
	
}

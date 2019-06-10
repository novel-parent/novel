package com.yc.novelclient.bean;

/**
 * 
 * @author sm
 */
public class Chapter {
	
	private long cid;

	private String novelChapter;

	@Override
	public String toString() {
		return "Chapter{" +
				"cid=" + cid +
				", novelChapter='" + novelChapter + '\'' +
				'}';
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getNovelChapter() {
		return novelChapter;
	}

	public void setNovelChapter(String novelChapter) {
		this.novelChapter = novelChapter;
	}
}

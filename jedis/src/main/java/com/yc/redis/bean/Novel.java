package com.yc.redis.bean;

import java.io.Serializable;

public class Novel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer nid;
    private String novelName;
    private String url;
    private String author;

    public Integer getNid() {
        return nid;
    }

    public String getNovelName() {
        return novelName;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthor() {
        return author;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "nid=" + nid +
                ", novelName='" + novelName + '\'' +
                ", url='" + url + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

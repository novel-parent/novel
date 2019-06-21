package com.yc.redis.bean;


import java.io.Serializable;

/**
 * @author LX
 * @date 2019/6/21 - 20:22
 */
public class CollectDiv implements Serializable {

    private long nid ;

    private String novelName;

    private String author;

    private int number ;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

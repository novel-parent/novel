package com.yc.bean;

/**
 * @author LX
 * @date 2019/5/12 - 11:49
 */
public class TableNovel {

    private long nid ;
    private String novelName;
    private String author;
    private int readCount;

    @Override
    public String toString() {
        return "TableNovel{" +
                "nid=" + nid +
                ", novelName='" + novelName + '\'' +
                ", author='" + author + '\'' +
                ", readCount=" + readCount +
                '}';
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

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }
}

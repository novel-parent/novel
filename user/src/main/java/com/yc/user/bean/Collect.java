package com.yc.user.bean;

/**
 * @author LX
 * @date 2019/5/29 - 21:29
 */
public class Collect {

    private long coid;

    private long uid;

    private long nid;

    private long cid;

    private String cTimes;

    private String chapterName;

    public long getCoid() {
        return coid;
    }

    public void setCoid(long coid) {
        this.coid = coid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getNid() {
        return nid;
    }

    public void setNid(long nid) {
        this.nid = nid;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getcTimes() {
        return cTimes;
    }

    public void setcTimes(String cTimes) {
        this.cTimes = cTimes;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "coid=" + coid +
                ", uid=" + uid +
                ", nid=" + nid +
                ", cid=" + cid +
                ", cTimes='" + cTimes + '\'' +
                ", chapterName='" + chapterName + '\'' +
                '}';
    }
}

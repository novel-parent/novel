package com.yc.user.bean;

/**
 * @author LX
 * @date 2019/5/26 - 21:48
 */
public class SearchHistoryNovel {

    private long nid;

    private String novelName;

    public long getNid() {
        return nid;
    }

    @Override
    public String toString() {
        return "SearchHistoryNovel{" +
                "nid=" + nid +
                ", novelName='" + novelName + '\'' +
                '}';
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
}

package com.yc.novelclient.bean;

/**
 * @author LX
 * @date 2019/5/14 - 1:02
 */
public class ReadNovel {

    private String context;

    private String lastChapter;

    private String nextChapter;

    private String novelChapterName;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public String getNextChapter() {
        return nextChapter;
    }

    public void setNextChapter(String nextChapter) {
        this.nextChapter = nextChapter;
    }

    public String getNovelChapterName() {
        return novelChapterName;
    }

    public void setNovelChapterName(String novelChapterName) {
        this.novelChapterName = novelChapterName;
    }
}

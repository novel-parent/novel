package com.yc.bean;


import java.io.Serializable;

/**
 * @author LX
 * @date 2019/6/20 - 0:41
 */
public class IntroductionDiv implements Serializable {

    private IntroductionNovel introductionNovel;

    private String novelChapters;

    public IntroductionNovel getIntroductionNovel() {
        return introductionNovel;
    }

    public void setIntroductionNovel(IntroductionNovel introductionNovel) {
        this.introductionNovel = introductionNovel;
    }

    public String getNovelChapters() {
        return novelChapters;
    }

    public void setNovelChapters(String novelChapters) {
        this.novelChapters = novelChapters;
    }
}

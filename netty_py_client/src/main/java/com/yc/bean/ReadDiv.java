package com.yc.bean;

import java.io.Serializable;

/**
 * @author LX
 * @date 2019/6/20 - 0:41
 */
public class ReadDiv implements Serializable {
    private IntroductionNovel introductionNovel;

    public ReadNovel getReadNovel() {
        return readNovel;
    }

    public void setReadNovel(ReadNovel readNovel) {
        this.readNovel = readNovel;
    }

    private ReadNovel readNovel;

    public IntroductionNovel getIntroductionNovel() {
        return introductionNovel;
    }

    public void setIntroductionNovel(IntroductionNovel introductionNovel) {
        this.introductionNovel = introductionNovel;
    }
}

package util;

import com.yc.bean.ReadNovel;

/**
 * @author LX
 * @date 2019/6/19 - 21:29
 */
public class NovelChapterThread implements Runnable {

    private ReadNovel readNovel;

    public ReadNovel getReadNovel() {
        return readNovel;
    }

    public void setReadNovel(ReadNovel readNovel) {
        this.readNovel = readNovel;
    }

    @Override
    public void run() {

    }
}

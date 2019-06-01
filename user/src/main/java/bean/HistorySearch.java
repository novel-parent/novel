package bean;

/**
 * @author LX
 * @date 2019/5/27 - 21:01
 */
public class HistorySearch {

    private long sid;

    private long uid;

    private String historySearchName;

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getHistorySearchName() {
        return historySearchName;
    }

    public void setHistorySearchName(String historySearchName) {
        this.historySearchName = historySearchName;
    }

    @Override
    public String toString() {
        return "HistorySearch{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", historySearchName='" + historySearchName + '\'' +
                '}';
    }
}

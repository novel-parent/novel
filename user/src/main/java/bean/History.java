package bean;

/**
 * @author LX
 * @date 2019/5/27 - 20:33
 */
public class History {

    private SearchHistoryNovel searchHistoryNovel;

    public SearchHistoryNovel getSearchHistoryNovel() {
        return searchHistoryNovel;
    }

    public void setSearchHistoryNovel(SearchHistoryNovel searchHistoryNovel) {
        this.searchHistoryNovel = searchHistoryNovel;
    }

    @Override
    public String toString() {
        return "History{" +
                "searchHistoryNovel=" + searchHistoryNovel +
                '}';
    }
}

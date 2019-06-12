package mapper;

import java.util.List;

import bean.IndexNovel;


/**
 * luoshixin
 * @author LX
 * @date 2019/5/12 - 14:18
 */
public interface IndexNovelMapper {
	void insert(IndexNovel indexnovel);
	boolean update(IndexNovel indexnovel);
	List<IndexNovel> findAll();
	IndexNovel findById(int id);
	boolean delete(int id);
}

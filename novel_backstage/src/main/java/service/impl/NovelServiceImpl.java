package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import bean.Novel;
import mapper.NovelMapper;
import service.NovelService;

/**
 * @author LX
 * @date 2019/5/12 - 14:18
 */
@Service  
@Transactional  
// 此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class NovelServiceImpl implements NovelService {

	
	@Resource  
	private NovelMapper nmapper;
	 
	/**
	 * 查询全部数据
	 */
	public List<Novel> findAll() {
		List<Novel> findAllList = nmapper.findAll(); 
		return findAllList;
	}
	/**
	 * 搜索模糊查询
	 */
	public List<Novel> findByName(String novelName) {
		return nmapper.findByName(novelName);
	}

	public void insert(Novel novel) {
		nmapper.insert(novel);
		
	}

	public boolean update(Novel novel) {
		
		return nmapper.update(novel);
	}

	public Novel findById(int id) {
		Novel novel = nmapper.findById(id);
		return novel;
	}

	public boolean delete(int id) {
		
		return nmapper.delete(id);
	}

	

	


	
	
}

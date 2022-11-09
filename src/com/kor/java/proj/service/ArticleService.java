package com.kor.java.proj.service;

import com.kor.java.proj.container.Container;
import com.kor.java.proj.dao.ArticleDao;
import com.kor.java.proj.dto.Article;

public class ArticleService {
	private ArticleDao articleDao;
	public ArticleService(){
		this.articleDao = Container.articleDao;
	}
	public int getNewId() {
		return articleDao.getNewId();
	}
	public void add(Article 저장) {
		articleDao.add(저장);
	}
	public int size() {
		return articleDao.size();
	}
	public Object get(int i) {
		return articleDao.get(i);
	}
	public int foundIndex(int remove) {
		return articleDao.foundIndex(remove);
	}
	public void remove(int fi) {
		articleDao.remove(fi);
	}
}

package com.kor.java.proj.dao;

import java.util.ArrayList;
import java.util.List;

import com.kor.java.proj.dto.Article;

public class ArticleDao extends Dao {
	public List<Article> articles;
	
	public ArticleDao(){
		articles = new ArrayList<>();
	}

	public void add(Article 저장) {
		articles.add(저장);
		lastArticleId = 저장.num;
	}

	public int size() {
		return articles.size();
	}
	public int foundIndex(int a) {
		int fi = -1;
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).num == a) {
				fi = i;
				return fi;
			}
		}
		return fi;
	}

	public Object get(int i) {
		return articles.get(i);
	}

	public void remove(int fi) {
		articles.remove(fi);
	}

	public List<Article> getList() {
		return articles;
	}
}

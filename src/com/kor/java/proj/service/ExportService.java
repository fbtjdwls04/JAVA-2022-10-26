package com.kor.java.proj.service;

import java.util.List;

import com.kor.java.proj.container.Container;
import com.kor.java.proj.dto.Article;
import com.kor.java.proj.util.Util;

public class ExportService {
	public ArticleService articleService;
	public MemberService memberService;
	
	public ExportService(){
		articleService = Container.articleService;
		memberService =	Container.memberService;
	}

	public void makeHtml() {
		List<Article> articles = articleService.getList();
		for(Article article : articles) {
			String writerName = article.userId;
			
			String fileName = article.num + ".html";
			String html = "<meta charset=\"UTF-8\">";
			html += "<div>번호 : " + article.num + "</div>";
			html += "<div>날짜 : " + article.date + "</div>";
			html += "<div>작성자 : " + writerName + "</div>";
			html += "<div>제목 : " + article.title + "</div>";
			html += "<div>내용 : " + article.text + "</div>";
			if ( article.num > 1) {
				html += "<div><a href=\"" + (article.num - 1) + ".html" +"\">이전글</a></div>";
			}
			if ( article.num < articles.size())
			html += "<div><a href=\"" + (article.num + 1) + ".html" +"\">다음글</a></div>";
			
			Util.writeFileContents("exportHtml/" + fileName, html);
		}
	}
}

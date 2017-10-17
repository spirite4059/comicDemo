package com.comic.web.service;

import com.comic.web.base.service.BaseService;
import com.comic.web.bean.Article;


public interface ArticleService extends BaseService<Article>
{
	//保存某个实体类
	public int insertAndGetId(Article article) throws Exception;
}

package com.comic.web.dao;

import com.comic.web.base.dao.BaseDao;
import com.comic.web.bean.Article;


public interface ArticleDao extends BaseDao<Article>
{
	//保存某个实体类
	public int insertAndGetId(Article article) throws Exception;
	
}
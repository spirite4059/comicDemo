package com.comic.web.service.Impl;

import com.comic.web.base.dao.BaseDao;
import com.comic.web.base.serviceImpl.BaseServiceImpl;
import com.comic.web.bean.Article;
import com.comic.web.dao.ArticleDao;
import com.comic.web.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImp extends BaseServiceImpl<Article> implements ArticleService
{
	@Autowired
	private ArticleDao articleDao;
	
	@Override  		//上面是baseDao里面，抽象类，必须实现其他的直接继承了
	protected BaseDao<Article> getDao()
	{
		return articleDao;
	}
	
	//保存某个实体类;
	public int insertAndGetId(Article article) throws Exception
	{
		return articleDao.insertAndGetId(article);
	}
}

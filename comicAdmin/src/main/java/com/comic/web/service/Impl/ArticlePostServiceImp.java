package com.comic.web.service.Impl;

import com.comic.web.base.dao.BaseDao;
import com.comic.web.base.serviceImpl.BaseServiceImpl;
import com.comic.web.bean.ArticlePost;
import com.comic.web.dao.ArticlePostDao;
import com.comic.web.service.ArticlePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticlePostServiceImp extends BaseServiceImpl<ArticlePost> implements ArticlePostService
{
	@Autowired
	private ArticlePostDao articlePostDao;
	
	@Override  //上面是baseDao里面，抽象类，必须实现其他的直接继承了
	protected BaseDao<ArticlePost> getDao()
	{
		return articlePostDao;
	}
}

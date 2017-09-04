package com.comic.web.dao;

import com.comic.web.base.dao.BaseDao;
import com.comic.web.bean.ArticleBlock;

import java.util.List;



//操作文章块的控制器
public interface ArticleBlockDao extends BaseDao<ArticleBlock>
{
	//保存某个文章的一个块
	public int insertAndGetId(ArticleBlock articleBlock) throws Exception;
	
	//根据输入的block list选择出数据
	public List<ArticleBlock> selectBlockByList(List blockList) throws Exception; 
	
}
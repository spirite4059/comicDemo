package com.comic.web.controller;

import com.comic.web.base.controller.BaseController;
import com.comic.web.bean.ArticleBlock;
import com.comic.web.bean.ArticleBlockM;
import com.comic.web.bean.PageInfoM;
import com.comic.web.service.ArticleBlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/ArticleBlock")
public class ArticleBlockController extends BaseController
{
	protected Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArticleBlockService articleBlockService;
	
	
    @RequestMapping("/ArticleBlock")    
    public String article(ModelMap modelMap,@RequestParam(required=false) Integer articleId)
    {
    	logger.info("请求 articleBlock:"+articleId);
    	modelMap.addAttribute("articleId",articleId);
        return "/web/article_block";
    }   
	
	//**********增删该查
	@RequestMapping("/queryList")
	@ResponseBody	//page代表当前是第几页，rows代表每个页面显示多少数据
	public PageInfoM<ArticleBlock> selectBlock(Integer page,Integer rows,Integer articleId)
	{
		//获得固定的数据
		logger.info(page+":"+rows);	//给些初始的数值		
		
		PageInfoM<ArticleBlock> articleBlocks= null;
		
		try
		{
			articleBlocks = articleBlockService.selectBlock(page, rows, articleId);  
		}
		catch(Exception e)
		{
			logger.info(e.toString());
		}
		
		return articleBlocks;  //返回的是对象列表 
	}
	
	
	@RequestMapping (value="/insert",method=RequestMethod.POST)
	@ResponseBody		//
	public Map<String,Object> insert(@RequestBody ArticleBlockM p)
	{
		Map<String,Object>result=this.success(null);

		logger.info(p.toString()+":"+p.getArticleBlock().getArticleId());
		
		try
		{
			articleBlockService.insertBlock(p.getIndex(),p.getArticleBlock());
		}catch(Exception e)
		{
			result=this.error(e.getMessage());//把错误信息输出去
		}
		return result; 
	}
	

	@RequestMapping("/update")	//根据情况更新文章块
	@ResponseBody
	public Map<String,Object> update(@RequestBody ArticleBlock articleBlock)
	{
		//logger.info(article.toString());
		Map<String,Object> result = this.success(null);
		try{
			articleBlockService.update(articleBlock);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/delete")	//根据情况更新
	@ResponseBody
	public Map<String,Object> delete(Integer blockId,Integer articleId)
	{
		Map<String,Object> result = this.success(null);
		try{
			articleBlockService.deleteBlock(blockId,articleId);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
}













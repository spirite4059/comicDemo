package com.comic.web.service;

import com.comic.web.base.service.BaseService;
import com.comic.web.bean.Resource;

import java.util.Collection;
import java.util.List;

public interface ResourceService extends BaseService<Resource>
{

	/* 递归查询	 @param parentId @return  @throws Exception */
	public List<Resource> getTreeList(int parentId, List<Resource> treeList) throws Exception;
	
	/**
	 * 根据登录人的id查询所拥有的资源信息 
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<Resource> getUserResourceList(int userId)throws Exception;
	
	
	/**
	 * 根据登录人的id查询所拥有的资源信息 || 左侧的资源列表
	 * @param roleId 	@return		@throws Exception
	 */
	public Collection<Resource> getUserMenuResourceList(int userId)throws Exception;
	
}

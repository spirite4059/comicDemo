package com.comic.web.service.Impl;

import com.comic.web.base.dao.BaseDao;
import com.comic.web.base.serviceImpl.BaseServiceImpl;
import com.comic.web.bean.Resource;
import com.comic.web.dao.ResourceDao;
import com.comic.web.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.Map.Entry;



@Service
public class ResourceServiceImp  extends BaseServiceImpl<Resource> implements ResourceService
{
	@Autowired
	private ResourceDao resourceDao;	//文章块的数据操作类

	@Override
	protected BaseDao<Resource> getDao()
	{
		return resourceDao;
	}
	
	
	/****
	 * 递归查询   ---  list[resource]
	 *                         child[resource]
	 *                                child---resource
	 *                         child --resource
	 *                                child---resource
	 ****/
	public List<Resource> getTreeList(int parentId,List<Resource> treeList) throws Exception
	{
		List<Resource> resourceList = resourceDao.getTreeList(parentId);  	//默认是-1
		for (Resource resource : resourceList) {
			List<Resource> subList = resourceDao.getTreeList(resource.getId());
			if(subList.size()>=0){
				resource.setChildren(getTreeList(resource.getId(),new ArrayList<Resource>()));
			}
			treeList.add(resource);
		}
		return treeList;
	}
	
	
	/**
	 * 根据登录人的id查询所拥有的资源信息 
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<Resource> getUserResourceList(int userId)throws Exception
	{
		return resourceDao.getUserResourceList(userId);
	}
	
	
	/**		根据登录人的id查询所拥有的左侧菜单;查出来的是当前用户所有的roleId	*/
	public Collection<Resource> getUserMenuResourceList(int userId)throws Exception
	{
		
		LinkedHashMap<Integer,Resource> treeMap = new LinkedHashMap<Integer,Resource>();
		LinkedHashMap<Integer,Resource> modelMap = new LinkedHashMap<Integer,Resource>();
				
		
		//左侧菜单的权限
		List<Resource> resourceList = resourceDao.getUserMenuResourceList(userId);
		
		for (Resource resource : resourceList) 
		{
			if(resource.getParentId()==-1)
			{	
				//如果是-1，表示是最上层
				treeMap.put(resource.getId(), resource);
			}else
			{
				//儿子菜单放在一起
				modelMap.put(resource.getId(), resource);
			}
		}
		
		//遍历儿子菜单，把有父节点的放到相应的父节点下面
		Iterator<Entry<Integer, Resource>> iterator = modelMap.entrySet().iterator();
		while(iterator.hasNext())
		{
			Entry<Integer, Resource> next = iterator.next();
			Resource resource = next.getValue();
			int parentId = resource.getParentId();
			
			//从treeMap里面找出来父亲节点
			Resource pResource = treeMap.get(parentId);
			
			//没找到父节点，掠过  ??如果菜单编号有问题，会出现无法显示的问题
			if(null != pResource)
			{
				if(null == pResource.getChildren())
				{
					pResource.setChildren(new ArrayList<Resource>()); 
				}
				pResource.getChildren().add(resource);	//把当前的节点放到父亲节点下面
			}
		}
		
		//输出结构
		Collection<Resource> values = treeMap.values();
		return values;
	}
}

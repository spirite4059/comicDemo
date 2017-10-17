package com.comic.web.service;

import com.comic.web.base.service.BaseService;
import com.comic.web.bean.Role;
import com.comic.web.bean.RoleResource;
import com.comic.web.bean.User;

import java.util.List;



public interface RoleService extends BaseService<Role>
{

	//根据角色id查询角色所拥有的资源
	public List<RoleResource> getSelectedResourceByRoleId(int roleId)throws Exception;
	
	//根据角色id查询角色所拥有的用户
	public List<User> getSelectedUserByRoleId(int roleId)throws Exception;
	
	//保存分配的资源
	public void insertRoleResource(String resourceIds, int roleId)throws Exception;
	
	//保存分配的用户
    public void insertRoleUser(String userIds, int roleId)throws Exception;

}




package com.comic.web.dao;

import com.comic.web.base.dao.BaseDao;
import com.comic.web.bean.RoleUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;



// @描述     角色用户数据库交互层
public interface RoleUserDao  extends BaseDao<RoleUser>
{   
	//根据roleId查询 角色资源表   
	public List<RoleUser> getListByRoleId(@Param("roleId") int roleId);
}





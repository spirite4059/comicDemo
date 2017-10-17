package com.comic.web.dao;

import com.comic.web.base.dao.BaseDao;
import com.comic.web.bean.RoleResource;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface RoleResourceDao  extends BaseDao<RoleResource>
{
    // 根据roleId查询 角色资源表
	public List<RoleResource> getListByRoleId(@Param("roleId") int roleId);

}

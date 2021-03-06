package com.comic.web.base.serviceImpl;

import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.comic.web.base.dao.BaseDao;
import com.comic.web.base.service.BaseService;
import com.comic.web.base.util.BaseServlet;


public abstract class BaseServiceImpl<T> extends BaseServlet implements BaseService<T>
{

	//抽象方法，返回具体的Dao，有了具体类型
	protected abstract BaseDao<T> getDao();
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//根据id，返回对象
	public T getEntityById(int id)throws Exception
	{
		return getDao().getEntityById(id);
	}
	
	//查询list
	public List<T> getList() throws Exception
	{
		return getDao().getList();
	}
	
	
	//根据某个实体返回实体列表？？具体要用到实体的哪个参数
	public List<T> getListByEntity(T entity) throws Exception
	{
		return getDao().getListByEntity(entity);
	}
	
	
	//根据sql和输入的参数来获取总的条数？？基本没什么用处，特别是mybatis之后
	//??参数居然用的object，神奇
	public int getCount(String sql,List<Object> params)
	{
		return getDao().getCount(sql, params);
	}

	
	//保存某个实体类
	public void insert(T entity)throws Exception
	{
		getDao().insert(entity);
	}
	
	//保存一个集合 ？？居然没有返回数值
	public void insertAll(Collection<T> entities)throws Exception
	{
		getDao().insertAll(entities);
	}
	
	//更新一个对象
	public void update(T entity) throws Exception
	{
		getDao().update(entity);
	}
	
	//更新一组对象
	public void updataAll(Collection<T> entities)throws Exception
	{
		getDao().updataAll(entities);
	}
	
	//根据一个对象删除
	public void deleteByEntity(T entity)throws Exception
	{
		getDao().deleteByEntity(entity);
	}
	
	
	//根据id删除要给对象
	public void deleteById(int id)throws Exception
	{
		getDao().deleteById(id);
	}
	
}

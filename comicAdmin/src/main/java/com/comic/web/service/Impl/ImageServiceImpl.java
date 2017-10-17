package com.comic.web.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.web.bean.UpImage;
import com.comic.web.dao.UpImageMapper;
import com.comic.web.service.ImageService;

@Service("ImageService") 
public class ImageServiceImpl implements ImageService 
{
	@Autowired
	private UpImageMapper upImageDao;
	
	//保存图片信息到数据库
	public void insert_img(UpImage img) throws Exception
	{
		upImageDao.insert(img);
	}

}

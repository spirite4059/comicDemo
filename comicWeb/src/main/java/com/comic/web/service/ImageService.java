package com.comic.web.service;

import com.comic.web.bean.UpImage;

public interface ImageService {
	
	//保存图片信息到数据库
	public void insert_img(UpImage img) throws Exception;
	
}

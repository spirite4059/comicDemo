package com.comic.web.service.Impl;

import com.comic.web.base.dao.BaseDao;
import com.comic.web.base.serviceImpl.BaseServiceImpl;
import com.comic.web.bean.PublicCai;
import com.comic.web.dao.PublicCaiDao;
import com.comic.web.service.WebPublicCaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WebPublicCaiServiceImp extends BaseServiceImpl<PublicCai> implements WebPublicCaiService
{
	@Autowired
	private PublicCaiDao dao;

	@Override
	protected BaseDao<PublicCai> getDao() {
		return dao;
	}
}






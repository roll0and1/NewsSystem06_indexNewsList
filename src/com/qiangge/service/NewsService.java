package com.qiangge.service;

import com.qiangge.dao.NewsDao;
import com.qiangge.dao.impl.NewsDaoImpl;
import com.qiangge.model.News;
import com.qiangge.utils.AppException;

/**
 * 消息业务处理类
 * 
 * @author zha_zha
 * 
 */
public class NewsService {
	private NewsDao newsDao = new NewsDaoImpl();

	public boolean create(News news) throws AppException {
		boolean flag = false;
		flag = newsDao.add(news);
		return flag;
	}
}

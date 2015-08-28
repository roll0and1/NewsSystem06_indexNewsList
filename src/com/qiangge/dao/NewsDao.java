package com.qiangge.dao;

import com.qiangge.model.News;
import com.qiangge.utils.AppException;

public interface NewsDao {
	boolean add(News news)throws AppException;
}

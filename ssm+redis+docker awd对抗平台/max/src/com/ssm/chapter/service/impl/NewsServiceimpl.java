package com.ssm.chapter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.chapter.pojo.OneNew;
import com.ssm.chapter.service.NewsService;
import com.ssm.chapter.dao.NewsDao;

@Service
public class NewsServiceimpl implements NewsService {

	@Autowired
	private NewsDao NewsDao = null;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<OneNew> getNewsList(int UserId) {

		return NewsDao.getNews(UserId);

	}

	@Override
	public boolean insertNews(OneNew onenew) {
		// TODO Auto-generated method stub
		return NewsDao.insertNews(onenew);
	}

	@Override
	public boolean deleteNews(int id) {
		// TODO Auto-generated method stub
		return NewsDao.deleteNews(id);
	}

}

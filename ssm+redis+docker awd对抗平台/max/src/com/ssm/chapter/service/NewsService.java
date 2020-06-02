package com.ssm.chapter.service;

import java.util.List;

import com.ssm.chapter.pojo.OneNew;

public interface NewsService {
	public List<OneNew> getNewsList(int UserId);

	public boolean deleteNews(int id);

	public boolean insertNews(OneNew onenew);
}

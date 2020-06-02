package com.ssm.chapter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.OneNew;

@Repository
public interface NewsDao {
	public List<OneNew> getNews(int UserId);

	public boolean insertNews(OneNew onenew);

	public boolean deleteNews(int id);
}

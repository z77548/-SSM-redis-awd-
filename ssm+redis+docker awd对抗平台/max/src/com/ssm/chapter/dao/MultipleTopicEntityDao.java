package com.ssm.chapter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.MultipleTopicEntity;

@Repository
public interface MultipleTopicEntityDao {

	public MultipleTopicEntity getOneTopic(@Param("EventId") int EventId, @Param("Start") int Start,
			@Param("End") int End);

	public List<MultipleTopicEntity> gets();

	public boolean delete(int id);

	public boolean insert(MultipleTopicEntity multipleTopicEntity);
}

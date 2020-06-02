package com.ssm.chapter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.FileTopicEntity;

@Repository
public interface FileTopicEntityDao {

	public FileTopicEntity getOneTopic(@Param("EventId") int EventId, @Param("Start") int Start, @Param("End") int End);

	public List<FileTopicEntity> gets();

	public boolean delete(int id);

	public boolean insert(FileTopicEntity fileTopicEntity);
}

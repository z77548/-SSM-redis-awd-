package com.ssm.chapter.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.TrueAnswer;

@Repository
public interface TopicDao {
	// ��ȡѡ������Ŀ
	public int getChooseCount(int EventId);

	// ��ѡ��Ŀ��Ŀ
	public int getMultipleCount(int EventId);

	// ������Ŀ��Ŀ
	public int getFileCount(int EventId);

	// ��ȡ��Ŀ��
	public TrueAnswer getAnswer(@Param("Id") int Id, @Param("Type") int Type);

}

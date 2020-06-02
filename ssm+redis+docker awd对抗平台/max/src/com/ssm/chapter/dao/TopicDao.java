package com.ssm.chapter.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.TrueAnswer;

@Repository
public interface TopicDao {
	// 获取选择题数目
	public int getChooseCount(int EventId);

	// 多选题目数目
	public int getMultipleCount(int EventId);

	// 附件题目数目
	public int getFileCount(int EventId);

	// 获取题目答案
	public TrueAnswer getAnswer(@Param("Id") int Id, @Param("Type") int Type);

}

package com.ssm.chapter.service;

import java.util.List;

import com.ssm.chapter.pojo.ChooseTopicEntity;
import com.ssm.chapter.pojo.FileTopicEntity;
import com.ssm.chapter.pojo.MultipleTopicEntity;
import com.ssm.chapter.pojo.TrueAnswer;

public interface TopicService {
	public int[] getTopicCount(int EventId);

	public ChooseTopicEntity getChooseTopic(int EventId, int Count);

	public MultipleTopicEntity getMultipleTopic(int EventId, int Count);

	public FileTopicEntity getFileTopic(int EventId, int Count);

	public TrueAnswer getAnswer(int Id, int Type);

	public List<FileTopicEntity> getFileTopicList();

	public List<ChooseTopicEntity> getChooseTopicList();

	public List<MultipleTopicEntity> getMultipleTopicList();

	public String deletetopic(int id, String type);

	public boolean newmultchoosetopic(MultipleTopicEntity topic);

	public boolean newchoosetopic(ChooseTopicEntity topic);

	public boolean newfiletopic(FileTopicEntity topic);
}

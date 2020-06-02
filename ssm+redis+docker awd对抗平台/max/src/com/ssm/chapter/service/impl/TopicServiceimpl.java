package com.ssm.chapter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.chapter.pojo.ChooseTopicEntity;
import com.ssm.chapter.pojo.FileTopicEntity;
import com.ssm.chapter.pojo.MultipleTopicEntity;
import com.ssm.chapter.pojo.TrueAnswer;
import com.ssm.chapter.service.TopicService;
import com.ssm.chapter.dao.ChooseTopicEntityDao;
import com.ssm.chapter.dao.FileTopicEntityDao;
import com.ssm.chapter.dao.MultipleTopicEntityDao;
import com.ssm.chapter.dao.TopicDao;

@Service
public class TopicServiceimpl implements TopicService {

	@Autowired
	private TopicDao topicDao = null;

	@Autowired
	private ChooseTopicEntityDao chooseTopicEntityDao = null;
	@Autowired
	private MultipleTopicEntityDao multipleTopicEntityDao = null;

	@Autowired
	private FileTopicEntityDao fileTopicEntityDao = null;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int[] getTopicCount(int EventId) {
		int[] as = new int[3];
		as[0] = topicDao.getChooseCount(EventId);
		as[1] = topicDao.getMultipleCount(EventId);
		as[2] = topicDao.getFileCount(EventId);
		return as;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Cacheable(value = "redisCacheManager", key = "'redis_topic_1.'+#Count")
	public ChooseTopicEntity getChooseTopic(int EventId, int Count) {
		return chooseTopicEntityDao.getOneTopic(EventId, Count - 1, 1);

	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Cacheable(value = "redisCacheManager", key = "'redis_topic_2.'+#Count")
	public MultipleTopicEntity getMultipleTopic(int EventId, int Count) {
		// TODO Auto-generated method stub
		return multipleTopicEntityDao.getOneTopic(EventId, Count - 1, 1);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Cacheable(value = "redisCacheManager", key = "'redis_topic_3.'+#Count")
	public FileTopicEntity getFileTopic(int EventId, int Count) {
		// TODO Auto-generated method stub
		return fileTopicEntityDao.getOneTopic(EventId, Count - 1, 1);
	}

	@Override
	@Cacheable(value = "redisCacheManager", key = "'redis_answer_'+#Type+'.'+#Id")
	public TrueAnswer getAnswer(int Id, int Type) {
		// TODO Auto-generated method stub
		return topicDao.getAnswer(Id, Type);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<FileTopicEntity> getFileTopicList() {
		// TODO Auto-generated method stub
		return fileTopicEntityDao.gets();
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<ChooseTopicEntity> getChooseTopicList() {
		// TODO Auto-generated method stub
		return chooseTopicEntityDao.gets();
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<MultipleTopicEntity> getMultipleTopicList() {
		// TODO Auto-generated method stub
		return multipleTopicEntityDao.gets();
	}

	@Override
	public String deletetopic(int id, String type) {
		// TODO Auto-generated method stub
		if (type.equals(1)) {
			if (chooseTopicEntityDao.delete(id)) {
				return "É¾³ý³É¹¦";
			} else {
				return "É¾³ýÊ§°Ü";
			}
		} else if (type.equals(2)) {

			if (multipleTopicEntityDao.delete(id)) {
				return "É¾³ý³É¹¦";
			} else {
				return "É¾³ýÊ§°Ü";
			}
		} else if (type.equals(3)) {

			if (fileTopicEntityDao.delete(id)) {
				return "É¾³ý³É¹¦";
			} else {
				return "É¾³ýÊ§°Ü";
			}
		} else {

			return "É¾³ýÊ§°Ü";
		}
	}

	@Override
	public boolean newmultchoosetopic(MultipleTopicEntity topic) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean newchoosetopic(ChooseTopicEntity topic) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean newfiletopic(FileTopicEntity topic) {
		// TODO Auto-generated method stub
		return false;
	}

}

package com.ssm.chapter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.chapter.pojo.ResultCompetitionEntity;
import com.ssm.chapter.service.ResultCompetitionEntityService;
import com.ssm.chapter.dao.ResultCompetitionEntityDao;

@Service
public class ResultCompetitionEntityServiceimpl implements ResultCompetitionEntityService {

	@Autowired
	private ResultCompetitionEntityDao redao = null;

	@Override
	public boolean insert(ResultCompetitionEntity resultCompetitionEntity) {
		// TODO Auto-generated method stub
		return redao.insert(resultCompetitionEntity);
	}

	@Override
	public boolean deleteResultCompetitionById(int TeamId) {
		// TODO Auto-generated method stub
		return redao.deleteResultCompetitionById(TeamId);
	}

}

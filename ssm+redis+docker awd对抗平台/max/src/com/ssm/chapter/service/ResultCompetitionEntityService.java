package com.ssm.chapter.service;

import com.ssm.chapter.pojo.ResultCompetitionEntity;

public interface ResultCompetitionEntityService {
	// ������������Ľ����
	public boolean insert(ResultCompetitionEntity resultCompetitionEntity);

	public boolean deleteResultCompetitionById(int TeamId);
}

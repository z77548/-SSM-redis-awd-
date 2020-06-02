package com.ssm.chapter.service;

import com.ssm.chapter.pojo.ResultCompetitionEntity;

public interface ResultCompetitionEntityService {
	// 插入比赛报名的结果表
	public boolean insert(ResultCompetitionEntity resultCompetitionEntity);

	public boolean deleteResultCompetitionById(int TeamId);
}

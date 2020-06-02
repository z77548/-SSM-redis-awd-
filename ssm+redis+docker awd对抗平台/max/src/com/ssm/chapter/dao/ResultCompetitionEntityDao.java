package com.ssm.chapter.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.ResultCompetitionEntity;

@Repository
public interface ResultCompetitionEntityDao {

	public ResultCompetitionEntity getGameResult(@Param("EventId") int EventId, @Param("TeamId") int TeamId);

	public boolean updateGameResult(ResultCompetitionEntity resultCompetitionEntity);

	public boolean insert(ResultCompetitionEntity resultCompetitionEntity);

	public boolean deleteResultCompetitionById(int TeamId);
}

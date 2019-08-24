package com.mapper;

import com.pojo.Answers;
import com.pojo.AnswersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnswersMapper {
    long countByExample(AnswersExample example);

    int deleteByExample(AnswersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Answers record);

    int insertSelective(Answers record);

    List<Answers> selectByExample(AnswersExample example);

    Answers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Answers record, @Param("example") AnswersExample example);

    int updateByExample(@Param("record") Answers record, @Param("example") AnswersExample example);

    int updateByPrimaryKeySelective(Answers record);

    int updateByPrimaryKey(Answers record);
}
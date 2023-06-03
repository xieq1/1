package com.graduationproject.dao;

import com.graduationproject.po.Statement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("statementdao")
@Mapper
public interface StatementController {
    int deleteByPrimaryKey(Integer statementid);

    int insert(Statement record);

    int insertSelective(Statement record);

    Statement selectByPrimaryKey(Integer statementid);

    int updateByPrimaryKeySelective(Statement record);

    int updateByPrimaryKey(Statement record);

    void save(Statement statement);
}
package com.graduationproject.dao;

import com.graduationproject.po.Statement;

public interface StatementController {
    int deleteByPrimaryKey(Integer statementid);

    int insert(Statement record);

    int insertSelective(Statement record);

    Statement selectByPrimaryKey(Integer statementid);

    int updateByPrimaryKeySelective(Statement record);

    int updateByPrimaryKey(Statement record);
}
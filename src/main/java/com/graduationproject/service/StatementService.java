package com.graduationproject.service;

import com.graduationproject.po.Statement;

public interface StatementService {
    int deleteByPrimaryKey(Integer statementid);

    int insert(Statement record);

    int insertSelective(Statement record);

    Statement selectByPrimaryKey(Integer statementid);

    int updateByPrimaryKeySelective(Statement record);

    int updateByPrimaryKey(Statement record);

    void save(Statement statement);
}

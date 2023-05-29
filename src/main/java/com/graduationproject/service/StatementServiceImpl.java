package com.graduationproject.service;

import com.graduationproject.po.Statement;
import org.springframework.stereotype.Service;

@Service("StatementService")
public class StatementServiceImpl implements StatementService{
    @Override
    public int deleteByPrimaryKey(Integer statementid) {
        return 0;
    }

    @Override
    public int insert(Statement record) {
        return 0;
    }

    @Override
    public int insertSelective(Statement record) {
        return 0;
    }

    @Override
    public Statement selectByPrimaryKey(Integer statementid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Statement record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Statement record) {
        return 0;
    }
}

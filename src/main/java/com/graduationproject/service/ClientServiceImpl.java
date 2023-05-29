package com.graduationproject.service;

import com.graduationproject.po.Client;
import org.springframework.stereotype.Service;

@Service("ClientService")
public class ClientServiceImpl implements ClientService{
    @Override
    public int deleteByPrimaryKey(Integer clientid) {
        return 0;
    }

    @Override
    public int insert(Client record) {
        return 0;
    }

    @Override
    public int insertSelective(Client record) {
        return 0;
    }

    @Override
    public Client selectByPrimaryKey(Integer clientid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Client record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Client record) {
        return 0;
    }
}

package com.graduationproject.service;

import com.graduationproject.po.Contract;
import org.springframework.stereotype.Service;

@Service("ContractService")
public class ContractServiceImpl implements ContractService{
    @Override
    public int deleteByPrimaryKey(Integer contractid) {
        return 0;
    }

    @Override
    public int insert(Contract record) {
        return 0;
    }

    @Override
    public int insertSelective(Contract record) {
        return 0;
    }

    @Override
    public Contract selectByPrimaryKey(Integer contractid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Contract record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Contract record) {
        return 0;
    }
}

package com.graduationproject.service;

import com.graduationproject.po.Contract;

import java.util.List;

public interface ContractService {
    int deleteByPrimaryKey(Integer contractid);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer contractid);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);

    List<Contract> selectall();

    void save(Contract contract);
}

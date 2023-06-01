package com.graduationproject.dao;

import com.graduationproject.po.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("contractdao")
@Mapper
public interface ContractController {
    int deleteByPrimaryKey(Integer contractid);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer contractid);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);

    void save(Contract contract);

    List<Contract> selectall();
}
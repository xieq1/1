package com.graduationproject.dao;

import com.graduationproject.po.Client;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("clientdao")
@Mapper
public interface ClientController {
    int deleteByPrimaryKey(Integer clientid);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer clientid);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
}
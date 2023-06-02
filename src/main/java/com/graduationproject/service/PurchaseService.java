package com.graduationproject.service;

import com.graduationproject.po.Purchase;

import java.util.List;

public interface PurchaseService {
    int deleteByPrimaryKey(Integer purid);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Integer purid);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);

    List<Purchase> selectall();
}

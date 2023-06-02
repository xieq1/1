package com.graduationproject.dao;

import com.graduationproject.po.Purchase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("purchasedao")
@Mapper
public interface PurchaseController {
    int deleteByPrimaryKey(Integer purid);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Integer purid);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);

    List<Purchase> selectall();
}
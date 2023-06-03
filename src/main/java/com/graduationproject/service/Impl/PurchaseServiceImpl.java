package com.graduationproject.service.Impl;

import com.graduationproject.dao.PurchaseController;
import com.graduationproject.po.Purchase;
import com.graduationproject.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PurchaseService")
public class PurchaseServiceImpl implements PurchaseService {
    @Qualifier("purchasedao")
    @Autowired
    private PurchaseController purchaseService;
    @Override
    public int deleteByPrimaryKey(Integer purid) {
        purchaseService.deleteByPrimaryKey(purid);
        return 0;
    }

    @Override
    public int insert(Purchase record) {
        purchaseService.insert(record);
        return 0;
    }

    @Override
    public int insertSelective(Purchase record) {
        return 0;
    }

    @Override
    public Purchase selectByPrimaryKey(Integer purid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Purchase record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Purchase record) {
        return 0;
    }

    @Override
    public List<Purchase> selectall() {
        List<Purchase> purchaseList = purchaseService.selectall();
        //System.out.println(userList);
        return purchaseList;
    }
}

package com.graduationproject.service;

import com.graduationproject.dao.ContractController;
import com.graduationproject.po.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContractService")
public class ContractServiceImpl implements ContractService{
    @Qualifier("contractdao")
    @Autowired
    private ContractController contractService;
    @Override
    public int deleteByPrimaryKey(Integer contractid) {
        contractService.deleteByPrimaryKey(contractid);
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
        return contractService.selectByPrimaryKey(contractid);
    }

    @Override
    public int updateByPrimaryKeySelective(Contract record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Contract record) {
        return 0;
    }
    @Override
    public List<Contract> selectall() {
        List<Contract> contractList = contractService.selectall();
        //System.out.println(contractList);
        return contractList;
    }

    @Override
    public void save(Contract contract) {
        contractService.save(contract);
    }
}

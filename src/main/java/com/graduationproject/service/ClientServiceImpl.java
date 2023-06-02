package com.graduationproject.service;

import com.graduationproject.dao.ClientController;
import com.graduationproject.po.Client;
import com.graduationproject.po.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClientService")
public class ClientServiceImpl implements ClientService{
    @Qualifier("clientdao")
    @Autowired
    private ClientController clientService;
    @Override
    public int deleteByPrimaryKey(Integer clientid) {
        clientService.deleteByPrimaryKey(clientid);
        return 0;
    }

    @Override
    public int insert(Client record) {
        return 0;
    }

    @Override
    public int insertSelective(Client record) {
        clientService.insertSelective(record);
        return 0;
    }

    @Override
    public Client selectByPrimaryKey(Integer clientid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Client record) {
        clientService.updateByPrimaryKeySelective(record);
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Client record) {
        return 0;
    }

    @Override
    public List<Client> selectall() {
        List<Client> clientList = clientService.selectall();
        System.out.println(clientList);
        return clientList;
    }
}

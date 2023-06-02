package com.graduationproject.controller;

import com.graduationproject.po.Client;
import com.graduationproject.po.Materials;
import com.graduationproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping(value="/getclientall")
    @ResponseBody
    public List<Client> selectall(Client client){
        return clientService.selectall();
    }

    @PostMapping(value="/updatebyid")
    public String update(Client client){
        clientService.updateByPrimaryKeySelective(client);
        return "opinion";
    }
    @PostMapping(value="/updatebyid1")
    public String update1(Client client){
        clientService.updateByPrimaryKeySelective(client);
        return "link";
    }
    @PostMapping(value="/updatebyid3")
    public String update3(Client client){
        clientService.updateByPrimaryKeySelective(client);
        return "message";
    }

    @PostMapping(value="/add")
    public String add(Client client){
        clientService.insertSelective(client);
        return "message";
    }

    @PostMapping(value = "delectbyid")
    public String delectbyid(Integer clientid){
        clientService.deleteByPrimaryKey(clientid);
        System.out.println(clientid);
        return "message";
    }
}

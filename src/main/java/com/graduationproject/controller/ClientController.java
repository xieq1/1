package com.graduationproject.controller;

import com.graduationproject.po.Client;
import com.graduationproject.po.Schedule;
import com.graduationproject.service.ClientService;
import com.graduationproject.service.ScheduleService;
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
}

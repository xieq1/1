package com.graduationproject.controller;

import com.graduationproject.po.Contract;
import com.graduationproject.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @PostMapping(value="/selectall")
    @ResponseBody
    public List<Contract> selectall(Contract contract){
        return contractService.selectall();
    }

    @PostMapping(value = "/insert")
    public String insert(HttpServletRequest request, Contract u)
    {
        int result = contractService.insert(u);
        return "contract";
    }
}

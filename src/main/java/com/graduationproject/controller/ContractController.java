package com.graduationproject.controller;

import com.graduationproject.po.Contract;
import com.graduationproject.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            // 获取上传文件名和类型
            String fileName = file.getOriginalFilename();
            String fileType = file.getContentType();

            // 将合同文件保存到数据库
            byte[] content = file.getBytes();
            Contract contract = new Contract();
            contract.setContractcontentname(fileName);
            contract.setType(fileType);
            contract.setContractcontent(content);
            contractService.save(contract);
            return "上传成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "合同文件上传失败：" + e.getMessage();
        }
    }
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

    @PostMapping("delectbyid")
    public String delectbyid(Contract contract){
        contractService.deleteByPrimaryKey(contract.getContractid());
        return "contract";
    }

    @PostMapping("/getContractContent")
    @ResponseBody
    public ResponseEntity<byte[]> getContractContent(@RequestParam int id) {
        Contract contract = contractService.selectByPrimaryKey(id);
        if (contract == null || contract.getContractcontent() == null) {
            return ResponseEntity.notFound().build();
        }
        // 构造响应头，设置Content-Type和Content-Disposition等信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(contract.getType() + ";charset=UTF-8")); // 设置Content-Type类型
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename(contract.getContractcontentname(), StandardCharsets.UTF_8) // 设置文件名，指定UTF-8编码方式
                .build());
        return new ResponseEntity<>(contract.getContractcontent(), headers, HttpStatus.OK);
    }


}

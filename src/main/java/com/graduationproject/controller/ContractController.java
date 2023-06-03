package com.graduationproject.controller;

import com.aliyun.oss.OSS;
import com.graduationproject.po.Contract;
import com.graduationproject.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private OSS ossClient;
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // 获取上传文件名和类型
            String fileName = file.getOriginalFilename();
            String fileType = file.getContentType();
            System.out.println("ossClient=" + ossClient);
            // 将合同文件保存到 OSS 存储空间中
            String bucketName = "345683"; // 指定 OSS Bucket 的名称
            String objectName = System.currentTimeMillis() + "_" + fileName; // 设置文件在 OSS 中的唯一标识符
            ossClient.putObject(bucketName, objectName, file.getInputStream());

            // 获取文件公共访问链接
            String fileUrl = "https://" + bucketName + ".oss-cn-beijing.aliyuncs.com/" + objectName;

            Contract contract = new Contract();
            contract.setContractcontentname(fileName);
            contract.setType(fileType);
            contract.setContractcontent(fileUrl);
            contractService.save(contract);

            return ResponseEntity.ok().body("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("合同文件上传失败：" + e.getMessage());
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

    @GetMapping("/getContractContent")
    public ResponseEntity<FileSystemResource> getContractContent(@RequestParam String filename) {
        // 拼接文件完整路径
        String savePath = "C:/Users/26496/Desktop/files/contracts/";
        String filePath = savePath + filename;
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println(file);
            return ResponseEntity.notFound().build();
        }
        else {
                System.out.println("文件存在，文件路径为：" + filePath);
        }
        // 封装文件内容
        FileSystemResource resource = new FileSystemResource(file);
        // 构造响应头，设置Content-Type和Content-Disposition等信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); // 设置Content-Type类型
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename(filename, StandardCharsets.UTF_8) // 设置文件名，指定UTF-8编码方式
                .build());
        // 返回响应实体
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}

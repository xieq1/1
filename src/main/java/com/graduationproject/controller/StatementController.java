package com.graduationproject.controller;

import com.aliyun.oss.OSS;
import com.graduationproject.po.Contract;
import com.graduationproject.po.Statement;
import com.graduationproject.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Controller
@RequestMapping("/statement")
public class StatementController {
    @Autowired
    private StatementService statementService;
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
            String bucketName = "2348534"; // 指定 OSS Bucket 的名称
            String objectName = System.currentTimeMillis() + "_" + fileName; // 设置文件在 OSS 中的唯一标识符
            ossClient.putObject(bucketName, objectName, file.getInputStream());

            // 获取文件公共访问链接
            String fileUrl = "https://" + bucketName + ".oss-cn-beijing.aliyuncs.com/" + objectName;

            Statement statement=new Statement();
            statement.setStatementname(fileName);
            statement.setType(fileType);
            statement.setStatementcontent(fileUrl);
            statement.setTime(new Date());
            statementService.save(statement);

            return ResponseEntity.ok().body("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("合同文件上传失败：" + e.getMessage());
        }
    }
}

package com.kin.test.springboot.controller;

import com.kin.test.springboot.base.UploadBaseResp;
import com.kin.test.springboot.model.UploadPackReq;
import com.kin.test.springboot.model.UploadPackResp;
import com.kin.test.springboot.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author WinKinWong
 * @Description 压缩包上传
 * @Date 2019/11/12 16:41
 **/

@RestController
@RequestMapping("/user")
@Slf4j
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/redirect")
    public String redirectHtml() {
        return "work";
    }

    @PostMapping("/upload/zip")
    @ResponseBody
    public UploadBaseResp<UploadPackResp> uploadZip(MultipartFile zipFile, UploadPackReq req) {
        UploadBaseResp<UploadPackResp> uploadBaseResp = fileUploadService.handlerUpload(zipFile, req);
        return uploadBaseResp;
    }

    @GetMapping("/read/file")
    public void readFile(UploadPackReq param) throws IOException {
        UploadBaseResp<String> uploadBaseResp = fileUploadService.readFile(param);
    }
}
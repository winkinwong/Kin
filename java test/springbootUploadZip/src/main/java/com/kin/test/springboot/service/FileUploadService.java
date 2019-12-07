package com.kin.test.springboot.service;

import com.kin.test.springboot.base.UploadBaseResp;
import com.kin.test.springboot.model.UploadPackReq;
import com.kin.test.springboot.model.UploadPackResp;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    UploadBaseResp<UploadPackResp> handlerUpload(MultipartFile zipFile, UploadPackReq req);

    UploadBaseResp<String> readFile(UploadPackReq req) throws IOException;
}

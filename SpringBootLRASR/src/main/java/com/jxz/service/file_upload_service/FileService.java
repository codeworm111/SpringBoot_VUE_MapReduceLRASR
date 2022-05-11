package com.jxz.service.file_upload_service;


import com.jxz.service.config.UploadConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传服务
 */
@Service
public class FileService {

    /**
     * 上传文件
     *
     * @param md5
     * @param file
     */
    public void upload(String name,
                       String md5,
                       MultipartFile file) throws IOException {
        String path = UploadConfig.path + name;
        FileUtils.write(path, file.getInputStream());
    }
}


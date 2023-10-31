package com.papaya.osiris.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    String uploadFile(MultipartFile multipartFile) throws IOException;

    boolean isMultipartFileEmpty(MultipartFile multipartFile);
}

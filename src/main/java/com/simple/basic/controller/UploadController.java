package com.simple.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@Controller
@RequestMapping("/upload")
public class UploadController {

    @GetMapping("/upload")
    public String upload() {
        return "upload/upload";
    }

    @PostMapping("/upload_ok")
    public String upload_ok(@RequestParam("file") MultipartFile file) {

        try {
            String originalFilename = file.getOriginalFilename();
            Long size = file.getSize();
            byte[] arr = file.getBytes();
            String contentType = file.getContentType();

            log.info("originalFilename:{}", originalFilename);
            log.info("size:{}", size);
            log.info("contentType:{}", contentType);
            log.info("arr:{}", arr);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "upload/upload_ok";
    }
}

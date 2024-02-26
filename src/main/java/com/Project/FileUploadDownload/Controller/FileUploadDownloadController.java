package com.Project.FileUploadDownload.Controller;

import com.Project.FileUploadDownload.Model.FileResponse;
import com.Project.FileUploadDownload.Service.FileUploadDownloadService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@Log4j2
public class FileUploadDownloadController {

    @Autowired
    private FileUploadDownloadService fileUploadDownloadService;

    @PostMapping("/upload")
    private ResponseEntity<FileResponse> upload(@RequestParam(name = "file")MultipartFile file, HttpServletRequest request) throws IOException {

        return new ResponseEntity<>(fileUploadDownloadService.saveFile(file,request), HttpStatus.OK);
    }


}

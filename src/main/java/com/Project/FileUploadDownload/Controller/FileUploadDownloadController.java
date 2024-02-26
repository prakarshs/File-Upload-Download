package com.Project.FileUploadDownload.Controller;

import com.Project.FileUploadDownload.Entity.FileEntity;
import com.Project.FileUploadDownload.Model.FileResponse;
import com.Project.FileUploadDownload.Service.FileUploadDownloadService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/download/{fileId}")
    private ResponseEntity<Resource> download(@PathVariable Long fileId){

        FileEntity fileEntity = fileUploadDownloadService.fetch(fileId);

        if (fileEntity == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileEntity.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename="+"Downloaded_"+fileEntity.getFileName())
                .body(new ByteArrayResource(fileEntity.getFileContent()));
    }


}

package com.Project.FileUploadDownload.Service;

import com.Project.FileUploadDownload.Entity.FileEntity;
import com.Project.FileUploadDownload.Model.FileResponse;
import com.Project.FileUploadDownload.Repository.FileUploadDownloadRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Service
public class FileUploadDownloadServiceIMPL implements FileUploadDownloadService{

    @Autowired
    private FileUploadDownloadRepository fileUploadDownloadRepository;
    @Override
    public FileResponse saveFile(MultipartFile file, HttpServletRequest request) throws IOException {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        FileEntity fileEntity = FileEntity.builder()
                .fileName(fileName)
                .fileSize(file.getSize())
                .fileUploadTime(Date.from(Instant.now()))
                .fileContent(file.getBytes())
                .build();

        fileUploadDownloadRepository.save(fileEntity);

        return FileResponse.builder()
                .fileName(fileEntity.getFileName())
                .fileUploadTime(fileEntity.getFileUploadTime())
                .fileId(fileEntity.getFileId())
                .fileSize(fileEntity.getFileSize())
                .downloadUrl(generateUrl(request)+fileEntity.getFileId())
                .build();
    }

    private String generateUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+"/file/download/";
    }
}

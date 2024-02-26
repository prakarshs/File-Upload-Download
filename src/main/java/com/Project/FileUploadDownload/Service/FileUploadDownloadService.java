package com.Project.FileUploadDownload.Service;

import com.Project.FileUploadDownload.Model.FileResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadDownloadService {
    FileResponse saveFile(MultipartFile file, HttpServletRequest request) throws IOException;
}

package com.Project.FileUploadDownload.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FileResponse {
    private Long fileId;
    private String fileName;
    private Long fileSize;
    private Date fileUploadTime;
    private String downloadUrl;
}

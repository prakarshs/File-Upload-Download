package com.Project.FileUploadDownload.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "FILE_DETAILS")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    private String fileName;
    private Long fileSize;
    private Date fileUploadTime;

    @Lob
    @Column(name = "file_data", columnDefinition="MEDIUMBLOB")
    private byte[] fileContent;
}

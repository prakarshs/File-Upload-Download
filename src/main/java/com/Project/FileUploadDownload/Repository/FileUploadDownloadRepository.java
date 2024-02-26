package com.Project.FileUploadDownload.Repository;

import com.Project.FileUploadDownload.Entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadDownloadRepository extends JpaRepository<FileEntity,Long> {
}

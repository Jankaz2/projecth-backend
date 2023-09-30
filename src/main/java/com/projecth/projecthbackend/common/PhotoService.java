package com.projecth.projecthbackend.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.core.sync.RequestBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhotoService {

    private final S3Client s3Client;

    @Value("${s3.bucket.name}")
    private String bucketName;

    private File convertMultiPartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = null;
        if (multipartFile.getOriginalFilename() != null) {
            file = new File(multipartFile.getOriginalFilename());
            try (FileOutputStream outputStream = new FileOutputStream(file)) {
                outputStream.write(multipartFile.getBytes());
            }
        }
        return file;
    }

    @Async
    @Transactional
    public void uploadFile(MultipartFile file, String path) {
        log.info("uploading file into s3");
        try {
            File fileObj = convertMultiPartFileToFile(file);

            s3Client.putObject(
                    PutObjectRequest.builder().bucket(bucketName).key(path).build(),
                    RequestBody.fromFile(fileObj)
            );

            fileObj.delete();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}

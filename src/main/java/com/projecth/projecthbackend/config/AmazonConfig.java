package com.projecth.projecthbackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AmazonConfig {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String accessSecretKey;

    @Bean
    public S3Client s3Client() {
        var basicAWSCredentials = AwsBasicCredentials.create(accessKey, accessSecretKey);
        var credentialsProvider = StaticCredentialsProvider.create(basicAWSCredentials);

        return S3Client.builder()
                .credentialsProvider(credentialsProvider)
                .region(Region.EU_CENTRAL_1)
                .build();
    }
}


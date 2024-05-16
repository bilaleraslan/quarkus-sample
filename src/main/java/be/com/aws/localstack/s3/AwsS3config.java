package be.com.aws.localstack.s3;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Singleton
public class AwsS3config {

    static String ACCESS_KEY = "test";
    static String ACCESS_SECRET = "test";
    static String ENDPOINT_URL = "http://10.6.0.56:4566"; // Example URL

    @Produces
    @Singleton
    public S3Client s3Client() {
        AwsCredentials awsCredentials = AwsBasicCredentials.create(ACCESS_KEY, ACCESS_SECRET);
        return S3Client.builder()
                .region(Region.US_EAST_2) // Set your desired region here
                .endpointOverride(URI.create(ENDPOINT_URL))
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .build();
    }

    @Produces
    @Singleton
    public S3AsyncClient s3AsyncClient() {
        AwsCredentials awsCredentials = AwsBasicCredentials.create(ACCESS_KEY, ACCESS_SECRET);
        return S3AsyncClient.builder()
                .region(Region.US_EAST_2) // Set your desired region here
                .endpointOverride(URI.create(ENDPOINT_URL))
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .build();
    }
}

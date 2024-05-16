package be.com.aws.localstack.s3;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

abstract public class CommonResource {

    static String bucketName="my-bucket";

    protected PutObjectRequest buildPutRequest(FormData formData) {
        return PutObjectRequest.builder()
                .bucket(bucketName)
                .key(formData.data.getName())
                .contentType(formData.mimetype)
                .build();
    }

    protected GetObjectRequest buildGetRequest(String objectKey) {
        return GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();
    }

}

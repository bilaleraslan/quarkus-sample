package be.com.aws.localstack.s3;

import lombok.SneakyThrows;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

abstract public class CommonResource {

    static String bucketName = "my-bucket";

    @SneakyThrows
    protected PutObjectRequest buildPutRequest(FormData formData) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("contentType", formData.mimetype);
        metadata.put("size", Optional.ofNullable(Files.size(formData.data.toPath())).map(String::valueOf).orElse("0"));
        metadata.put("UUID", UUID.randomUUID().toString());
        return PutObjectRequest.builder()
                .bucket(bucketName)
                .key(formData.filename)
                .contentType(formData.mimetype)
                .metadata(metadata)
                .build();
    }

    protected GetObjectRequest buildGetRequest(String objectKey) {
        return GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();
    }

}

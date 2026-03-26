package co.com.iasaws.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AwsS3Config {

    @Value("${aws.region}")
    private String region;

    @Value("${aws.bucket}")
    private String bucket;

    @Value("${aws.endpoint}")
    private String endpoint;


}

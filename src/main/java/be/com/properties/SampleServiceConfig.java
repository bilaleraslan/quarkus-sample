package be.com.properties;

import io.smallrye.config.ConfigMapping;


@ConfigMapping(prefix = "service")
public interface SampleServiceConfig {

    Service demo();
    Service doc();


    public interface Service {
        String url();

        ServiceCedential credential();
    }

    public interface ServiceCedential {
        String username();

        String password();
    }
}

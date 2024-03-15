package be.com.beanbyprofile;

import be.com.beanbyprofile.ProfileDemo;
import be.com.properties.SampleServiceConfig;
import io.quarkus.logging.Log;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.configuration.ConfigUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@ApplicationScoped
@Startup
public class StartupBean {


    Logger log = org.apache.logging.log4j.LogManager.getLogger(this.getClass().getName());
    @Inject
    SampleServiceConfig serviceConfig;

    @Inject
    ProfileDemo profileDemo;

    void onStart(@Observes StartupEvent event) {
        System.out.println(serviceConfig.demo().credential().username());
        System.out.println(serviceConfig.demo().credential().password());
        System.out.println(serviceConfig.doc().credential().username());

        log.info("SampleServiceConfig "
                + ToStringBuilder.reflectionToString(serviceConfig));


        String profiles = ConfigUtils.getProfiles().stream().collect(Collectors.joining(","));
        log.info("The application is starting with profile: {}", profiles);

        log.info("profile: {} , profileDemo text value: {}", profiles, profileDemo.getText());
    }


}

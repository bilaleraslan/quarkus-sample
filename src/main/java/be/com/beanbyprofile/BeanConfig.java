package be.com.beanbyprofile;

import be.com.beanbyprofile.ProfileDemo;
import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

@Dependent
public class BeanConfig {


    @DefaultBean
    @IfBuildProfile("dev")
    @Produces @ApplicationScoped
    public ProfileDemo devProfileDemo() {
        return new ProfileDemo("This is dev profile");
    }


    @IfBuildProfile("test")
    @Produces @ApplicationScoped
    public ProfileDemo testProfileDemo() {
        return new ProfileDemo("This is test profile");
    }


}

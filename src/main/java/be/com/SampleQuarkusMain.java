package be.com;

import be.com.properties.SampleServiceConfig;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.CommandLineArguments;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.configuration.ConfigUtils;
import io.quarkus.runtime.configuration.ProfileManager;
import io.vertx.core.cli.CommandLine;
import jakarta.inject.Inject;

import java.util.stream.Collectors;

@QuarkusMain
public class SampleQuarkusMain implements QuarkusApplication {


    public static void main(String... args) {
        Quarkus.run(SampleQuarkusMain.class, args);
        System.out.println("SampleQuarkusMain Started");
        System.out.println(String.format("Active profiles: %s ", ConfigUtils.getProfiles().stream().collect(Collectors.joining(","))));
    }


    @Override
    public int run(String... args) throws Exception {

        Quarkus.waitForExit();

        System.out.println("SampleQuarkusMain Stopped");
        return 0;

    }
}

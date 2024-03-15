package be.com;


import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class TestConfig implements QuarkusTestProfile {

    @Override
    public String getConfigProfile() {
        return "dev";
    }

}
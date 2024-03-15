package be.com.beanbyprofile;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Dependent
public  class ProfileDemo {
    private String text ="Starting value";

    public ProfileDemo(String text) {
        this.text = text;
    }
}
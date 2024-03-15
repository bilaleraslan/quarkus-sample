package be.com.restclient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.apache.logging.log4j.Logger;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@ApplicationScoped
@RegisterRestClient(configKey = "remote-error-path")
public interface ErrorPathRestClient {


    @Path("/error-path")
    @GET
    Response callErrorPath();
}


package be.com.auth;

import be.com.exceptions.BusinessException;
import io.quarkus.logging.Log;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.UUID;

@Path("/public")
public class PermitPathController {

    Logger logger = org.apache.logging.log4j.LogManager.getLogger(this.getClass().getName());

    @Inject
    SecurityIdentity identity;

    @Path("/permit-path")
    @GET
    public String permitPath() {
        Log.info("Q  -> Permited Path Called");
        logger.info("4j -> Permited Path Called {}", UUID.randomUUID().toString());
        return "this is permit path";
    }

    @Path("/error-path")
    @GET
    public String errorPath() {
        Log.info("Q  ->Error Path Called");
        logger.info("4j ->  Error Path Called {}", UUID.randomUUID().toString());
        Random r = new Random();
        if (r.nextInt(2) == 1) {
            Log.info("Q  > Request dogru degil");
            logger.info("4j ->  Request dogru degil {}", UUID.randomUUID().toString());
            throw new BusinessException("Business hata");
        }
        return "this is permit path";
    }
}

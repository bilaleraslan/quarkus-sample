package be.com.auth.user;

import io.quarkus.logging.Log;
import io.quarkus.security.Authenticated;
import io.quarkus.security.PermissionsAllowed;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.apache.logging.log4j.Logger;
import org.jboss.resteasy.reactive.NoCache;

@Path("/")
public class UserInfoResources {
    Logger logger = org.apache.logging.log4j.LogManager.getLogger(this.getClass().getName());

    @Inject
    SecurityIdentity identity;

    @NoCache
    @Authenticated
    @Path("/user-info")
    @GET
    public String getUserInfo() {
        Log.infof("Q  -> Username : %s", identity.getPrincipal().getName());
        logger.info(String.format("4j  -> Username : %s", identity.getPrincipal().getName()));

        return identity.getPrincipal().getName();
    }


}
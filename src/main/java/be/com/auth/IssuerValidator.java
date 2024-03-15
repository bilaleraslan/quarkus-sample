package be.com.auth;

import io.quarkus.oidc.OidcConfigurationMetadata;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Slf4j
@Provider
public class IssuerValidator {
    @Inject
    OidcConfigurationMetadata configMetadata;

    @Inject
    JsonWebToken jwt;
    @Inject
    SecurityIdentity identity;

    public void filter(ContainerRequestContext requestContext) {

        log.info("IssuerValidator filter called");

        String issuer = configMetadata.getIssuer().replace("{tenant-id}", identity.getAttribute("tenant-id"));
        log.info("issuer :{}", issuer);
        log.info("jwt.getIssuer() :{}", jwt.getIssuer());
        if (!issuer.equals(jwt.getIssuer())) {
            requestContext.abortWith(Response.status(401).build());
        }
    }
}

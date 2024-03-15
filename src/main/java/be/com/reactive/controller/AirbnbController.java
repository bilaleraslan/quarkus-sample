package be.com.reactive.controller;

import be.com.imperative.mapper.ImperativeAirbnbMapper;
import be.com.reactive.dto.AirbnbDTO;
import be.com.reactive.mapper.AirbnbMapper;
import be.com.reactive.service.AirbnbService;
import be.com.restclient.ErrorPathRestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/public/reactive-airbnb")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class AirbnbController {
    Logger log = org.apache.logging.log4j.LogManager.getLogger(this.getClass().getName());

    private final AirbnbService airbnbService;

    @RestClient
    private ErrorPathRestClient errorPathRestClient;


    @Path("/list")
    @GET
    public Uni<List<AirbnbDTO>> list() {
        return airbnbService.list()
                .onItem().transform(AirbnbMapper.INSTANCE::toDTOs);
    }

    @Path("/list-by-mongo-client")
    @GET
    public Uni<List<AirbnbDTO>> listByMongoClient() {
        return airbnbService.listByMongoClient()
                .onItem().transform(AirbnbMapper.INSTANCE::toDTOs);
    }

    @Path("/{name}")
    @GET
    public Uni<AirbnbDTO> getByName(@PathParam("name") String name) {
        return airbnbService.findByName(name).onItem().transform(AirbnbMapper.INSTANCE::toDTO);


    }

    @Path("/list/{limit}")
    @GET
    public Uni<List<AirbnbDTO>> listByLimit(@PathParam("limit") Integer limit) {
        return airbnbService.listByLimit(limit)
                .onItem().transform(AirbnbMapper.INSTANCE::toDTOs);

    }


    @Path("/call-error-path")
    @GET
    public String callErrorPath() throws Exception {
        log.info("Called  airbnb callErrorPath");
        Response res = errorPathRestClient.callErrorPath();
        log.info("Res status {}", res.getStatus());
        return new ObjectMapper().readValue((String) res.getEntity(), String.class);
    }
}

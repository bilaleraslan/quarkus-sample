package be.com.imperative.controller;

import be.com.imperative.dto.ImperativeAirbnbDTO;
import be.com.imperative.mapper.ImperativeAirbnbMapper;
import be.com.imperative.service.ImperativeAirbnbService;
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

@Path("/public/imperative-airbnb")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class ImperativeAirbnbController {
    Logger log = org.apache.logging.log4j.LogManager.getLogger(this.getClass().getName());

    private final ImperativeAirbnbService airbnbService;


    @Path("/list")
    @GET
    public List<ImperativeAirbnbDTO> list() {
        log.info("Called ImperativeAirbnbController  list");
        return airbnbService.list().stream().map(ImperativeAirbnbMapper.INSTANCE::toDTO).toList();

    }

    @Path("/{name}")
    @GET
    public ImperativeAirbnbDTO getByName(@PathParam("name") String name) {
        log.info("Called ImperativeAirbnbController  list");
        return ImperativeAirbnbMapper.INSTANCE.toDTO(airbnbService.findByName(name));

    }

    @Path("/list/{limit}")
    @GET
    public List<ImperativeAirbnbDTO> listByLimit(@PathParam("limit") Integer limit) {
        return airbnbService.listByLimit(limit).stream().map(ImperativeAirbnbMapper.INSTANCE::toDTO).toList();

    }


}

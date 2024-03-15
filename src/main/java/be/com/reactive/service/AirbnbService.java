package be.com.reactive.service;


import be.com.reactive.db.entitiy.Airbnb;
import be.com.reactive.db.repository.AirbnbReactiveRepository;
import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class AirbnbService {
    Logger log = org.apache.logging.log4j.LogManager.getLogger(this.getClass().getName());

    private final AirbnbReactiveRepository airbnbReactiveRepository;

    @Inject
    ReactiveMongoClient reactiveMongoClient;

    public Uni<List<Airbnb>> list() {
        return airbnbReactiveRepository.listAll();
    }

    public Uni<List<Airbnb>> listByLimit(Integer limit) {
        return airbnbReactiveRepository.listAllLimited(limit);
    }

    public Uni<Airbnb> findByName(String name) {
        return airbnbReactiveRepository.findByName(name);
    }


    private ReactiveMongoCollection<Airbnb> getCollection() {

        return reactiveMongoClient.getDatabase("reactiveSpringExample").getCollection("airbnb", Airbnb.class);
    }

    public Uni<List<Airbnb>> listByMongoClient() {
        return getCollection().find()
                .collect().asList();
    }


}

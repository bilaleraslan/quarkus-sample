package be.com.reactive.db.repository;


import be.com.imperative.db.entitiy.ImperativeAirbnb;
import be.com.reactive.db.entitiy.Airbnb;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AirbnbReactiveRepository implements ReactivePanacheMongoRepository<Airbnb> {

    public Uni<Airbnb> findByName(String name) {
        return find("name", name).firstResult();
    }

    public Uni<List<Airbnb>> listAllLimited(int limit) {
        return findAll().page(0, limit).list();
    }


}

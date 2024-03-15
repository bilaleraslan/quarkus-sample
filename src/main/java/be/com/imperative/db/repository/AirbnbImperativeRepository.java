package be.com.imperative.db.repository;


import be.com.imperative.db.entitiy.ImperativeAirbnb;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AirbnbImperativeRepository implements PanacheMongoRepository<ImperativeAirbnb> {
    public ImperativeAirbnb findByName(String name) {
        return find("name", name).firstResult();
    }

    public List<ImperativeAirbnb> listAllLimited(int limit) {
        return findAll().page(0, limit).list();
    }


}

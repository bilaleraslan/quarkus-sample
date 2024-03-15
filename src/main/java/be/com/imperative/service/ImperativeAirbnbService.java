package be.com.imperative.service;


import be.com.imperative.db.entitiy.ImperativeAirbnb;
import be.com.imperative.db.repository.AirbnbImperativeRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ImperativeAirbnbService {
    Logger log = org.apache.logging.log4j.LogManager.getLogger(this.getClass().getName());

    private final AirbnbImperativeRepository airbnbImperativeRepository;

    public List<ImperativeAirbnb> list() {
        log.info("ImperativeAirbnbService list called");
        return airbnbImperativeRepository.listAll();
    }

    public List<ImperativeAirbnb> listByLimit(Integer limit) {
        return airbnbImperativeRepository.listAllLimited(limit);
    }

    public ImperativeAirbnb findByName(String name) {
        log.info("ImperativeAirbnbService findByName called");
        return airbnbImperativeRepository.findByName(name);
    }


}

package be.com;


import be.com.imperative.db.entitiy.ImperativeAirbnb;
import be.com.imperative.db.repository.AirbnbImperativeRepository;
import be.com.imperative.service.ImperativeAirbnbService;
import be.com.reactive.db.entitiy.Airbnb;
import be.com.reactive.db.repository.AirbnbReactiveRepository;
import io.quarkus.mongodb.MongoClientName;
import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import lombok.SneakyThrows;
import org.bson.Document;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@QuarkusTest
@TestProfile(TestConfig.class)
public class TestAirbnbImperative {

    @Inject
    ImperativeAirbnbService imperativeAirbnbService;

    @SneakyThrows
    @Test
    public void test_Imperative_RepoListAll() {

        List<ImperativeAirbnb> airbnbList = imperativeAirbnbService.list();
        System.out.println("List of Airbnb:");

        airbnbList.forEach(airbnb -> {
            System.out.println("Name: " + airbnb.getName() + ", Summary: " + airbnb.getSummary());
        });
    }

}

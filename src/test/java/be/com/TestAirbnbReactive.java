package be.com;


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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
@TestProfile(TestConfig.class)
public class TestAirbnbReactive {

    @Inject
    AirbnbReactiveRepository airbnbReactiveRepository;


    @Inject
    @MongoClientName("reactiveSpringExample")
    ReactiveMongoClient reactiveSpringExampleMongoClient;

    private ReactiveMongoCollection<Document> getCollection() {
        return reactiveSpringExampleMongoClient.getDatabase("reactiveSpringExample").getCollection("airbnb");
    }

    private Uni<List<Airbnb>> list() {
        return getCollection().find()
                .map(doc -> {
                    Airbnb airbnb = new Airbnb();
                    airbnb.setName(doc.getString("name"));
                    airbnb.setListingUrl(doc.getString("listing_url"));
                    airbnb.setSummary(doc.getString("summary"));
                    return airbnb;
                }).collect().asList();
    }


    @SneakyThrows
    @Test
    public void testFindAll_Print() {

        Uni<List<Airbnb>> fruitListUni = list();
        List<Airbnb> airbnbList = fruitListUni.await().indefinitely();

        assertNotNull(airbnbList);

        System.out.println("List of Airbnb:");
        airbnbList.forEach(airbnb -> {
            System.out.println("Name: " + airbnb.getName() + ", Summary: " + airbnb.getSummary());
        });
    }

    @SneakyThrows
    @Test
    public void testFindAllAirbnbEntities() {


        List<Airbnb> airbnbList = getAllByAirbnbReactiveRepository();

        assertNotNull(airbnbList);

        System.out.println("List of Airbnb:");
        airbnbList.forEach(airbnb -> {
            System.out.println("Name: " + airbnb.getName() + ", Summary: " + airbnb.getSummary());
        });


    }

    @SneakyThrows
    @Test
    public void testGetName() {

        Airbnb airbnb = getNameByAirbnbReactiveRepository();

        assertNotNull(airbnb);

        System.out.println("name:" + airbnb.getName());


    }

    private List<Airbnb> getAllByAirbnbReactiveRepository() {
        return airbnbReactiveRepository
                .findAll().list().await().indefinitely();
    }

    private Airbnb getNameByAirbnbReactiveRepository() {
        return airbnbReactiveRepository
                .find("name", "Ribeira Charming Duplex").firstResult().await().indefinitely();
    }
}

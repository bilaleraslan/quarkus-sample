package be.com.imperative.db.entitiy;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MongoEntity(database = "reactiveSpringExample", collection = "airbnb")
public class ImperativeAirbnb extends PanacheMongoEntityBase {

    @BsonProperty("_id")
    @BsonId
    private String id;
    private String name;
    @BsonProperty("listing_url")
    private String listingUrl;
    private String summary;
    private String space;
    private String description;
    private String notes;
    private String transit;
    private String interaction;
    @BsonProperty("property_type")
    private String propertyType;
    @BsonProperty("room_type")
    private String roomType;
    @BsonProperty("bed_type")
    private String bedType;
    @BsonProperty("minimum_nights")
    private String minimumNights;
    @BsonProperty("maximum_nights")
    private String maximumNights;
    @BsonProperty("cancellation_policy")
    private String cancellationPolicy;
    @BsonProperty("last_scraped")
    private LocalDateTime lastScraped;
    @BsonProperty("calendar_last_scraped")
    private LocalDateTime calendarLastScraped;
    private Integer accommodates;
    private Integer bedrooms;
    private Integer beds;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

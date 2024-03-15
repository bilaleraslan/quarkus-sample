package be.com.imperative.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ImperativeAirbnbDTO {
    private String listingUrl;
    private String name;
    private String summary;
    private String space;
    private String description;
    private String notes;
    private String transit;
    private String interaction;
    private String propertyType;
    private String roomType;
    private String bedType;
    private String minimumNights;
    private String maximumNights;
    private String cancellationPolicy;
    private LocalDateTime lastScraped;
    private LocalDateTime calendarLastScraped;
    private Integer accommodates;
    private Integer bedrooms;
    private Integer beds;


    public ImperativeAirbnbDTO(String name) {
        this.name = name;
    }
}

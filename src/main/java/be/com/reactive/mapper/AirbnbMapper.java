package be.com.reactive.mapper;


import be.com.reactive.db.entitiy.Airbnb;
import be.com.reactive.dto.AirbnbDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirbnbMapper {
    AirbnbMapper INSTANCE = Mappers.getMapper(AirbnbMapper.class);

    AirbnbDTO toDTO(Airbnb entity);
    List<AirbnbDTO> toDTOs(List<Airbnb> entities);
    Airbnb toEntity(AirbnbDTO dto);

}

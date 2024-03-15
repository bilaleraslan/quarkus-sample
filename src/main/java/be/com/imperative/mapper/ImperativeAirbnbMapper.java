package be.com.imperative.mapper;


import be.com.imperative.db.entitiy.ImperativeAirbnb;
import be.com.imperative.dto.ImperativeAirbnbDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ImperativeAirbnbMapper {
    ImperativeAirbnbMapper INSTANCE = Mappers.getMapper(ImperativeAirbnbMapper.class);

    ImperativeAirbnbDTO toDTO(ImperativeAirbnb entity);

    List<ImperativeAirbnbDTO> toDTOs(List<ImperativeAirbnb> entities);

    ImperativeAirbnb toEntity(ImperativeAirbnbDTO dto);

}

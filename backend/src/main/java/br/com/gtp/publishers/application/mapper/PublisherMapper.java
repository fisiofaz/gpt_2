package br.com.gtp.publishers.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.gtp.publishers.application.dto.request.CreatePublisherRequest;
import br.com.gtp.publishers.application.dto.request.UpdatePublisherRequest;
import br.com.gtp.publishers.application.dto.response.PublisherResponse;
import br.com.gtp.publishers.domain.entity.Publisher;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "congregation", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    Publisher toEntity(CreatePublisherRequest request);

    @Mapping(target = "congregationId", source = "congregation.id")
    PublisherResponse toResponse(Publisher entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "congregation", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    void updateEntity(
            UpdatePublisherRequest request,
            @MappingTarget Publisher entity);

}
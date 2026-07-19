package br.com.gtp.congregation.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.gtp.congregation.application.dto.request.CreateCongregationRequest;
import br.com.gtp.congregation.application.dto.request.UpdateCongregationRequest;
import br.com.gtp.congregation.application.dto.response.CongregationResponse;
import br.com.gtp.congregation.domain.entity.Congregation;

@Mapper(componentModel = "spring")
public interface CongregationMapper {

    Congregation toEntity(CreateCongregationRequest request);

    CongregationResponse toResponse(Congregation entity);

    void updateEntity(
            UpdateCongregationRequest request,
            @MappingTarget Congregation entity);

}
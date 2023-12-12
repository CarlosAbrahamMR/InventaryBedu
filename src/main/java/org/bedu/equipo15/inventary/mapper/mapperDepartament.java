package org.bedu.equipo15.inventary.mapper;

import org.bedu.equipo15.inventary.dto.dtoDepartament;
import org.bedu.equipo15.inventary.dto.dtoDepartamentCreate;
import org.bedu.equipo15.inventary.dto.dtoEquipment;
import org.bedu.equipo15.inventary.dto.dtoUpdateDepartament;
import org.bedu.equipo15.inventary.model.Departament;
import org.bedu.equipo15.inventary.model.Equipment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface mapperDepartament {


    dtoDepartament toDTO(Departament model);

    @Mapping(target="id", ignore=true)
    Departament toModel(dtoDepartamentCreate dto);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Departament model, dtoUpdateDepartament dto);
}

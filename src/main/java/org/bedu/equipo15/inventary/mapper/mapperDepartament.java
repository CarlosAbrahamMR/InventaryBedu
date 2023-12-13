package org.bedu.equipo15.inventary.mapper;

import org.bedu.equipo15.inventary.dto.dtoDepartament;
import org.bedu.equipo15.inventary.dto.dtoDepartamentCreate;
import org.bedu.equipo15.inventary.dto.dtoEquipment;
import org.bedu.equipo15.inventary.dto.dtoUpdateDepartament;
import org.bedu.equipo15.inventary.model.Departament;
import org.bedu.equipo15.inventary.model.Equipment;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface mapperDepartament {


    dtoDepartament toDTO(Departament model);

    @Mapping(target="id", ignore=true)
    Departament toModel(dtoDepartamentCreate dto);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Departament model, dtoUpdateDepartament dto);
    @Mapping(target = "equipment", ignore = true) // Avoid circular dependency
    Departament toModelAdd(dtoDepartament dto);
}

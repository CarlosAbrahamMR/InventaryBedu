package org.bedu.equipo15.inventary.mapper;

import org.bedu.equipo15.inventary.dto.dtoAddEquipment;
import org.bedu.equipo15.inventary.model.Departament;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface mapperAddEquipment {
    //@Mapping(source = "departament", target = "Departament.id")
    //Departament toModel(dtoAddEquipment equipmentDTO);

}

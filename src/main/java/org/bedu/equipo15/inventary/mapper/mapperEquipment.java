package org.bedu.equipo15.inventary.mapper;

import org.bedu.equipo15.inventary.dto.dtoEquipmentCreate;
import org.bedu.equipo15.inventary.dto.dtoEquipment;
import org.bedu.equipo15.inventary.dto.dtoUpdateDepartament;
import org.bedu.equipo15.inventary.dto.dtoUpdateEquipment;
import org.bedu.equipo15.inventary.model.Departament;
import org.bedu.equipo15.inventary.model.Equipment;
import org.mapstruct.*;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface mapperEquipment {
    dtoEquipment toDTO(Equipment model);

    @Mapping(target="id", ignore=true)
    Equipment toModel(dtoEquipmentCreate dto);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Equipment model, dtoUpdateEquipment dto);


}

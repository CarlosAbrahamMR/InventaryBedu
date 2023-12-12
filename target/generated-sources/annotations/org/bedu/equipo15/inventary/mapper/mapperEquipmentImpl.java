package org.bedu.equipo15.inventary.mapper;

import javax.annotation.processing.Generated;
import org.bedu.equipo15.inventary.dto.dtoEquipment;
import org.bedu.equipo15.inventary.dto.dtoEquipmentCreate;
import org.bedu.equipo15.inventary.dto.dtoUpdateEquipment;
import org.bedu.equipo15.inventary.model.Equipment;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-12T13:55:38-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class mapperEquipmentImpl implements mapperEquipment {

    @Override
    public dtoEquipment toDTO(Equipment model) {
        if ( model == null ) {
            return null;
        }

        dtoEquipment dtoEquipment = new dtoEquipment();

        dtoEquipment.setId( model.getId() );
        dtoEquipment.setDescription( model.getDescription() );
        dtoEquipment.setPrice( model.getPrice() );
        dtoEquipment.setBrand( model.getBrand() );

        return dtoEquipment;
    }

    @Override
    public Equipment toModel(dtoEquipmentCreate dto) {
        if ( dto == null ) {
            return null;
        }

        Equipment equipment = new Equipment();

        equipment.setDescription( dto.getDescription() );
        equipment.setPrice( dto.getPrice() );
        equipment.setBrand( dto.getBrand() );

        return equipment;
    }

    @Override
    public void update(Equipment model, dtoUpdateEquipment dto) {
        if ( dto == null ) {
            return;
        }

        model.setDescription( dto.getDescription() );
        model.setPrice( dto.getPrice() );
        model.setBrand( dto.getBrand() );
    }
}
package org.bedu.equipo15.inventary.mapper;

import javax.annotation.processing.Generated;
import org.bedu.equipo15.inventary.dto.dtoDepartament;
import org.bedu.equipo15.inventary.dto.dtoDepartamentCreate;
import org.bedu.equipo15.inventary.dto.dtoUpdateDepartament;
import org.bedu.equipo15.inventary.model.Departament;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-13T15:46:19-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class mapperDepartamentImpl implements mapperDepartament {

    @Override
    public dtoDepartament toDTO(Departament model) {
        if ( model == null ) {
            return null;
        }

        dtoDepartament dtoDepartament = new dtoDepartament();

        dtoDepartament.setId( model.getId() );
        dtoDepartament.setName( model.getName() );
        dtoDepartament.setPhone( model.getPhone() );

        return dtoDepartament;
    }

    @Override
    public Departament toModel(dtoDepartamentCreate dto) {
        if ( dto == null ) {
            return null;
        }

        Departament departament = new Departament();

        departament.setName( dto.getName() );
        departament.setPhone( dto.getPhone() );

        return departament;
    }

    @Override
    public void update(Departament model, dtoUpdateDepartament dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getName() != null ) {
            model.setName( dto.getName() );
        }
        if ( dto.getPhone() != null ) {
            model.setPhone( dto.getPhone() );
        }
    }

    @Override
    public Departament toModelAdd(dtoDepartament dto) {
        if ( dto == null ) {
            return null;
        }

        Departament departament = new Departament();

        departament.setId( dto.getId() );
        departament.setName( dto.getName() );
        departament.setPhone( dto.getPhone() );

        return departament;
    }
}

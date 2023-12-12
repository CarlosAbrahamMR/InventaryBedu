package org.bedu.equipo15.inventary.service;

import org.bedu.equipo15.inventary.dto.dtoAddEquipment;
import org.bedu.equipo15.inventary.dto.dtoDepartament;
import org.bedu.equipo15.inventary.dto.dtoDepartamentCreate;
import org.bedu.equipo15.inventary.dto.dtoUpdateDepartament;
import org.bedu.equipo15.inventary.mapper.mapperDepartament;
import org.bedu.equipo15.inventary.model.Departament;
import org.bedu.equipo15.inventary.model.Equipment;
import org.bedu.equipo15.inventary.repository.repositoryDepartament;
import org.bedu.equipo15.inventary.repository.repositoryEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class serviceDepartament {
    @Autowired
    private mapperDepartament mapper;
    @Autowired
    private repositoryDepartament repository;
    @Autowired
    private repositoryEquipment repositoryEquipment;


    public List<dtoDepartament> findAll() {

        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public dtoDepartament save(dtoDepartamentCreate data) {
        Departament entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }


    public void update(long id, dtoUpdateDepartament data) {
        Optional<Departament> result = repository.findById(id);

        if (result.isEmpty()) {
            // throw new PacientNotFoundException(id);
        }

        Departament model = result.get();

        mapper.update(model, data);

        repository.save(model);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }


    public List<Equipment> findEquipmentByDepartament(Long departmentId) {

        Optional<Departament> departament = repository.findById(departmentId);


         departament = repository.findById(departmentId);

            //.orElseThrow(() -> new EntityNotFoundException("Department no encontrado con ID: " + departmentId));

    // Obtener todos los equipos vinculados al departamento
        return repositoryEquipment.findAllByDepartamentId(departmentId);
}
}
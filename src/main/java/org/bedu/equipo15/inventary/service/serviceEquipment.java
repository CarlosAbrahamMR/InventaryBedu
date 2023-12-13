package org.bedu.equipo15.inventary.service;

import org.bedu.equipo15.inventary.dto.*;
import org.bedu.equipo15.inventary.exception.NotFoundException;
import org.bedu.equipo15.inventary.mapper.mapperAddEquipment;
import org.bedu.equipo15.inventary.mapper.mapperDepartament;
import org.bedu.equipo15.inventary.mapper.mapperEquipment;
import org.bedu.equipo15.inventary.model.Departament;
import org.bedu.equipo15.inventary.model.Equipment;
import org.bedu.equipo15.inventary.repository.repositoryDepartament;
import org.bedu.equipo15.inventary.repository.repositoryEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class serviceEquipment {
    @Autowired
    private mapperEquipment mapper;
    @Autowired
    private org.bedu.equipo15.inventary.mapper.mapperDepartament mapperDepartament;
    @Autowired
    private repositoryEquipment repository;
    @Autowired
    private org.bedu.equipo15.inventary.repository.repositoryDepartament repositoryDepartament;

    public List<dtoEquipment> findAll(){

        return repository.findAll().stream().map(mapper::toDTO).toList();
    }


    public dtoEquipment save(dtoEquipmentCreate data){
        Equipment entity = repository.save(mapper.toModel(data));
                return mapper.toDTO(entity);
    }
    public void update(long id, dtoUpdateEquipment data) throws NotFoundException {
        Optional<Equipment> result = repository.findById(id);

        if (result.isEmpty()) {
            throw new  NotFoundException(id);
        }

        Equipment model = result.get();

        mapper.update(model, data);

        repository.save(model);
    }

    public void deleteById(long id) throws NotFoundException {
        if (!repository.existsById(id)) {
            throw new NotFoundException(id);
        }

        repository.deleteById(id);
    }

    @Transactional
    public void assignEquipment(long equipmentId, dtoDepartament departamentdto) throws NotFoundException {
        Optional<Equipment> equipmentOptional = repository.findById(equipmentId);

        if (equipmentOptional.isPresent()) {
            Optional<Departament> departamentOptional = repositoryDepartament.findById(departamentdto.getId());

            if (departamentOptional.isPresent()) {
                Equipment equipment = equipmentOptional.get();

                // Map your DTO to the Departament entity using your mapper
                Departament departament = mapperDepartament.toModelAdd(departamentdto);

                // Save the departament
                Departament savedDepartament = repositoryDepartament.save(departament);

                // Set the relationship between departament and equipment
                equipment.setDepartament(savedDepartament);

                // Save the equipment entity
                repository.save(equipment);
            }else {
                throw new NotFoundException(departamentdto.getId());
            }

        } else {

            throw new NotFoundException(equipmentId);

        }
    }
}

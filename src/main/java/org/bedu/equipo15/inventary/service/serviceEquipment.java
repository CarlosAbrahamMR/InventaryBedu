package org.bedu.equipo15.inventary.service;

import org.bedu.equipo15.inventary.dto.*;
import org.bedu.equipo15.inventary.mapper.mapperAddEquipment;
import org.bedu.equipo15.inventary.mapper.mapperEquipment;
import org.bedu.equipo15.inventary.model.Departament;
import org.bedu.equipo15.inventary.model.Equipment;
import org.bedu.equipo15.inventary.repository.repositoryEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceEquipment {
    @Autowired
    private mapperEquipment mapper;
    @Autowired
    private mapperAddEquipment Addmapper;
    @Autowired
    private repositoryEquipment repository;

    public List<dtoEquipment> findAll(){

        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

//    Pendiente Vincular campo Equipment. manufacturer = Manufacturer.id
//    public dtoEquipment save(createpokemonDTO data){
//        Equipment entity = repository.save(mapper.toModel(data));
//        return mapper.toDTO(entity);
//    }
    public dtoEquipment save(dtoEquipmentCreate data){
        Equipment entity = repository.save(mapper.toModel(data));
                return mapper.toDTO(entity);
    }
    public void update(long id, dtoUpdateEquipment data) {
        Optional<Equipment> result = repository.findById(id);

        if (result.isEmpty()) {
            // throw new PacientNotFoundException(id);
        }

        Equipment model = result.get();

        mapper.update(model, data);

        repository.save(model);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public void assignEquipment(long equipmentId, Departament departament) {
        Optional<Equipment> equipmentOptional = repository.findById(equipmentId);
        if (equipmentOptional.isPresent()) {
            Equipment model = equipmentOptional.get();
            model.setDepartament(departament);

            // Acceder a la relación para evitar problemas de carga perezosa
            departament.getEquipment().add(model);

            repository.save(model);
        }
    }
}

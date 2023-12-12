package org.bedu.equipo15.inventary.repository;

import org.bedu.equipo15.inventary.model.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface repositoryEquipment extends CrudRepository<Equipment,Long> {
    List<Equipment> findAll();
    @Query("SELECT e FROM Equipment e WHERE e.departament.id = :departamentId")
    List<Equipment> findAllByDepartamentId(@Param("departamentId") Long departamentId);
}

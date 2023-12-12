package org.bedu.equipo15.inventary.repository;

import org.bedu.equipo15.inventary.model.Departament;
import org.bedu.equipo15.inventary.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface repositoryDepartament extends JpaRepository<Departament,Long>{
    List<Departament> findAll();
}

package org.bedu.equipo15.inventary.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.bedu.equipo15.inventary.dto.dtoAddEquipment;
import org.bedu.equipo15.inventary.dto.dtoDepartament;
import org.bedu.equipo15.inventary.dto.dtoEquipment;
import org.bedu.equipo15.inventary.model.Departament;
import org.bedu.equipo15.inventary.service.serviceEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.bedu.equipo15.inventary.dto.dtoEquipmentCreate;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class controllerEquipment {
    @Autowired
    private serviceEquipment service;

    @Operation(summary = "Lista de equipos almacenados")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<dtoEquipment> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Agregar un nuevo equipo")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public dtoEquipment save(@Valid @RequestBody dtoEquipmentCreate data){
    return service.save(data);
 }

    @Operation(summary = "Eliminar un equipo por ID")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.deleteById(id);
    }

    @Operation(summary = "Asignar un equipo a un departamento")
    @PostMapping("/{equipmentId}/assignEquipment")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void assignEquipment(
            @PathVariable long equipmentId,
            @RequestBody Departament departamentdto) {
        {
            service.assignEquipment(equipmentId, departamentdto);

        }
//        catch (DepartamentNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }


    }
}



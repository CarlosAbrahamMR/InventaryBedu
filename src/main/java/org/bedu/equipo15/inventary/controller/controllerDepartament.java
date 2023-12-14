package org.bedu.equipo15.inventary.controller;

import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.Valid;
import org.bedu.equipo15.inventary.dto.*;
import org.bedu.equipo15.inventary.exception.NotFoundException;
import org.bedu.equipo15.inventary.model.Equipment;
import org.bedu.equipo15.inventary.service.serviceDepartament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departament")
public class controllerDepartament {
    @Autowired
    private serviceDepartament service;

    @Operation(summary = "Lista de todos los departamentos")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<dtoDepartament> findAll(){
        return service.findAll();
    }
    @Operation(summary = "Agregar un nuevo departamento")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public dtoDepartament save(@Valid @RequestBody dtoDepartamentCreate data){
        return service.save(data);
    }
    @Operation(summary = "Actualizar la información de un departamento")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @Valid @RequestBody dtoUpdateDepartament data) throws NotFoundException {
        service.update(id, data);
    }
    @Operation(summary = "Eliminar un departamento por ID")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) throws NotFoundException {
        service.deleteById(id);
    }


}


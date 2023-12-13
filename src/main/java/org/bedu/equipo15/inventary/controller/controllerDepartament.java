package org.bedu.equipo15.inventary.controller;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<dtoDepartament> findAll(){
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public dtoDepartament save(@Valid @RequestBody dtoDepartamentCreate data){
        return service.save(data);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @Valid @RequestBody dtoUpdateDepartament data) throws NotFoundException {
        service.update(id, data);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) throws NotFoundException {
        service.deleteById(id);
    }


}


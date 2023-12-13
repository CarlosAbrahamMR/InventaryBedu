package org.bedu.equipo15.inventary.controller;

import jakarta.validation.Valid;
import org.bedu.equipo15.inventary.dto.*;
import org.bedu.equipo15.inventary.exception.NotFoundException;
import org.bedu.equipo15.inventary.model.Departament;
import org.bedu.equipo15.inventary.service.serviceEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class controllerEquipment {
    @Autowired
    private serviceEquipment service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<dtoEquipment> findAll(){
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public dtoEquipment save(@Valid @RequestBody dtoEquipmentCreate data){
    return service.save(data);
 }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) throws NotFoundException {
        service.deleteById(id);
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @Valid @RequestBody dtoUpdateEquipment data) throws NotFoundException {
        service.update(id, data);
    }

    @PostMapping("/{equipmentId}/assignEquipment")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void assignEquipment(
            @PathVariable long equipmentId,
            @RequestBody dtoDepartament departamentdto) throws NotFoundException {
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



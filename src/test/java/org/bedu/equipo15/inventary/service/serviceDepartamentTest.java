package org.bedu.equipo15.inventary.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.bedu.equipo15.inventary.controller.controllerDepartament;
import org.bedu.equipo15.inventary.dto.dtoDepartament;
import org.bedu.equipo15.inventary.dto.dtoDepartamentCreate;
import org.bedu.equipo15.inventary.dto.dtoUpdateDepartament;
import org.bedu.equipo15.inventary.model.Departament;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.bedu.equipo15.inventary.exception.NotFoundException;

@ExtendWith(MockitoExtension.class)
class serviceDepartamentTest {
    @Mock
    private serviceDepartament service;

    @InjectMocks
    private controllerDepartament controller;

    private dtoUpdateDepartament dtoUpdate;

    private String expectedMessage;


    @BeforeEach
    void setup() {
        dtoUpdate = new dtoUpdateDepartament();
        dtoUpdate.setName("test1234");
        dtoUpdate.setPhone("999-999-9999");
    }

    @Test
    @DisplayName("Buscar todos los Departamentos")
    void testFindAll() {
        List<dtoDepartament> departaments = new ArrayList<>();
        departaments.add(new dtoDepartament());
        when(service.findAll()).thenReturn(departaments);

        List<dtoDepartament> result = controller.findAll();

        verify(service).findAll();

        assertNotNull(result);
    }

    @Test
    @DisplayName("Agregar Departamento")
    void testSave() {
        dtoDepartamentCreate dtoCreate = new dtoDepartamentCreate();
        dtoDepartament savedDepartament = new dtoDepartament();
        when(service.save(any(dtoDepartamentCreate.class))).thenReturn(savedDepartament);

        dtoDepartament result = controller.save(dtoCreate);

        verify(service).save(dtoCreate);

        assertNotNull(result);
    }

    @Test
    @DisplayName("Actualizacion un departamento existente")
    void testUpdate() throws NotFoundException {
        long id = 1;
        dtoUpdateDepartament dtoUpdate = new dtoUpdateDepartament();
        Departament updatedDepartament = new Departament();

        when(service.update(id, dtoUpdate)).thenReturn(updatedDepartament);

        Departament result = controller.update(id, dtoUpdate);

        verify(service).update(id, dtoUpdate);

        assertNotNull(result);
    }


    @Test
    @DisplayName("Actualizacion un departamento no existente")
    void testUpdateUnExist() throws NotFoundException {
        long id = 1;
        expectedMessage = "El elemento no existe";

        doThrow(new NotFoundException(id)).when(service).update(id, dtoUpdate);

        NotFoundException exception = assertThrows( NotFoundException.class, () -> {
            controller.update(id,dtoUpdate);
        });

        assertEquals(expectedMessage,exception.getMessage());
    }

    @Test
    @DisplayName("Eliminar un departamento existente")
    void testDelete() throws NotFoundException {
        long id = 1;
        doNothing().when(service).deleteById(id);

        controller.delete(id);

        verify(service).deleteById(id);
    }

    @Test
    @DisplayName("Eliminar un departamento que no existe")
    void testDeleteUnExist() throws NotFoundException {
        long id = 1;
        expectedMessage = "El elemento no existe";

        doThrow(new NotFoundException(id)).when(service).deleteById(id);

        NotFoundException exception = assertThrows( NotFoundException.class, () -> {
            controller.delete(id);
        });

        assertEquals(expectedMessage, exception.getMessage());
    }
}
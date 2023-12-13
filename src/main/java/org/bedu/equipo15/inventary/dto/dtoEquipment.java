package org.bedu.equipo15.inventary.dto;

import lombok.Data;
import org.bedu.equipo15.inventary.model.Departament;

@Data
public class dtoEquipment {
    private long id;
    private String description;
    private double price;
    private String brand;
    private Departament departament;

}

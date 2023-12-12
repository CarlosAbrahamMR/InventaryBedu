package org.bedu.equipo15.inventary.dto;

import lombok.Data;

@Data
public class dtoAddEquipment {
    private long id;
    private String description;
    private double price;
    private String brand;
    private long departament;


}

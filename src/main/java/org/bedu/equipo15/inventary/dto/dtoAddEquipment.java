package org.bedu.equipo15.inventary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class dtoAddEquipment {
    @Schema(description = "Identificador del equipo", example = "1")
    private long id;
    @Schema(description = "Caracteristicas del equipo", example = "PC windows 10")
    private String description;
    @Schema(description = "Precio del equipo", example = "400")
    private double price;
    @Schema(description = "Marca del equipo", example = "DELL")
    private String brand;
    @Schema(description = "Departamento asociado", example = "12")
    private long departament;


}

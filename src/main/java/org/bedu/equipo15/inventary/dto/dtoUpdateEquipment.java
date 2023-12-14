package org.bedu.equipo15.inventary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema()
@Data
public class dtoUpdateEquipment {
    @Schema(description = "Caracteristicas del equipo", example = "Pc windows 10 ")
    private String description;

    @Schema(description = "Precio del equipo", example = "400")
    private double price;

    @Schema(description = "Marca del equipo", example = "DELL")
    private String brand;
}

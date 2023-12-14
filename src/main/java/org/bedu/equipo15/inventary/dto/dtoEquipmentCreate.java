package org.bedu.equipo15.inventary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class dtoEquipmentCreate {
    @Schema(description = "Identificador del equipo", example = "1")
    @NotNull(message = "La descripción del equipo es obligatoria")
    private String description;
    @Schema(description = "Precio del equipo", example = "400")
    @NotNull(message = "El Precio no puede ser nulo")
    @Min(value = 0, message = "Precio deber ser mayor o igual a 0")
    @Digits(integer = 10, fraction = 2, message = "Formato de Precio Invalido")
    @Positive(message = "Solamente se almiten valores positivos")
    private Double price;
    @Schema(description = "Marca del equipo", example = "DELL")
    @NotNull(message = "La marca del equipo es obligatorio")
    private String brand;
}

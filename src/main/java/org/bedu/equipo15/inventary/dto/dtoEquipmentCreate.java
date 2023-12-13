package org.bedu.equipo15.inventary.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class dtoEquipmentCreate {
    @NotNull(message = "La descripción del equipo es obligatoria")
    private String description;
    @NotNull(message = "El Precio no puede ser nulo")
    @Min(value = 0, message = "Precio deber ser mayor o igual a 0")
    @Digits(integer = 10, fraction = 2, message = "Formato de Precio Invalido")
    @Positive(message = "Solamente se almiten valores positivos")
    private Double price;
    @NotNull(message = "La marca del equipo es obligatorio")
    private String brand;
}

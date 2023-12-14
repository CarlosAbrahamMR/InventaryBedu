package org.bedu.equipo15.inventary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class dtoUpdateDepartament {
    @Schema(description = "Nombre del departamento", example = "Conaduria")
    private String name;
    @Schema(description = "numero del departamento", example = "99-999-9999")
    private String phone;
}

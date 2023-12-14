package org.bedu.equipo15.inventary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
public class dtoDepartament {
    @Schema(description = "Identificador del departaento", example = "1")
    private long id;
    @Schema(description = "Nombre del departamento", example = "Recursos Humanos")
    private String name;
    @Schema(description = "numero del departamento", example = "99-999-9999")
    private String phone;


}

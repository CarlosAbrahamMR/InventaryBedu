package org.bedu.equipo15.inventary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class dtoDepartamentCreate {
    @Schema(description = "nombre del departamento", example = "Recursos Humanos")
    @NotNull(message = "El nombre del Departament es obligatorio")
    @Length(min = 8, max = 20, message = " Usuario debe tener entre 8 y 20 caracteres")
    private String name;
    @Schema(description = "numero del departamento", example = "99-999-9999")
    @NotBlank(message = "El numero Teléfono es obligatorio")
    @Pattern(regexp = "^(\\d{2,4}[- .]?){2}\\d{4}$", message = " El teléfono debe tener formato ##-###-####")
    private String phone;
}

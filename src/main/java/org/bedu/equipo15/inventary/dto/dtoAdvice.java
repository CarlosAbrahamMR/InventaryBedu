package org.bedu.equipo15.inventary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class dtoAdvice {
    private String code;
    private String message;
    private Object details;

}

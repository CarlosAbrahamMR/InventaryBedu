package org.bedu.equipo15.inventary.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class dtoAdvice {
    private String code;
    private String message;
    private Object details;
}
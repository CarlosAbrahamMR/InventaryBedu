package org.bedu.equipo15.inventary.exception;
public class NotFoundException extends RuntimeException {
    
    public NotFoundException(long id) {
        super("El elemento no existe", "ERR_PAC_NOT_FOUND", id);
    }
}

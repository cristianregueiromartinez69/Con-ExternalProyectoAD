package com.cristianProyectoAD.con_external.excepcionglobal;

import com.cristianProyectoAD.con_external.registrosLibros.excepcion.DuplicateIsbnException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 400) {
            return new DuplicateIsbnException("este isbn ya está registrado");
        }
        return new Exception("Error general: " + response.reason());
    }

}

package com.cristianProyectoAD.con_external.servicio;

import com.cristianProyectoAD.con_external.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LibroService {


    private PrdRexClient prdRexClient;

    public LibroService(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<String> registrarLibro(LibroDto libro) {
        return prdRexClient.registrarLibro(libro);
    }


}

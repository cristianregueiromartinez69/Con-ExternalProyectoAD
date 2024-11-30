package com.cristianProyectoAD.con_external.consultas.autor.postgres.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Servicio que gestiona la lógica para consultar libros en una base de datos PostgreSQL.
 * Se comunica con otro servicio para realizar la consulta específica por autor.
 *
 * @author Cristian
 * @version 1.0
 */
@Service
public class LibroAutorServicePostgres {

    private final PrdRexClient prdRexClient;

    /**
     * Constructor que inyecta la dependencia para la comunicación con el servicio externo.
     *
     * @param prdRexClient Cliente que permite realizar consultas a la base de datos PostgreSQL.
     */
    public LibroAutorServicePostgres(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    /**
     * Realiza una consulta para obtener libros filtrados por el autor especificado desde PostgreSQL.
     *
     * @param autor El nombre del autor utilizado como filtro en la consulta.
     * @return Una respuesta HTTP que contiene una lista de objetos {@link LibroDto} con los libros encontrados,
     * o un estado adecuado en caso de error.
     */
    public ResponseEntity<List<LibroDto>> getLibrosPostgresByAutor(String autor){
        return prdRexClient.consultarLibrosAutorPostgres(autor);
    }
}

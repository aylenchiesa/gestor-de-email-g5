package com.mycompany.app;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FiltroTest {

    @Test
    public void testPorTextoLibre() {

        // contactos
        Contacto c1 = new Contacto("Carlos", "carlos@empresa.com");
        Contacto c2 = new Contacto("Ana", "ana@empresa.com");

        // emails
        Email e1 = new Email("Aviso importante", "Reunión el lunes", c1, List.of(c2));
        Email e2 = new Email("Recordatorio", "Enviar informe mensual", c1, List.of(c2));
        Email e3 = new Email("Otro mensaje", "Nada relevante", c1, List.of(c2));

        List<Email> lista = List.of(e1, e2, e3);

        // usamos predicado porTextoLibre + metodo generico filtrar
        Filtro filtro = new Filtro();

        List<Email> resultado = filtro.filtrar(lista, Filtro.porTextoLibre("informe"));

        assertEquals(1, resultado.size());
        assertEquals("Recordatorio", resultado.get(0).getSubject());
    }

    @Test
    public void testFiltroNoLeidosYPara() {

        Contacto ana = new Contacto("Ana", "ana@empresa.com");
        Contacto carlos = new Contacto("Carlos", "carlos@empresa.com");
        Contacto luis = new Contacto("Luis", "luis@empresa.com");

        Email e1 = new Email("Hola", "Mensaje 1", carlos, List.of(ana));
        Email e2 = new Email("Saludos", "Mensaje 2", luis, List.of(ana));
        Email e3 = new Email("Test", "Mensaje 3", luis, List.of(carlos));

        // marcar solo uno como leído
        e2.marcarComoLeido();

        List<Email> lista = List.of(e1, e2, e3);

        Filtro filtro = new Filtro();

        List<Email> resultado = filtro.filtroNoLeidosYPara(lista, "ana@empresa.com");

        // solo e1 cumple: no leído Y destinatario ana
        assertEquals(1, resultado.size());
        assertEquals("Hola", resultado.get(0).getSubject());
    }
}


package cl.ucn.Facade;

import jakarta.persistence.EntityManager;
import cl.ucn.modelo.*;
import com.jcabi.log.Logger;
import cl.ucn.main.Main;
import cl.ucn.modelo.Asistente;
import cl.ucn.modelo.Evento;

import java.util.List;


public class EliminarEvento 
{
    public void eliminarEventoAsistente(EntityManager em, Asistente asistente) 
    {
        // Lógica para eliminar el evento del asistente
        List<Evento> eventoAsiste = asistente.getEventos();
    
        Logger.info(Main.class, "Actualiza eliminando el festival de jazz del asistente");
        Evento eventoRemueve = em.find(Evento.class, 3);
        asistente.getEventos().remove(eventoRemueve);
        eventoRemueve.getAsistentes().remove(asistente);

        em.merge(asistente);

        Logger.info(Main.class, "Ahora solo asistirá a: ");
        for (Evento evento : eventoAsiste) {
            Logger.info(Main.class, evento.getNombre());
        }
        System.out.println("Proceso de eliminación de evento completado.");
    }
}

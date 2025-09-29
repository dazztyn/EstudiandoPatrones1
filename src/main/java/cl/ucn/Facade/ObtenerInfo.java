package cl.ucn.Facade;

import java.util.List;

import com.jcabi.log.Logger;

import cl.ucn.main.Main;
import cl.ucn.modelo.Asistente;
import cl.ucn.modelo.Evento;
import jakarta.persistence.EntityManager;

public class ObtenerInfo 
{
    public void obtenerInfoAsistente(EntityManager em, long rut,Asistente asistente) 
    {
        // Lógica para obtener la información del asistente
        Logger.info(Main.class,"El asistente " + asistente.getNombre() + " con email " + asistente.getEmail());
        Logger.info(Main.class, "Asiste a los siguientes eventos:");
        List<Evento> eventoAsiste = asistente.getEventos();

        for (Evento evento : eventoAsiste) {
            Logger.info(Main.class, evento.getNombre());
        }

        System.out.println("Proceso de obtención de información completado.");
    }
}

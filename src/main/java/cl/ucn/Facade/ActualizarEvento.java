package cl.ucn.Facade;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import jakarta.persistence.EntityManager;

import cl.ucn.modelo.Asistente;
import cl.ucn.modelo.Evento;




public class ActualizarEvento 
{
    public void actualizarEvento(EntityManager em)
    {
        org.apache.logging.log4j.Logger fileLogger =
            LogManager.getLogger(" ");
        
        int id = 1;
        Evento evento2 = em.find(Evento.class, id);

        evento2.setLugar("Estadio Santa Laura"); //aqui se debe llamar al observer, porque hubo un cambio
        em.merge(evento2);
        em.getTransaction().commit();
        // ***********************************************************

        fileLogger.info("******************************* RESUMEN ******************************* ");
        List<Asistente> asistentes  = em.createQuery("from Asistente a", Asistente.class).getResultList();
        for (Asistente asistente2 : asistentes) {
            fileLogger.info("{} , {} , {}", asistente2.getRut(), asistente2.getNombre(), asistente2.getEmail());
            for (Evento evento1 : asistente2.getEventos()) {
                fileLogger.info("  ->  {} , {} , {} , {}", evento1.getId(), evento1.getNombre(), evento1.getFecha(), evento1.getLugar());
            }
        }
    }
}

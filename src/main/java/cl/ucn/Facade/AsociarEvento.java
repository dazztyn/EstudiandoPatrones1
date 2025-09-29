package cl.ucn.Facade;

import java.util.ArrayList;
import com.jcabi.log.Logger;
import cl.ucn.main.Main;
import cl.ucn.modelo.Asistente;
import cl.ucn.modelo.Evento;
import jakarta.persistence.*;
public class AsociarEvento 
{
    public void asociarEventoAsistente(Asistente asistente, Evento evento2, EntityManager em)
    {
        asistente.getEventos().add(evento2);
        evento2.setAsistentes(new ArrayList<>());
        evento2.getAsistentes().add(asistente);
        em.merge(asistente);
        em.getTransaction().commit();
        Logger.info(Main.class, "Se ha asociado el evento N° " + evento2.getId() + " con " + asistente.getNombre());
    }    
}

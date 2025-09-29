package cl.ucn.Facade;

import com.jcabi.log.Logger;

import cl.ucn.main.Main;
import cl.ucn.modelo.Evento;
import jakarta.persistence.*;

public class AgregarEvento 
{
    public void ingresarEvento(EntityManager em, int id)
    {
        em.getTransaction().begin();
        Evento evento = new Evento();
        evento.setId(id);
        evento.setFecha("2024-10-25");
        evento.setNombre("Alice in Chains");
        evento.setLugar("Parque Ohiggins");
        em.persist(evento);
        em.getTransaction().commit();
        Logger.info(Main.class, "Se ha ingresado el evento N° " + evento.getId() + " Nombre: " + evento.getNombre());
    }
}

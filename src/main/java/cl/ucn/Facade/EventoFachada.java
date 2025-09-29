package cl.ucn.Facade;

import java.util.*;

import com.jcabi.log.Logger;

import cl.ucn.Facade.EliminarEvento;
import cl.ucn.Facade.ObtenerInfo;
import cl.ucn.Facade.AgregarEvento;

import cl.ucn.main.Main;
import cl.ucn.modelo.Asistente;
import cl.ucn.modelo.Evento;
import jakarta.persistence.*;

public class EventoFachada 
{
    private ObtenerInfo obtenerInfo;
    private EliminarEvento eliminarEvento;
    private AgregarEvento agregarEvento;
    private AsociarEvento asociarEvento;
    private ActualizarEvento actualizarEvento;

    public EventoFachada() 
    {
        this.obtenerInfo = new ObtenerInfo();
        this.eliminarEvento = new EliminarEvento();
        this.agregarEvento = new AgregarEvento();
        this.asociarEvento = new AsociarEvento();
        this.actualizarEvento = new ActualizarEvento();
    }

    public void obtenerInfoAsistente(EntityManager em) 
    {
        long rut = 217638392;
        Asistente asistente = em.find(Asistente.class, rut);
        System.out.println("");
        System.out.println("Obteniendo información del asistente con RUT: " + rut);
        this.obtenerInfo.obtenerInfoAsistente(em, rut, asistente);
    }

    public void eliminarEventoAsistente(EntityManager em) 
    {
        long rut = 217638392;
        Asistente asistente = em.find(Asistente.class, rut);
        System.out.println("");
        System.out.println("Eliminando evento del asistente con RUT: " + asistente.getRut());
        this.eliminarEvento.eliminarEventoAsistente(em, asistente);
    }

    public void agregarEvento(EntityManager em) 
    {

        long rut = 64389216;
        Asistente asistente = em.find(Asistente.class, rut);
        Evento evento2 = em.find(Evento.class, 4);
        
        int ultimoEvento = 0;

        Query query = em.createNativeQuery("select max(id) from Evento");
        try {
            ultimoEvento = (int) query.getSingleResult();
        }catch (NoResultException e){
            Logger.info(Main.class, "No existen resultados");
        }

        int id = ultimoEvento+1;

        System.out.println("");
        System.out.println("Agregando un nuevo evento a la base de datos");
        cl.ucn.Facade.AgregarEvento agregarEvento = new cl.ucn.Facade.AgregarEvento();
        agregarEvento.ingresarEvento(em,id);
    }
    
    public void asociarEvento(EntityManager em) 
    {
        long rut = 64389216;
        Asistente asistente = em.find(Asistente.class, rut);
        Evento evento2 = em.find(Evento.class, 4);
        System.out.println("");
        System.out.println("Asociando un evento con un asistente");
        cl.ucn.Facade.AsociarEvento asociarEvento = new cl.ucn.Facade.AsociarEvento();
        asociarEvento.asociarEventoAsistente(asistente, evento2, em);
    }

    public void actualizarEvento(EntityManager em)
    {
        System.out.println("");
        System.out.println("Actualizando un evento");
        actualizarEvento.actualizarEvento(em);
    }
}

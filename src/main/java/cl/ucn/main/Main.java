package cl.ucn.main;

import cl.ucn.modelo.Asistente;
import cl.ucn.modelo.Evento;
import cl.ucn.Observer.Sujeto;

import jakarta.persistence.*;
import com.jcabi.log.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;
import java.util.List;

import cl.ucn.Facade.*;

public class Main {

    private static final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("ticketmaster");

    private static final org.apache.logging.log4j.Logger fileLogger = LogManager.getLogger(" ");

    // Debido a que la lógica del sistema se encuentra en el main, se debería
    // trasladar esos métodos
    // a una clase de servicio para mantener el principio de responsabilidad única.
    // por ende, uno de los patrones a usar es el patrón Fachada (Facade).

    // también, el enunciado menciona que al actualizar datos de un evento los
    // asistentes deben ser notificados.
    // esto se puede lograr implementando el patrón Observador (Observer), donde los
    // asistentes son observadores
    // y los eventos son sujetos que notifican a los observadores sobre los cambios.

    public static void main(String[] args) {

        // Cargamos los datos a nuestra base de datos
        EntityManager em = entityManagerFactory.createEntityManager();

        // iniciamos la fachada
        EventoFachada eventoFachada = new EventoFachada();
        // ********* Eliminar un Evento para un Asistente ************
        // ***********************************************************

        // Obtenemos las informaciones del asistente 217638392
        em.getTransaction().begin();

        eventoFachada.obtenerInfoAsistente(em);

        // Elimina el evento Festival de Jazz
        eventoFachada.eliminarEventoAsistente(em);
        /*
         * Logger.info(Main.class,
         * "Actualiza eliminando el festival de jazz del asistente");
         * Evento eventoRemueve = em.find(Evento.class, 3);
         * asistente.getEventos().remove(eventoRemueve);
         * eventoRemueve.getAsistentes().remove(asistente);
         * em.merge(asistente);
         * Logger.info(Main.class, "Ahora solo asistirá a: ");
         * for (Evento evento : eventoAsiste) {
         * Logger.info(Main.class, evento.getNombre());
         * }
         */
        em.getTransaction().commit();

        // ***********************************************************
        // ***************** Ingresa un nuevo Evento *****************
        // ***********************************************************

        eventoFachada.agregarEvento(em);

        // ***********************************************************
        // ************* Asociar un Evento con Asistente *************
        // ***********************************************************
        em.getTransaction().begin();

        eventoFachada.asociarEvento(em);

        // ***********************************************************
        // ******************* Actualizar un evento ******************
        // ***********************************************************
        em.getTransaction().begin();

        eventoFachada.actualizarEvento(em);
        em.close();
    }
}

/*
 * 
 * 1. ¿Cuales patrones de diseño son los adecuados para dar solución al problema
 * de implementación?. Escriba una breve explicación
 * 
 * R: Los patrones ideales para este problema son Facade y Observer.
 * - Facade permite que la lógica del sistema se encuentre distribuida en
 * múltiples clases a las que el user no tiene acceso directo,
 * sino que interactúa únicamente con los métodos llamados desde el main.
 * 
 * - Observer permite que los asistentes sean notificados automáticamente cuando
 * un evento al que están asociados se actualiza,
 * esto sin necesidad de que el asistente consulte manualmente los cambios.
 * 
 * 
 * 2. ¿Cuales son las propiedades y principios de diseño que atienden los
 * patrones escogidos?. Escriba una breve explicación.
 * 
 * R: Los principios de diseño atendidos por los patrones escogidos son:
 * - Principio de Responsabilidad Única (SRP): Cada clase tiene una única
 * responsabilidad, que son los métodos que contienen la lógica del sistema
 * que maneja la fachada por separado.
 * 
 * - Principio de Abierto/Cerrado (OCP): Las clases están abiertas para
 * extensión pero cerradas para modificación, ya que se pueden agregar nuevos
 * métodos
 * pero el observador debe si o si notificar como mínimo los cambios al usuario
 * 
 * 
 * 
 */

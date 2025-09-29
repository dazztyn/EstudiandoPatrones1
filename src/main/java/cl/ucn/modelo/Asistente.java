package cl.ucn.modelo;

import jakarta.persistence.*;

import java.util.List;
import cl.ucn.Observer.Observador;
import cl.ucn.Observer.Sujeto;

@Entity
public class Asistente implements Observador{

    @Id
    @Column(name = "rut")
    private Long rut;
    private String nombre;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "asistentes", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    List<Evento> eventos;

    public void setRut(Long rut) {
        this.rut = rut;
    }

    public Long getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public void actualizar(Sujeto evento) {
        // TODO Auto-generated method stub

        //debido a que actualizar recibe un Sujeto, se debe castear a Evento
        //para poder acceder a sus atributos
        //esto es posible porque Evento hereda de Sujeto

        Evento eventoActualizado = ((Evento) evento);

        System.out.println("Notificación Observer: El evento " + eventoActualizado.getNombre() +
            " ha sido actualizado. Nueva fecha: " + eventoActualizado.getFecha() +
            " Nuevo lugar: " + eventoActualizado.getLugar() + " para el asistente " + this.nombre);
    }
}
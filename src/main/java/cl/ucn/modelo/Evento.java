package cl.ucn.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import cl.ucn.Observer.Sujeto;

@Entity
public class Evento extends Sujeto{

    @Id
    private Long id;
    private String nombre;
    private String fecha;
    private String lugar;

    @ManyToMany
    @JoinTable(
            name = "evento_asistente",
            joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "rut"))
    private List<Asistente> asistentes;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

        if (this.asistentes != null) {
            for (Asistente asistente : asistentes) {
                asistente.actualizar(this);
            }
        }
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;

        if (this.asistentes != null) {
            for (Asistente asistente : asistentes) {
                asistente.actualizar(this);
                
            }
        }
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;

        if (this.asistentes != null) {
            for (Asistente asistente : asistentes) {
                asistente.actualizar(this);
            }
        }
    }

    public List<Asistente> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    public void agregarAsistente(Asistente asistente) {
        asistentes.add(asistente);
    }

}

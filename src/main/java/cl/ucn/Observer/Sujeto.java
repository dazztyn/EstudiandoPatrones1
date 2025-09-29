package cl.ucn.Observer;

import java.util.ArrayList;
import java.util.List;

import cl.ucn.modelo.Evento;

import cl.ucn.Observer.Observador;

public class Sujeto
{
    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador observador) 
    {
        observadores.add(observador);
    }

    
    public void notificarObservadores() 
    {
        for (Observador observador : observadores) 
        {
            observador.actualizar(this);
        }
    }
    
}

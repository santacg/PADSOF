package gui.modelo.centroExposicion;

import gui.modelo.usuario.Usuario;

/**
 * Clase Gestor.
 * Representa un gestor dentro del sistema de gestión de usuarios.
 * Esta clase extiende de {@link Usuario}, heredando sus atributos y métodos.
 *
 * @author Carlos García Santa, Joaquín Abad Díaz y Eduardo Junoy Ortega
 *
 */
public class Gestor extends Usuario {

    /**
     * Crea una nueva instancia de la clase Getsor con el NIF especificado.
     * 
     * @param NIF the NIF (identification number) of the Gestor
     */
    public Gestor(String NIF) {
        super(NIF);
    }

    /**
     * Devuelve una representación en cadena de un gestor.
     * 
     * @return a string representation of a gestor
     */
    public String toString() {
        return "Gestor [NIF=" + getNIF() + "]";
    }

}

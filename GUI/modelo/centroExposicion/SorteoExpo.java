package GUI.modelo.centroExposicion;

import java.time.LocalDate;

import GUI.modelo.exposicion.Exposicion;

/**
 * Clase SorteoExpo.
 * Esta clase hereda de {@link Sorteo} para añadir la cobertura de la fecha
 * en la que una exposición está vigente.
 * 
 * @author Carlos García Santa, Joaquín Abad Díaz y Eduardo Junoy Ortega
 *
 */
public class SorteoExpo extends Sorteo{

    /**
     * Constructor de un sorteo para la vigencia de exposición.
     * 
     * @param exposicion   La exposición del sorteo
     * @param fechaSorteo  La fecha en la que se realizará el sorteo
     */
    public SorteoExpo(Exposicion exposicion, LocalDate fechaSorteo, int n_entradas) {
        super(fechaSorteo, exposicion, n_entradas);
    }

    /**
     * Retorna la fecha límite de la exposición.
     * 
     * @return La fecha en la que la exposición finaliza.
     */
    public LocalDate getFechaLimite() {
        return getExposicion().getFechaFin();
    }

}

package gui.modelo.exposicion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.io.Serializable;

/**
 * Clase Hora.
 * Representa un horario específico para una actividad en una exposición,
 * incluyendo información sobre la disponibilidad y precio de las entradas.
 * 
 * @author Carlos García Santa, Joaquín Abad Díaz y Eduardo Junoy Ortega
 */
public class Hora implements Serializable {
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer nEntradas;
    private Integer countEntradas;

    /**
     * Constructor para crear un nuevo horario con detalles específicos.
     * 
     * @param fecha      La fecha de la actividad.
     * @param horaInicio La hora de inicio de la actividad.
     * @param horaFin    La hora de fin de la actividad.
     * @param nEntradas  El número total de entradas disponibles para la actividad.
     */
    public Hora(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, Integer nEntradas) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.nEntradas = nEntradas;
        countEntradas = nEntradas;
    }

    /**
     * Añade una entrada.
     * 
     */
    public void addEntrada() {
        nEntradas++;
        countEntradas++;
    }

    /**
     * Elimina una entrada.
     * 
     */
    public void removeEntrada() {
        nEntradas--;
        countEntradas--;
    }

    /**
     * Elimina todas las entradas del conjunto de entradas para este horario y
     * reinicia el contador de entradas disponibles.
     */
    public void removeAllEntradas() {
        countEntradas = 0;
    }



    /**
     * Obtiene la fecha del tramo horario.
     * 
     * @return La fecha del tramo horario.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la actividad.
     * 
     * @param fecha La nueva fecha para la actividad.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de inicio de la actividad.
     * 
     * @return La hora de inicio de la actividad.
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio de la actividad.
     * 
     * @param horaInicio La nueva hora de inicio para la actividad.
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora de fin de la actividad.
     * 
     * @return La hora de fin de la actividad.
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }

    /**
     * Establece la hora de fin de la actividad.
     * 
     * @param horaFin La nueva hora de fin para la actividad.
     */
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Obtiene el número actual de entradas no vendidas, es decir, disponibles.
     *
     * @return La cantidad de entradas disponibles.
     */
    public Integer getCountEntradas() {
        return countEntradas;
    }

    /**
     * Obtiene el número de entradas totales para la actividad.
     * 
     * @return El número total de entradas totales.
     */
    public Integer getnEntradas() {
        return nEntradas;
    }

    /**
     * Registra la venta de una entrada recudiendo en una unidad el contador.
     */
    public void entradaVendida() {
        countEntradas--;
    }

    /**
     * Obtiene el número de entradas disponibles para la actividad.
     * 
     * @return El número total de entradas disponibles.
     */
    public Integer getnEntradasDisp() {
        return countEntradas;
    }

    /**
     * Genera una representación en cadena de caracteres del horario.
     * 
     * @return La representación en cadena de caracteres del horario.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Detalles hora:\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Hora de Inicio: ").append(horaInicio).append("\n");
        sb.append("Hora de Fin: ").append(horaFin).append("\n");
        sb.append("Número de Entradas: ").append(nEntradas).append("\n");

        return sb.toString();
    }

    /**
     * Genera un código hash para el horario.
     * 
     * @return El código hash.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
        result = prime * result + ((horaFin == null) ? 0 : horaFin.hashCode());
        return result;
    }

    /**
     * Reserva un número de entradas para un horario.
     * 
     * @param n_entradas El número de entradas a reservar.
     */
    public void reservarEntradas(int n_entradas){
        if (n_entradas <= this.countEntradas) {
            countEntradas -= n_entradas;
        }
        else{
            System.err.println("No hay tantas entradas disponibles para ese día a esa hora");
        }
        
    }

    /**
     * Compara dos horarios para determinar si son iguales.
     * 
     * @param obj El objeto a comparar con este horario.
     * @return {@code true} si los objetos son iguales, {@code false} en caso contrario.
     * 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hora other = (Hora) obj;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (horaInicio == null) {
            if (other.horaInicio != null)
                return false;
        } else if (!horaInicio.equals(other.horaInicio))
            return false;
        if (horaFin == null) {
            if (other.horaFin != null)
                return false;
        } else if (!horaFin.equals(other.horaFin))
            return false;
        return true;
    }
}

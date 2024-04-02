package CentroExposicion;

import java.time.LocalDate;
import java.time.LocalTime;

import Sala.Sala;
import Sala.SalaExposicion;

import java.util.HashSet;
import java.util.Set;
import Exposicion.EstadoExposicion;
import Exposicion.Exposicion;
import Exposicion.TipoExpo;
import Obra.Obra;

/**
 * Clase CentroExposicion.
 * Esta clase ofrece funcionalidades para manejar las salas, exposiciones,
 * obras, empleados, y descuentos dentro del centro de exposición.
 *
 * @author Carlos García Santa, Joaquín Abad Díaz y Eduardo Junoy Ortega
 *
 */

public class CentroExposicion {
    private Integer ID;
    private static Integer IDcount = 0;
    private String nombre;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private String localizacion;
    private String contraseniaEmpleado;
    private String contraseniaGestor;
    private Integer sancion;
    private Set<Exposicion> exposiciones = new HashSet<>();
    private Set<Sorteo> sorteos = new HashSet<>();
    private Set<Obra> obras = new HashSet<>();
    private Set<Empleado> empleados = new HashSet<>();
    private Set<Descuento> descuentos = new HashSet<>();
    private Set<Sala> salas = new HashSet<>();
    private Gestor gestor;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CentroExposicion other = (CentroExposicion) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (horaApertura == null) {
            if (other.horaApertura != null)
                return false;
        } else if (!horaApertura.equals(other.horaApertura))
            return false;
        if (horaCierre == null) {
            if (other.horaCierre != null)
                return false;
        } else if (!horaCierre.equals(other.horaCierre))
            return false;
        if (localizacion == null) {
            if (other.localizacion != null)
                return false;
        } else if (!localizacion.equals(other.localizacion))
            return false;
        if (contraseniaEmpleado == null) {
            if (other.contraseniaEmpleado != null)
                return false;
        } else if (!contraseniaEmpleado.equals(other.contraseniaEmpleado))
            return false;
        if (contraseniaGestor == null) {
            if (other.contraseniaGestor != null)
                return false;
        } else if (!contraseniaGestor.equals(other.contraseniaGestor))
            return false;
        if (sancion == null) {
            if (other.sancion != null)
                return false;
        } else if (!sancion.equals(other.sancion))
            return false;
        if (exposiciones == null) {
            if (other.exposiciones != null)
                return false;
        } else if (!exposiciones.equals(other.exposiciones))
            return false;
        if (sorteos == null) {
            if (other.sorteos != null)
                return false;
        } else if (!sorteos.equals(other.sorteos))
            return false;
        if (obras == null) {
            if (other.obras != null)
                return false;
        } else if (!obras.equals(other.obras))
            return false;
        if (empleados == null) {
            if (other.empleados != null)
                return false;
        } else if (!empleados.equals(other.empleados))
            return false;
        if (descuentos == null) {
            if (other.descuentos != null)
                return false;
        } else if (!descuentos.equals(other.descuentos))
            return false;
        if (salas == null) {
            if (other.salas != null)
                return false;
        } else if (!salas.equals(other.salas))
            return false;
        if (gestor == null) {
            if (other.gestor != null)
                return false;
        } else if (!gestor.equals(other.gestor))
            return false;
        return true;
    }

    /**
     * Constructor de un centro de exposición con los parámetros proporcionados.
     *
     * @param nombre              el nombre del centro de exposición
     * @param horaApertura        la hora de apertura del centro
     * @param horaCierre          la hora de cierre del centro
     * @param localizacion        la ubicación del centro
     * @param contraseniaEmpleado la contraseña para los empleados del centro
     * @param contraseniaGestor   la contraseña para el gestor del centro
     * @param gestor              el gestor del centro
     * @param salas               el conjunto inicial de salas
     */
    public CentroExposicion(String nombre, LocalTime horaApertura,
            LocalTime horaCierre, String localizacion,
            String contraseniaEmpleado, String contraseniaGestor,
            Gestor gestor, Set<Sala> salas) {
        this.ID = IDcount++;
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.localizacion = localizacion;
        this.contraseniaEmpleado = contraseniaEmpleado;
        this.contraseniaGestor = contraseniaGestor;
        this.gestor = gestor;
        this.salas = salas;
    }

    /**
     * Devuelve el identificador único de la entidad.
     * 
     * @return Identificador único del objeto.
     */
    public Integer getID() {
        return ID;
    }

    /**
     * Obtiene el nombre de la entidad.
     * 
     * @return El nombre actual de la entidad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nuevo nombre a la entidad.
     * 
     * @param nombre El nuevo nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la hora de apertura.
     * 
     * @return La hora de apertura en formato de uso horario.
     */
    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    /**
     * Establece la hora de apertura.
     * 
     * @param horaApertura La hora de apertura a establecer.
     */
    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * Obtiene la hora de cierre.
     * 
     * @return La hora de cierre en formato de uso horario.
     */
    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    /**
     * Establece la hora de cierre.
     * 
     * @param horaCierre La hora de cierre a establecer.
     */
    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    /**
     * Devuelve la localización de la entidad.
     * 
     * @return La localización actual.
     */
    public String getLocalizacion() {
        return localizacion;
    }

    /**
     * Define una nueva localización para la entidad.
     * 
     * @param localizacion La nueva localización a asignar.
     */
    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    /**
     * Accede a la contraseña de empleado.
     * 
     * @return La contraseña de empleado.
     */
    public String getContraseniaEmpleado() {
        return contraseniaEmpleado;
    }

    /**
     * Establece una nueva contraseña para empleado.
     * 
     * @param contraseniaEmpleado La nueva contraseña a asignar.
     */
    public void setContraseniaEmpleado(String contraseniaEmpleado) {
        this.contraseniaEmpleado = contraseniaEmpleado;
    }

    /**
     * Obtiene la contraseña de gestor.
     * 
     * @return La contraseña de gestor.
     */
    public String getContraseniaGestor() {
        return contraseniaGestor;
    }

    /**
     * Asigna una nueva contraseña para el gestor.
     * 
     * @param contraseniaGestor La nueva contraseña a establecer.
     */
    public void setContraseniaGestor(String contraseniaGestor) {
        this.contraseniaGestor = contraseniaGestor;
    }

    /**
     * Devuelve el valor de la sanción actual.
     * 
     * @return El valor de la sanción.
     */
    public Integer getSancion() {
        return sancion;
    }

    /**
     * Establece el valor de la sanción.
     * 
     * @param sancion El nuevo valor de la sanción a asignar.
     */
    public void setSancion(Integer sancion) {
        this.sancion = sancion;
    }

    /**
     * Retorna el conjunto de salas asociadas a la entidad.
     * 
     * @return Un conjunto de salas.
     */
    public Set<Sala> getSalas() {
        return salas;
    }

    /**
     * Asigna un nuevo conjunto de salas a la entidad.
     * 
     * @param salas El conjunto de salas a asignar.
     */
    public void setSalas(Set<Sala> salas) {
        this.salas = salas;
    }

    /**
     * Añade una sala a un centro de exposiciones.
     * 
     * @param sala la sala a añadir
     */
    public void addSala(Sala sala) {
        this.salas.add(sala);
    }

    /**
     * Elimina una sala de un centro de exposiciones.
     * 
     * @param sala la sala a eliminar
     */
    public void removeSala(Sala sala) {
        this.salas.remove(sala);
    }

    /**
     * Obtiene las exposiciones totales en el centro.
     * 
     * @return un conjunto de las exposiciones totales
     */
    public Set<Exposicion> getExposiciones() {
        return exposiciones;
    }

    /**
     * Obtiene las exposiciones disponibles en el centro por un rango de fechas.
     *
     * @param fechaInicio la fecha de inicio
     * @param fechaFinal  la fecha de fin
     * @return un conjunto de exposiciones disponibles en el rango de fechas dado
     */
    public Set<Exposicion> getExposicionesPorFecha(LocalDate fechaInicio, LocalDate fechaFinal) {
        Set<Exposicion> exposicionesPorFecha = new HashSet<>();
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getFechaInicio().isAfter(fechaInicio) && exposicion.getFechaFin().isBefore(fechaFinal)
                    && (exposicion.getEstado().equals(EstadoExposicion.PUBLICADA)
                    || exposicion.getEstado().equals(EstadoExposicion.PRORROGADA))) {
                exposicionesPorFecha.add(exposicion);
            }
        }
        return exposicionesPorFecha;
    }

    /**
     * Obtiene las exposiciones temporales del centro.
     * 
     * @return un conjunto de las exposiciones de tipo temporal
     */
    public Set<Exposicion> getExposicionesTemporales() {
        Set<Exposicion> exposicionesTemporales = new HashSet<>();
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getTipo().equals(TipoExpo.TEMPORAL)
                    && (exposicion.getEstado().equals(EstadoExposicion.PUBLICADA)
                            || exposicion.getEstado().equals(EstadoExposicion.PRORROGADA))) {
                exposicionesTemporales.add(exposicion);
            }
        }
        return exposicionesTemporales;
    }

    /**
     * Obtiene las exposiciones permanentes del centro.
     * 
     * @return un conjunto de las exposiciones de tipo permanente
     */
    public Set<Exposicion> getExposicionesPermanentes() {
        Set<Exposicion> exposicionesPermanentes = new HashSet<>();
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getTipo().equals(TipoExpo.PERMANENTE)
                    && (exposicion.getEstado().equals(EstadoExposicion.PUBLICADA)
                            || exposicion.getEstado().equals(EstadoExposicion.PRORROGADA))) {
                exposicionesPermanentes.add(exposicion);
            }
        }
        return exposicionesPermanentes;
    }

    public Set<Exposicion> getExposicionesPorTipoObra(Class<? extends Obra> tipoObra) {
        Set<Exposicion> exposicionesPorTipoObra = new HashSet<>();
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getEstado().equals(EstadoExposicion.PUBLICADA)
                    || exposicion.getEstado().equals(EstadoExposicion.PRORROGADA)) {
                for (SalaExposicion salaExpo : exposicion.getSalas()) {
                    for (Obra obra : salaExpo.getObras()) {
                        if (tipoObra.isInstance(obra)) {
                            exposicionesPorTipoObra.add(exposicion);
                            break;
                        }
                    }
                }
            }
        }
        return exposicionesPorTipoObra;
    }

    /**
     * Añade una exposicion a un centro de exposiciones.
     * 
     * @param exposicion la sala a añadir
     */
    public void addExposicion(Exposicion exposicion) {
        this.exposiciones.add(exposicion);
    }

    /**
     * Elimina una exposicion determinada de un centro de exposiciones.
     * 
     * @param exposicion la sala a eliminar
     */
    public void removeExposicion(Exposicion exposicion) {
        this.exposiciones.remove(exposicion);
    }

    /**
     * Elimina todas las exposiciones de un centro de exposiciones.
     */
    public void removeAllExposiciones() {
        this.exposiciones.clear();
    }

    public Set<Sorteo> getSorteos() {
        return sorteos;
    }

    public void setSorteos(Set<Sorteo> sorteos) {
        this.sorteos = sorteos;
    }

    /**
     * Añade un sorteo determinado a un centro de exposiciones.
     * 
     * @param sorteo el sorteo a añadir
     */
    public void addSorteo(Sorteo sorteo) {
        this.sorteos.add(sorteo);
    }

    /**
     * Elimina un sorteo determinado de un centro de exposiciones.
     * 
     * @param sorteo el sorteo a eliminar
     */
    public void removeSorteo(Sorteo sorteo) {
        this.sorteos.remove(sorteo);
    }

    /**
     * Elimina todos los sorteos de un centro de exposiciones.
     */
    public void removeAllSorteos() {
        this.sorteos.clear();
    }

    public Set<Obra> getObras() {
        return obras;
    }

    public void setObras(Set<Obra> obras) {
        this.obras = obras;
    }

    /**
     * Añade una obra determinada a un centro de exposiciones.
     * 
     * @param obra la obra a añadir
     */
    public void addObra(Obra obra) {
        this.obras.add(obra);
    }

    /**
     * Elimina una obra determinada de un centro de exposiciones.
     * 
     * @param obra la obra a eliminar
     */
    public void removeObra(Obra obra) {
        this.obras.remove(obra);
    }

    /**
     * Elimina todas las obras de un centro de exposiciones.
     */
    public void removeAllObras() {
        this.obras.clear();
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * Añade un empleado determinado a un centro de exposiciones.
     * 
     * @param empleado el empleado a añadir
     */
    public void addEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

    /**
     * Elimina un empleado determinado de un centro de exposiciones.
     * 
     * @param empleado el empleado a eliminar
     */
    public void removeEmpleado(Empleado empleado) {
        this.empleados.remove(empleado);
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public Set<Descuento> getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(Set<Descuento> descuentos) {
        this.descuentos = descuentos;
    }

    /**
     * Añade un descuento determinado a un centro de exposiciones.
     * 
     * @param descuento el descuento a añadir
     */
    public void addDescuento(Descuento descuento) {
        this.descuentos.add(descuento);
    }

    /**
     * Elimina un descuento determinado de un centro de exposiciones.
     * 
     * @param empleado el empleado a eliminar
     */
    public void removeDescuento(Descuento descuento) {
        this.descuentos.remove(descuento);
    }

    /**
     * Elimina todos los desceuntos de un centro de exposiciones.
     */
    public void removeAllDescuentos() {
        this.descuentos.clear();
    }

    public Boolean loginEmpleado(String NIF, String numSS, String contrasenia) {
        for (Empleado e: empleados) {
            if (e.getNIF().equals(NIF) && e.getNumSS().equals(numSS) && contrasenia.equals(contraseniaEmpleado)) {
                e.logIn();
                return true;
            }
        }
        return false;
    }

    public Boolean loginGestor(String NIF, String contrasenia) {
        if (gestor.getNIF().equals(NIF) && contrasenia.equals(contraseniaGestor)) {
            gestor.logIn();
            return true;
        }
        return false;
    }

    /**
     * Crea una cadena que representa un centro de exposición.
     * 
     * @return La cadena de representación del centro de exposición
     */
    public String toString() {
        return "CentroExposicion [ID=" + ID + ", nombre=" + nombre + ", horaApertura=" + horaApertura + ", horaCierre="
                + horaCierre + ", localizacion=" + localizacion + ", contraseniaEmpleado=" + contraseniaEmpleado
                + ", contraseniaGestor=" + contraseniaGestor + ", sancion=" + sancion + ", salas="
                + salas.toString() + ", exposiciones=" + exposiciones.toString() + ", sorteos=" + sorteos + ", obras="
                + obras
                + ", empleados=" + empleados.toString() + ", gestor=" + gestor + ", descuentos=" + descuentos + "]";
    }

}

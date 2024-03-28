package CentroExposicion;

import java.time.LocalTime;
import Sala.SalaCompuesta;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Exposicion.EstadoExposicion;
import Exposicion.Exposicion;
import Exposicion.TipoExpo;
import Obra.Obra; 

public class CentroExposicion {
    private Integer ID;
    private String nombre;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private String localizacion;
    private String contraseniaEmpleado;
    private String contraseniaGestor;
    private Integer sancion;
    private Set<SalaCompuesta> salaCompuesta;
    private Set<Exposicion> exposiciones;
    private Set<Sorteo> sorteos;
    private Set<Obra> obras;
    private Set<Empleado> empleados;
    private Gestor gestor;
    private Set<Descuento> descuentos;

    public CentroExposicion(Integer iD, String nombre, LocalTime horaApertura, LocalTime horaCierre, String localizacion,
            String contraseniaEmpleado, String contraseniaGestor, Integer sancion, Set<SalaCompuesta> salaCompuesta,
            Set<Empleado> empleados, Gestor gestor) {
        ID = iD;
        this.salaCompuesta = salaCompuesta;
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.localizacion = localizacion;
        this.contraseniaEmpleado = contraseniaEmpleado;
        this.contraseniaGestor = contraseniaGestor;
        this.sancion = sancion;
        this.empleados = empleados;
        this.gestor = gestor;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getContraseniaEmpleado() {
        return contraseniaEmpleado;
    }

    public void setContraseniaEmpleado(String contraseniaEmpleado) {
        this.contraseniaEmpleado = contraseniaEmpleado;
    }

    public String getContraseniaGestor() {
        return contraseniaGestor;
    }

    public void setContraseniaGestor(String contraseniaGestor) {
        this.contraseniaGestor = contraseniaGestor;
    }

    public Integer getSancion() {
        return sancion;
    }

    public void setSancion(Integer sancion) {
        this.sancion = sancion;
    }

    public Set<SalaCompuesta> getSalaCompuesta() {
        return salaCompuesta;
    }

    public void setSalaCompuesta(Set<SalaCompuesta> salaCompuesta) {
        this.salaCompuesta = salaCompuesta;
    }

    public void addSalaCompuesta(SalaCompuesta salaCompuesta) {
        this.salaCompuesta.add(salaCompuesta);
    }
     
    public void removeSalaCompuesta(SalaCompuesta salaCompuesta) {
        this.salaCompuesta.remove(salaCompuesta);
    }

    public Set<Exposicion> getExposiciones() {
        return exposiciones;
    }

    public Set<Exposicion> getExposicionesPorFecha(Date fechaInicio, Date fechaFinal) {
        Set<Exposicion> exposicionesPorFecha = new HashSet<>();
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getFechaInicio().after(fechaInicio) && exposicion.getFechaFin().before(fechaFinal)) {
                exposicionesPorFecha.add(exposicion);
            }
        }
        return exposicionesPorFecha;
    }

    public Set<Exposicion> getExposicionesTemporales() {
        Set<Exposicion> exposicionesTemporales = new HashSet<>();
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getTipo().equals(TipoExpo.TEMPORAL)) {
                exposicionesTemporales.add(exposicion);
            }
        }
        return exposicionesTemporales;
    }

    public Set<Exposicion> getExposicionesPermanentes() {
        Set<Exposicion> exposicionesPermanentes = new HashSet<>();
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getTipo().equals(TipoExpo.PERMANENTE)) {
                exposicionesPermanentes.add(exposicion);
            }
        }
        return exposicionesPermanentes;
    }

    public Set<Exposicion> getExposicionesPublicadas() {
        Set<Exposicion> exposicionesPublicadas = new HashSet<>();
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getEstado().equals(EstadoExposicion.PUBLICADA)) {
                exposicionesPublicadas.add(exposicion);
            }
        }
        return exposicionesPublicadas;
    }

    public void setExposiciones(Set<Exposicion> exposiciones) {
        this.exposiciones = exposiciones;
    }

    public void addExposicion(Exposicion exposicion) {
        this.exposiciones.add(exposicion);
    }

    public void removeExposicion(Exposicion exposicion) {
        this.exposiciones.remove(exposicion);
    }   

    public void removeAllExposiciones() {
        this.exposiciones.clear();
    }

    public Set<Sorteo> getSorteos() {
        return sorteos;
    }

    public void setSorteos(Set<Sorteo> sorteos) {
        this.sorteos = sorteos;
    } 

    public void addSorteo(Sorteo sorteo) {
        this.sorteos.add(sorteo);
    }

    public void removeSorteo(Sorteo sorteo) {
        this.sorteos.remove(sorteo);
    }

    public void removeAllSorteos() {
        this.sorteos.clear();
    }

    public Set<Obra> getObras() {
        return obras;
    }

    public void setObras(Set<Obra> obras) {
        this.obras = obras;
    }

    public void addObra(Obra obra) {
        this.obras.add(obra);
    } 

    public void removeObra(Obra obra) {
        this.obras.remove(obra);
    }

    public void removeAllObras() {
        this.obras.clear();
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    } 

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void addEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

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

    public void addDescuento(Descuento descuento) {
        this.descuentos.add(descuento);
    }

    public void removeDescuento(Descuento descuento) {
        this.descuentos.remove(descuento);
    }   

    public void removeAllDescuentos() {
        this.descuentos.clear();
    }

}

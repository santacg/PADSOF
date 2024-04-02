package CentroExposicion;

import Usuario.Usuario;

/**
 * Clase Empleado.
 * Representa un empleado dentro del sistema de gestión de usuarios.
 * Esta clase extiende de {@link Usuario}, heredando sus atributos y métodos.
 * Proporciona características específicas de un empleado, como su nombre,
 * número de Seguridad Social (numSS), número de cuenta bancaria, permisos para
 * realizar ventas, controlar el sistema, y enviar mensajes, además de su
 * dirección.
 *
 * @author Carlos García Santa, Joaquín Abad Díaz y Eduardo Junoy Ortega
 *
 */
public class Empleado extends Usuario {
    private String nombre;
    private String numSS;
    private String numCuenta;
    private Boolean permisoVenta;
    private Boolean permisoControl;
    private Boolean permisoMensajes;
    private String direccion;

    /**
     * Construye una instancia de Empleado con todos los detalles necesarios.
     *
     * @param NIF             El Número de Identificación Fiscal del empleado
     * @param nombre          El nombre del empleado
     * @param numSS           El número de Seguridad Social del empleado
     * @param numCuenta       El número de cuenta bancaria del empleado
     * @param permisoVenta    Verdadero si el empleado tiene permiso para ventas
     * @param permisoControl  Verdadero si el empleado tiene permiso para controlar
     * @param permisoMensajes Verdadero si el empleado puede enviar mensajes
     * @param direccion       La dirección del empleado
     */
    public Empleado(String NIF, String nombre, String numSS, String numCuenta, Boolean permisoVenta,
            Boolean permisoControl, Boolean permisoMensajes, String direccion) {
        super(NIF);
        this.nombre = nombre;
        this.numSS = numSS;
        this.numCuenta = numCuenta;
        this.permisoVenta = permisoVenta;
        this.permisoControl = permisoControl;
        this.permisoMensajes = permisoMensajes;
        this.direccion = direccion;
    }

    /**
     * Getters y setters que facilitan la gestión de un centro de exposicion.
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumSS() {
        return numSS;
    }

    public void setNumSS(String numSS) {
        this.numSS = numSS;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Boolean getPermisoVenta() {
        return permisoVenta;
    }

    public void setPermisoVenta(Boolean permisoVenta) {
        this.permisoVenta = permisoVenta;
    }

    public Boolean getPermisoControl() {
        return permisoControl;
    }

    public void setPermisoControl(Boolean permisoControl) {
        this.permisoControl = permisoControl;
    }

    public Boolean getPermisoMensajes() {
        return permisoMensajes;
    }

    public void setPermisoMensajes(Boolean permisoMensajes) {
        this.permisoMensajes = permisoMensajes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve una representación en cadena de la información del empleado.
     *
     * @return Cadena de texto que representa al empleado con todos sus detalles.
     */
    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", numSS=" + numSS + ", numCuenta=" + numCuenta + ", permisoVenta="
                + permisoVenta + ", permisoControl=" + permisoControl + ", permisoMensajes=" + permisoMensajes
                + ", direccion=" + direccion + "]";
    }

}

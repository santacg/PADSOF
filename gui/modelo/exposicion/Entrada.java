package gui.modelo.exposicion;

import java.io.Serializable;
import java.time.LocalDate;

import gui.modelo.expofy.ClienteRegistrado;
import gui.modelo.tarjetaDeCredito.TarjetaDeCredito;

/**
 * Clase Entrada.
 * Esta clase representa una entrada adquirida por un cliente en el sistema
 * Expofy. Cada entrada está vinculada a un cliente registrado y puede estar
 * asociada a una tarjeta de crédito utilizada para la compra.
 *
 * @author Carlos García Santa, Joaquín Abad Díaz y Eduardo Junoy Ortega
 *
 */
public class Entrada implements Serializable {
    private Integer IDEntrada;
    private static Integer IDcount = 0;
    private LocalDate fechaDeCompra;
    private ClienteRegistrado clienteRegistrado = null;
    private TarjetaDeCredito tarjetaDeCredito = null;

    /**
     * Constructor para crear una entrada con un identificador específico.
     * 
     * @param cliente cliente asociado a la entrada.
     * @param tarjeta tarjeta asociado a la entrada.
     */
    public Entrada(ClienteRegistrado cliente, TarjetaDeCredito tarjeta) {
        this.IDEntrada = IDcount++;
        this.fechaDeCompra = LocalDate.now();
        this.clienteRegistrado = cliente;
        this.tarjetaDeCredito = tarjeta;
    }

    /**
     * Retorna el ID de la entrada.
     * 
     * @return ID de la entrada.
     */
    public Integer getIDEntrada() {
        return IDEntrada;
    }

    /**
     * Obtiene la fecha de compra de la entrada.
     * @return Fecha de compra de la entrada.
     */
    public LocalDate getFechaDeCompra() {
        return this.fechaDeCompra;
    }

    /**
     * Obtiene la tarjeta de crédito asociada.
     * 
     * @return Tarjeta de crédito asociada.
     */
    public TarjetaDeCredito getTarjetaDeCredito() {
        return this.tarjetaDeCredito;
    }


    /**
     * Obtiene el cliente registrado.
     * 
     * @return Cliente registrado.
     */
    public ClienteRegistrado getClienteRegistrado() {
        return this.clienteRegistrado;
    }

 
    /**
     * Realiza el codigo hash de entrada.
     * 
     * @return Codigo hash de la entrada.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((IDEntrada == null) ? 0 : IDEntrada.hashCode());
        return result;
    }

    /**
     * Comprueba si esta entrada es igual al objeto proporcionado.
     * Dos entradas se consideran iguales si tienen el mismo ID.
     * 
     * @param obj El objeto con el que comparar esta {@code Entrada}.
     * 
     * @return {@code true} si los objetos son iguales, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entrada other = (Entrada) obj;
        if (IDEntrada == null) {
            if (other.IDEntrada != null)
                return false;
        } else if (!IDEntrada.equals(other.IDEntrada))
            return false;
        return true;
    }

    /**
     * Devuelve una representación de la entrada en forma de cadena.
     * 
     * @return Cadena que representa la entrada.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Detalles entrada:\n");
        sb.append("ID Entrada: ").append(IDEntrada).append("\n");
        sb.append("Cliente Registrado: ").append(clienteRegistrado).append("\n");
        sb.append("Tarjeta de Crédito: ").append(tarjetaDeCredito).append("\n");

        return sb.toString();
    }

}

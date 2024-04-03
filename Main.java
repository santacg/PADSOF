import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import CentroExposicion.*;
import Entrada.Entrada;
import Expofy.*;
import Exposicion.*;
import Inscripcion.Inscripcion;
import Obra.*;
import Sala.*;
import TarjetaDeCredito.TarjetaDeCredito;
import Usuario.Usuario;
import Utils.LectorCSVObras;

/**
 * Clase MainTest.
 * Clase principal para demostrar la funcionalidad del sistema Expofy.
 * En este ejemplo, se instancian componentes principales del sistema como
 * centros de exposición, empleados, gestores, y salas.
 * Se configuran clientes y notificaciones, se configuran y se añaden
 * exposiciones a un centro, y se demuestra la carga de obras desde un archivo
 * CSV a una sala de exposición específica.
 * 
 * @author Carlos García Santa, Joaquín Abad Díaz y Eduardo Junoy Ortega
 */
public class Main {
      public static void main(String[] args) {
            // Instanciamos el sistema
            Expofy expofy = Expofy.getInstance();

            // Instanciamos varios atributos que componen el sistema

            // Instanciación de centroExposición y sus atributos
            // Centro1

            // Empleados
            Empleado empleado1 = new Empleado("12345", "Jesus", "789", "456", true, true, true, "Mordor");
            Empleado empleado2 = new Empleado("789456", "Miguel", "456", "789", false, false, false, "Rivendell");

            // Gestor
            Gestor gestor = new Gestor("456123");

            // Salas
            Set<Sala> salas = new HashSet<>();
            Sala sala1 = new Sala("Sala1", 100, 50, 25, true, 10, 15.0, 20.0);
            sala1.addSubsala(5.0, 7.0, 2, 20);
            salas.add(sala1);

            Sala sala2 = new Sala("Sala2", 100, 50, 25, true, 10, 15.0, 20.0);
            salas.add(sala2);

            // Centro
            CentroExposicion centroExposicion = new CentroExposicion("Centro1", LocalTime.of(10, 0, 0),
                        LocalTime.of(21, 0, 0), "Madrid",
                        "123", "456", gestor, salas);
            centroExposicion.addEmpleado(empleado1);
            centroExposicion.addEmpleado(empleado2);
            expofy.addCentroExposicion(centroExposicion);

            // Clientes
            expofy.registrarCliente("123456789", "123", false);
            expofy.loginCliente("123456879", "123");

            // Notificaciones
            // Enviamos una notificación a todos los usuarios
            expofy.enviarNotificacionAll("Bienvenidos a expofy");

            // Configuramos exposiciones
            Set<SalaExposicion> salasExposicion1 = new HashSet<>();
            Set<SalaExposicion> salasExposicion2 = new HashSet<>();

            SalaExposicion salaExposicion1 = new SalaExposicion(sala1);
            SalaExposicion salaExposicion2 = new SalaExposicion(sala2);
            salasExposicion1.add(salaExposicion1);
            salasExposicion2.add(salaExposicion2);
            Exposicion exposicion1 = new Exposicion("Expo1", LocalDate.of(2021, 1, 1), LocalDate.of(2022, 1, 1),
                        "Expo1", salasExposicion1, TipoExpo.PERMANENTE, 21.0);
            Exposicion exposicion2 = new Exposicion("Expo2", LocalDate.of(2023, 2, 2), LocalDate.of(2024, 2, 2),
                        "Expo2", salasExposicion2, TipoExpo.TEMPORAL, 22.0);

            // Añadimos obras a una de las exposiciones
            Cuadro cuadro = new Cuadro(
                        "El Guernica",
                        1937,
                        "Una pintura de Picasso",
                        false,
                        2000000.0,
                        "123456789",
                        349.3,
                        776.6,
                        25,
                        15,
                        60,
                        40,
                        "Óleo");
            salaExposicion1.addObra(cuadro);

            // Leemos obras de un archivo y lo añadimos a una sala de una de las
            // exposiciones
            LectorCSVObras.leerObras(salaExposicion2);

            // Añadimos las exposiciones al centro
            centroExposicion.addExposicion(exposicion1);
            centroExposicion.addExposicion(exposicion2);

            System.out.println(expofy.toString());
      }
}
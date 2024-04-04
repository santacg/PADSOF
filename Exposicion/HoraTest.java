package Exposicion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Entrada.Entrada;

public class HoraTest {
    private Hora hora;
    private Entrada entrada1;
    private Entrada entrada2;

    @BeforeEach
    public void setUp() {
        LocalDate fecha = LocalDate.of(2022, 1, 1);
        LocalTime horaInicio = LocalTime.of(10, 0);
        LocalTime horaFin = LocalTime.of(12, 0);
        Integer nEntradas = 10;
        Double precio = 10.0;
        hora = new Hora(fecha, horaInicio, horaFin, nEntradas, precio);
        entrada1 = new Entrada("Entrada 1", precio);
        entrada2 = new Entrada("Entrada 2", precio);
    }

    @Test
    public void testGetEntradas() {
        Set<Entrada> entradas = new HashSet<>();
        entradas.add(entrada1);
        entradas.add(entrada2);
        hora.addEntrada(entrada1);
        hora.addEntrada(entrada2);
        assertEquals(entradas, hora.getEntradas());
    }

    @Test
    public void testAddEntrada() {
        hora.addEntrada(entrada1);
        assertTrue(hora.getEntradas().contains(entrada1));
        assertEquals(9, hora.getCountEntradas());
    }

    @Test
    public void testAddEntrada_MaximumReached() {
        for (int i = 0; i < 10; i++) {
            hora.addEntrada(new Entrada("Entrada " + (i + 1), 10.0));
        }
        hora.addEntrada(new Entrada("Entrada 11", 10.0));
        assertFalse(hora.getEntradas().contains(new Entrada("Entrada 11", 10.0)));
        assertEquals(0, hora.getCountEntradas());
    }

    @Test
    public void testRemoveEntrada() {
        hora.addEntrada(entrada1);
        hora.removeEntrada(entrada1);
        assertFalse(hora.getEntradas().contains(entrada1));
        assertEquals(10, hora.getCountEntradas());
    }

    @Test
    public void testRemoveAllEntradas() {
        hora.addEntrada(entrada1);
        hora.addEntrada(entrada2);
        hora.removeAllEntradas();
        assertTrue(hora.getEntradas().isEmpty());
        assertEquals(10, hora.getCountEntradas());
    }

    @Test
    public void testGetFecha() {
        LocalDate expected = LocalDate.of(2022, 1, 1);
        assertEquals(expected, hora.getFecha());
    }

    @Test
    public void testSetFecha() {
        LocalDate newFecha = LocalDate.of(2022, 2, 1);
        hora.setFecha(newFecha);
        assertEquals(newFecha, hora.getFecha());
    }

    @Test
    public void testGetHoraInicio() {
        LocalTime expected = LocalTime.of(10, 0);
        assertEquals(expected, hora.getHoraInicio());
    }

    @Test
    public void testSetHoraInicio() {
        LocalTime newHoraInicio = LocalTime.of(11, 0);
        hora.setHoraInicio(newHoraInicio);
        assertEquals(newHoraInicio, hora.getHoraInicio());
    }

    @Test
    public void testGetHoraFin() {
        LocalTime expected = LocalTime.of(12, 0);
        assertEquals(expected, hora.getHoraFin());
    }

    @Test
    public void testSetHoraFin() {
        LocalTime newHoraFin = LocalTime.of(13, 0);
        hora.setHoraFin(newHoraFin);
        assertEquals(newHoraFin, hora.getHoraFin());
    }

    @Test
    public void testGetCountEntradas() {
        assertEquals(10, hora.getCountEntradas());
    }

    @Test
    public void testGetnEntradas() {
        assertEquals(10, hora.getnEntradas());
    }

    @Test
    public void testEntradaVendida() {
        hora.entradaVendida();
        assertEquals(9, hora.getCountEntradas());
    }

    @Test
    public void testGetnEntradasDisp() {
        assertEquals(10, hora.getnEntradasDisp());
    }

    @Test
    public void testToString() {
        String expected = "Hora Details:\n" +
                          "Fecha: 2022-01-01\n" +
                          "Hora de Inicio: 10:00\n" +
                          "Hora de Fin: 12:00\n" +
                          "Número de Entradas: 10\n";
        assertEquals(expected, hora.toString());
    }

    @Test
    public void testEquals_SameObject() {
        assertTrue(hora.equals(hora));
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(hora.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(hora.equals("Hora"));
    }

    @Test
    public void testEquals_DifferentFecha() {
        Hora other = new Hora(LocalDate.of(2022, 2, 1), LocalTime.of(10, 0), LocalTime.of(12, 0), 10, 10.0);
        assertFalse(hora.equals(other));
    }

    @Test
    public void testEquals_DifferentHoraInicio() {
        Hora other = new Hora(LocalDate.of(2022, 1, 1), LocalTime.of(11, 0), LocalTime.of(12, 0), 10, 10.0);
        assertFalse(hora.equals(other));
    }

    @Test
    public void testEquals_DifferentHoraFin() {
        Hora other = new Hora(LocalDate.of(2022, 1, 1), LocalTime.of(10, 0), LocalTime.of(13, 0), 10, 10.0);
        assertFalse(hora.equals(other));
    }

    @Test
    public void testEquals_SameAttributes() {
        Hora other = new Hora(LocalDate.of(2022, 1, 1), LocalTime.of(10, 0), LocalTime.of(12, 0), 10, 10.0);
        assertTrue(hora.equals(other));
    }
}
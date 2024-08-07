package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.modelo.centroExposicion.SorteoFechas;
import gui.modelo.exposicion.*;

public class SorteoFechasTest {
    private SorteoFechas sorteo;
    private Exposicion exposicion;

    @BeforeEach
    public void setUp() {
        exposicion = new Exposicion("Exposicion 1", LocalDate.now(), LocalDate.now().plusDays(7), "Descripción", TipoExpo.PERMANENTE, 10.0);
        LocalDate fechaSorteo = LocalDate.now();
        LocalDate fechaInicio = LocalDate.of(2022, 1, 1);
        LocalDate fechaFin = LocalDate.of(2022, 12, 31);
        sorteo = new SorteoFechas(exposicion, fechaSorteo, 2, fechaInicio, fechaFin);
    }

    @Test
    public void testGetFechaInicio() {
        LocalDate expected = LocalDate.of(2022, 1, 1);
        assertEquals(expected, sorteo.getFechaInicio());
    }

    @Test
    public void testSetFechaInicio() {
        LocalDate newFechaInicio = LocalDate.of(2023, 1, 1);
        sorteo.setFechaInicio(newFechaInicio);
        assertEquals(newFechaInicio, sorteo.getFechaInicio());
    }

    @Test
    public void testGetFechaFin() {
        LocalDate expected = LocalDate.of(2022, 12, 31);
        assertEquals(expected, sorteo.getFechaFin());
    }

    @Test
    public void testSetFechaFin() {
        LocalDate newFechaFin = LocalDate.of(2023, 12, 31);
        sorteo.setFechaFin(newFechaFin);
        assertEquals(newFechaFin, sorteo.getFechaFin());
    }

    @Test
    public void testGetFechaLimite() {
        LocalDate expected = LocalDate.of(2022, 12, 31);
        assertEquals(expected, sorteo.getFechaLimite());
    }

    @Test
    public void testGetFechaSorteo() {
        LocalDate expected = LocalDate.now();
        assertEquals(expected, sorteo.getFechaSorteo());
    }

    @Test
    public void testGetN_entradas() {
        assertEquals(2, sorteo.getN_entradas());
    }

    @Test
    public void testGetExposicion() {
        assertEquals(exposicion, sorteo.getExposicion());
    }
    
}
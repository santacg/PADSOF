package Obra;

import java.util.Set;

public class Fotografia extends ObraNoDigital{
    private Boolean color;

    public Fotografia(String id, String nombre, Integer anio, String descripcion, boolean externa, Double cuantiaSeguro,
            Double alto, Double ancho, Double temperaturaMaxima, Double temperaturaMinima, Double humedadMaxima,
            Double humedadMinima, String numeroSeguro, Boolean color, Estado estado, Set<Autor> autores) {
        super(id, nombre, anio, descripcion, externa, cuantiaSeguro, alto, ancho, temperaturaMaxima, temperaturaMinima,
                humedadMaxima, humedadMinima, numeroSeguro, estado, autores);

        this.color = color;
    }

    public Boolean getColor() {
        return this.color;
    }

    public void setColor(Boolean color) {
        this.color = color;
    }

} 

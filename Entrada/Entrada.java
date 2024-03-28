package Entrada;

import TarjetaDeCredito.TarjetaDeCredito;

public class Entrada {
    private Integer nEntrada;
    private TarjetaDeCredito tarjetaDeCredito;
   
    public Entrada(Integer nEntrada, TarjetaDeCredito tarjetaDeCredito) {
        this.nEntrada = nEntrada;
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public Integer getNEntrada() {
        return nEntrada;
    }

    public void setNEntrada(Integer nEntrada) {
        this.nEntrada = nEntrada;
    }

    public TarjetaDeCredito getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    public void setTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }
}

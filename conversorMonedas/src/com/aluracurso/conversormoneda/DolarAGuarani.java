package com.aluracurso.conversormoneda;

public class DolarAGuarani extends Conversion {
    public DolarAGuarani(double tasaCambio) {
        super(tasaCambio);
    }

    @Override
    public double convertir(double cantidad) {
        return cantidad * tasaCambio;
    }
}
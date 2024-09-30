package com.aluracurso.conversormoneda;

class GuaraniADolar extends Conversion {
    public GuaraniADolar(double tasaCambio) {
        super(tasaCambio);
    }

    @Override
    public double convertir(double cantidad) {
        return cantidad / tasaCambio;
    }
}
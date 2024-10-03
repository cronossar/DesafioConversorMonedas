package com.aluracurso.conversormoneda;

class PesoArgentinoADolar extends Conversion {
    public PesoArgentinoADolar(double tasaCambio) {
        super(tasaCambio);
    }

    @Override
    public double convertir(double cantidad) {
        return cantidad / tasaCambio;
    }
}
// Ejemplo para Real a Dólar
class RealADolar extends Conversion {
    public RealADolar(double tasaCambio) {
        super(tasaCambio);
    }

    @Override
    public double convertir(double cantidad) {
        return cantidad / tasaCambio;
    }
}
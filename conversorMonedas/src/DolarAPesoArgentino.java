// Conversor Dólar a Peso Argentino
class DolarAPesoArgentino extends Conversion {
    public DolarAPesoArgentino(double tasaCambio) {
        super(tasaCambio);
    }

    @Override
    public double convertir(double cantidad) {
        return cantidad * tasaCambio;
    }
}
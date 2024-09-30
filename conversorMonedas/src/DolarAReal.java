public class DolarAReal extends Conversion {
    public DolarAReal(double tasaCambio) {
        super(tasaCambio);
    }

    @Override
    public double convertir(double cantidad) {
        return cantidad * tasaCambio;
    }
}
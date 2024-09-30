
    // Clase base
    abstract class Conversion implements Conversor {
        protected double tasaCambio;

        public Conversion(double tasaCambio) {
            this.tasaCambio = tasaCambio;
        }
    }



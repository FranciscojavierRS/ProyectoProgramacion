package PSP_TEMA2_BOL3;

public class PrincipalCajero {

    // Hilo para ingresos
    static class HiloIngresos extends Thread {
        private Cuenta cuenta;

        public HiloIngresos(Cuenta cuenta) {
            this.cuenta = cuenta;
        }

        @Override
        public void run() {
            for (int i = 0; i < 2; i++) { // 2 ingresos
                int aleatorio = (int) (Math.random() * 500 + 1);
                cuenta.ingresarDinero(aleatorio);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Hilo para retiradas
    static class HiloReintegros extends Thread {
        private Cuenta cuenta;

        public HiloReintegros(Cuenta cuenta) {
            this.cuenta = cuenta;
        }

        @Override
        public void run() {
            for (int i = 0; i < 2; i++) { // 2 retiradas
                int aleatorio = (int) (Math.random() * 500 + 1);
                cuenta.retirarDinero(aleatorio);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // MAIN
    public static void main(String[] args) {

        double saldoInicial = 1000;
        double maximo = 2000;

        Cuenta cuenta = new Cuenta(saldoInicial, maximo);

        Thread hiloIngresos = new HiloIngresos(cuenta);
        Thread hiloReintegros = new HiloReintegros(cuenta);

        hiloIngresos.start();
        hiloReintegros.start();

        try {
            hiloIngresos.join();
            hiloReintegros.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Operaciones finalizadas. Saldo final: " + cuenta.getSaldo());
    }
}


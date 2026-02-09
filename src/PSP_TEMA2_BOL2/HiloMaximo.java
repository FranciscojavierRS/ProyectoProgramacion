package PSP_TEMA2_BOL2;

public class HiloMaximo extends Thread {

    private int[] array;
    private int inicio;
    private int fin;
    private int maximo;

    public HiloMaximo(int[] array, int inicio, int fin) {
        this.array = array;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        maximo = array[inicio];

        for (int i = inicio + 1; i < fin; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
    }

    public int getMaximo() {
        return maximo;
    }
}


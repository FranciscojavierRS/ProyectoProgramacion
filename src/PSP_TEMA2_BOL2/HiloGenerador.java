package PSP_TEMA2_BOL2;

import java.util.Random;

public class HiloGenerador extends Thread {

    private int[] array;

    public HiloGenerador(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Random r = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(500) + 1;
            System.out.println(array[i]); 
            
        }
   
    
    }
}


package PSP_TEMA2_BOL4;

public class Profesor extends Thread {

    private String nombre;
    private Bienvenida saludo;

    public Profesor(String nombre, Bienvenida bienvenida) {
        this.nombre = nombre;
        this.saludo = bienvenida;
    }

    public void run() {
        System.out.println("El profesor " + nombre + " llegó");
        try {
            Thread.sleep(1000);
            saludo.llegadaProfesor(nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

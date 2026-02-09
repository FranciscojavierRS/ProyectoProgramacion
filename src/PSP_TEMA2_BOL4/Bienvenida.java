package PSP_TEMA2_BOL4;

public class Bienvenida {

    private boolean clase_comenzada = false;
    private int totalAlumnos;
    private int alumnosSaludados = 0;

    public Bienvenida(int totalAlumnos) {
        this.totalAlumnos = totalAlumnos;
    }

    public synchronized void saludarProfesor(String nombre) {
        try {
            while (!clase_comenzada) {
                wait();
            }

            System.out.println("El alumno saluda al profesor");
            alumnosSaludados++;

            System.out.println("Hola, soy " + nombre);

            if (alumnosSaludados == totalAlumnos) {
                System.out.println("Fin de los saludos");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void llegadaProfesor(String nombre) {
        System.out.println("Buenos días, soy " + nombre);
        clase_comenzada = true;
        notifyAll();
    }
}

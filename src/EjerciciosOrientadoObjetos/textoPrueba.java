package EjerciciosOrientadoObjetos;

public class textoPrueba {

    public static void main(String[] args) {

        texto t = new texto(20);  // Máximo de 20 caracteres
        //t.añadirFinal('F');
        t.añadirInicio("Francisco Javier");
        t.añadirInicio("¡¡");
        t.añadirFinal("!!!");
        
        System.out.println("Texto final: " + t.getTexto());
        System.out.println("Número de vocales: " + t.contarVocales());
    }
}

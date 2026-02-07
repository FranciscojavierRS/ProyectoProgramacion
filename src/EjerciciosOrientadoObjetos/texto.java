package EjerciciosOrientadoObjetos;

public class texto {

    private String cadena;
    private int longitudMaxima;

    // Constructor
    public texto(int longitudMaxima) {
        this.longitudMaxima = longitudMaxima;
        this.cadena = "";
    }

    // Añadir un carácter al final
    public boolean añadirFinal(char c) {
        if (cadena.length() < longitudMaxima) {
            cadena += c;
            return true;
        }
        return false;
    }

    // Añadir un carácter al principio
    public boolean añadirInicio(char c) {
        if (cadena.length() < longitudMaxima) {
            cadena = c + cadena;
            return true;
        }
        return false;
    }

    // Añadir cadena al final
    public boolean añadirFinal(String texto) {
        if (cadena.length() + texto.length() <= longitudMaxima) {
            cadena += texto;
            return true;
        }
        return false;
    }

    // Añadir cadena al principio
    public boolean añadirInicio(String texto) {
        if (cadena.length() + texto.length() <= longitudMaxima) {
            cadena = texto + cadena;
            return true;
        }
        return false;
    }

    // Contar vocales
    public int contarVocales() {
        int contador = 0;
        String vocales = "aeiouAEIOU";

        for (int i = 0; i < cadena.length(); i++) {
            if (vocales.indexOf(cadena.charAt(i)) != -1) {
                contador++;
            }
        }
        return contador;
    }

    // Getter del texto
    public String getTexto() {
        return cadena;
    }

    // Mostrar información del texto
    @Override
    public String toString() {
        return cadena;
    }
    
    
    
    
}

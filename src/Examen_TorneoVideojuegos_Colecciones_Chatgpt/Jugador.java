package Examen_TorneoVideojuegos_Colecciones_Chatgpt;

public class Jugador {

    private String nombre;
    private int edad;
    private String nick;

    public Jugador(String nombre, int edad, String nick) {
        this.nombre = nombre;
        this.edad = edad;
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugador)) return false;

        Jugador j = (Jugador) o;

        return nick.equals(j.nick);
    }

    @Override
    public int hashCode() {
        return nick.hashCode();
    }

    @Override
    public String toString() {
        return nick + " (" + nombre + ")";
    }
}

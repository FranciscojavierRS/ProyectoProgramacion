package Examen_TorneoVideojuegos_Colecciones_Chatgpt;

public class Partida {

    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo ganador;
    private String juego;

    public Partida(Equipo equipo1, Equipo equipo2, Equipo ganador, String juego) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ganador = ganador;
        this.juego = juego;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public Equipo getGanador() {
        return ganador;
    }

    public String getJuego() {
        return juego;
    }
}

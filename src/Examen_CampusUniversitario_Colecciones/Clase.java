package Examen_CampusUniversitario_Colecciones;

public class Clase {
    private Asignatura asignatura;
    private Profesor profesor;
    private Aula aula;
    private String diaSemana;
    private String hora;

    public Clase(Asignatura asignatura, Profesor profesor, Aula aula, String diaSemana, String hora) {
        this.asignatura = asignatura;
        this.profesor = profesor;
        this.aula = aula;
        this.diaSemana = diaSemana;
        this.hora = hora;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Aula getAula() {
        return aula;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return asignatura.getNombre() + " - " + profesor.getNombre() + 
               " - " + aula.getCodigo() + " (" + diaSemana + " " + hora + ")";
    }
}

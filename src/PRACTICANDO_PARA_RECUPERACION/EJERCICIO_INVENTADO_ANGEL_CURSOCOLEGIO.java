package PRACTICANDO_PARA_RECUPERACION;

import java.util.Arrays;
import java.util.Scanner;

public class EJERCICIO_INVENTADO_ANGEL_CURSOCOLEGIO {

	//Registrar asignatura, alumno y nota. Maximo 8 asignaturas y 20 alumnos
	
	//1-Insertar datos. Se pedira nombre de asignatura, nombre del alumno y la nota del alumno
	//2- Mostrar los datos registrados ordenados alfabeticamente por asignatura
	//3- Para una asignatura dada por teclado. Mostrar la nota media de la clase
	//4- Mostrar Alumnos que tengan que repetir.Un alumno tiene que repetir si tiene suspensa mas de 2 asinaturas
	private static final int MAXASIGNATURA = 8;
    private static final int MAXALUMNO = 20;
    private static float[][] notas = new float[MAXASIGNATURA][MAXALUMNO];
    private static int numalumno = 0;
    private static int numasignatura = 0;
    private static String[] nombreasignaturas = new String[MAXASIGNATURA];
    private static String[] nombrealumnos = new String[MAXALUMNO];
    

public static void main(String[] args) {
	inicializarDatos();
	Scanner sc = new Scanner(System.in);
    int opcion = 0;

    // Bucle principal para el menú interactivo
    while (opcion != 6) {
        System.out.println("1-Insertar datos. Se pedira nombre de asignatura, nombre del alumno y la nota del alumno"
        		+ "\n" + "2-Mostrar los datos registrados ordenados alfabeticamente por asignatura\n"
				+ "3-Para una asignatura dada por teclado. Mostrar la nota media de la clase\n"
				+ "4-Mostrar Alumnos que tengan que repetir.Un alumno tiene que repetir si tiene suspensa mas de 2 asinaturas\n"
				+ "5-Mostrar cuántos alumnos aprobaron y cuántos suspendieron en cada asignatura\n" + "6-Fin");

        opcion = sc.nextInt();
        switch (opcion) {
        case 1: 
          insertarDatos(sc);
            break;
        case 2: 
        	mostrarDatosAlfabeticamente();

            break;
        case 3: 
        notaMediaClase(sc);
            break;
        case 4: 
        mostrarAlumnosRepetir();
            break;
        case 5: 
           
            break;
        default:
            break; 
    }
    }
    
    sc.close();
	
}
private static void mostrarAlumnosRepetir() {
	for (int j = 0; j < numalumno; j++) {
		int suspensas= 0;
		for (int i = 0; i < numasignatura; i++) {
			if (5>notas[i][j]) {
				suspensas++;
			}
		}
		if (suspensas>2){
		System.out.println(nombrealumnos[j]);
		}
	}
	
}
private static void notaMediaClase(Scanner sc) { // 3-Para una asignatura dada por teclado. Mostrar la nota media de la clase
	System.out.println("Introduce una asignatura:");
    String asignatura = sc.next();
    int indice = indiceAsignatura(asignatura);
    
   
	float sumaNotas=0;
	int alumnoAsisnatura=0;
		for (int j=0; j<numalumno; j++) {
			if (-1!=notas[indice][j]) {
				sumaNotas=sumaNotas+notas[indice][j];
				alumnoAsisnatura++;
			}
		}
		System.out.println(asignatura +": "+sumaNotas/alumnoAsisnatura);
}
    
private static void mostrarDatosAlfabeticamente() { // 2-Mostrar los datos registrados ordenados alfabeticamente por asignatura
    String[] asignaturaOrdenados = getOrdenarArray(nombreasignaturas, numasignatura); // Ordenar ASIGNATURA
    for (int i = 0; i< numasignatura;i++) {
    	String asignatura = asignaturaOrdenados[i];
        int indice = indiceAsignatura(asignatura);
        System.out.println("ASIGNATURA " + asignatura);
        for (int j = 0; j < MAXALUMNO; j++) {
            if (notas[indice][j] != -1) {
                System.out.println(nombrealumnos[j]+" - "+notas[indice][j]+" nota");
            }
        }
    }
}
private static String[] getOrdenarArray(String[] array, int numElementos) {
    String[] arrayOrdenado = Arrays.copyOf(array, numElementos);
    Arrays.sort(arrayOrdenado);
    return arrayOrdenado;
}
private static void insertarDatos(Scanner sc) { 	//1-Insertar datos. Se pedira nombre de asignatura, nombre del alumno y la nota del alumno
	System.out.println("Introduce Nombre ASIGNATURA:");
    String asignatura = sc.next();
    if (comprobarAsignatura(asignatura)) {
    	nombreasignaturas[numasignatura] = asignatura;
       numasignatura++;
    }
	
    System.out.println("Introduce Nombre ALUMNO:");
    String alumno = sc.next();
    if (comprobarAlumno(alumno)) {
    	nombrealumnos[numalumno] = alumno;
    	numalumno++;
    }
    System.out.println("Introduce la nota del ALUMNO:");
    float nota = sc.nextFloat();
    notas[indiceAsignatura(asignatura)][indiceAlumno(alumno)] = nota;
    
    
    
    
    
    
    
}
private static int indiceAsignatura(String asignatura) {
	int indice = 0;
    while (indice < numasignatura && !asignatura.equals(nombreasignaturas[indice])) {
        indice++;
    }
    return indice;
}
private static int indiceAlumno(String alumno) {
	int indice = 0;
    while (indice < numalumno && !alumno.equals(nombrealumnos[indice])) {
        indice++;
    }
    return indice;
}
private static boolean comprobarAlumno(String alumno) {
	for (String c : nombrealumnos) {
        if (alumno.equals(c)) {
            return false;  
        }
	
	}
	return true;	
}
private static boolean comprobarAsignatura(String asignatura) {
	for (String c : nombreasignaturas) {
        if (asignatura.equals(c)) {
            return false;  
        }
	
	}
	return true;	
}
private static void inicializarDatos() {
	for (int i = 0; i < MAXASIGNATURA; i++) {
        for (int j = 0; j < MAXALUMNO; j++) {
        	notas[i][j] = -1;
        }
    }
}
	
}

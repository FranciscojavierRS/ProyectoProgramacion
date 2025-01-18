package Tarea1_POO_Clases.ferroviaria;

public class EmpresaFerroviaria {
	private static Empleado[] empleados = new Empleado[10];
	private static int numEmpleados = 0;
	private static int numMaquinarias=0;
	private static Maquinaria[] maquinarias = new Maquinaria[10];
	
	public static void main(String[] args) {

		añadirEmpleado( new JefeEstacion("MANOLITO GAFOTAS", "31231234"));
		mostrarEmpleados();
		
		
	}
	private static void añadirEmpleado(Empleado empleado) {
		empleados[numEmpleados]=empleado;
		numEmpleados++;
	}
	
	private static void mostrarEmpleados() {
		for (int i =0; i<numEmpleados;i++) {
			System.out.println(empleados[i].toString());
		}
	}
	private static void añadirMaquinaria(Maquinaria maquinaria) {
		maquinarias[numMaquinarias]=maquinaria;
		numMaquinarias++;
	}
	
	private static void mostrarMaquinaria() {
		for (int i =0; i<numMaquinarias;i++) {
			System.out.println(maquinarias[i].toString());
		}
	}
	
	
}

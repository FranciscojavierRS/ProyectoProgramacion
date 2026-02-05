package Hotel_Examen_Objetos;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		// CREAMOS UNA VARIABLE TIPO HOTEL
		Hotel hotel = new Hotel();

		// CREAMOS VARIAS HABITACIONES
		Habitacion h1 = (new Habitacion(1));
		Habitacion h2 = (new Habitacion(2));
		Habitacion h3 = (new Habitacion(3));
		Habitacion h4 = (new Habitacion(4));
		Habitacion h5 = (new Habitacion(5));

		// LAS AÑADIMOS AL HOTEL
		hotel.anyadeHabitacion(h1);
		hotel.anyadeHabitacion(h2);
		hotel.anyadeHabitacion(h3);
		hotel.anyadeHabitacion(h4);
		hotel.anyadeHabitacion(h5);

		// CREAMOS CLIENTES
		Cliente c1 = (new Cliente("Alex Cremento "));
		Cliente c2 = (new Cliente("Sindy Entes   "));
		Cliente c3 = (new Cliente("Isaac A. Mocos"));
		Cliente c4 = (new Cliente("Lali Cuadora  "));

		// LOS A�ADIMOS AL HOTEL
		hotel.anyadeCliente(c1);
		hotel.anyadeCliente(c2);
		hotel.anyadeCliente(c1);
		hotel.anyadeCliente(c4);

		// CREAMOS VARIAS RESERVAS DE LAS HABITACIONES Y CLIENTES CREADOS, ENTRE FECHAS
		Reserva r00 = new Reserva(c1, h1, new Fecha(18, 2, 2021), new Fecha(20, 2, 2021));
		Reserva r01 = new Reserva(c2, h1, new Fecha(21, 2, 2021), new Fecha(23, 2, 2021));
		Reserva r02 = new Reserva(c3, h2, new Fecha(18, 2, 2021), new Fecha(18, 2, 2021));
		Reserva r03 = new Reserva(c1, h2, new Fecha(20, 2, 2021), new Fecha(24, 2, 2021));
		Reserva r04 = new Reserva(c4, h3, new Fecha(18, 2, 2021), new Fecha(19, 2, 2021));
		Reserva r05 = new Reserva(c2, h3, new Fecha(20, 2, 2021), new Fecha(22, 2, 2021));
		Reserva r06 = new Reserva(c3, h3, new Fecha(23, 2, 2021), new Fecha(26, 2, 2021));
		Reserva r07 = new Reserva(c1, h4, new Fecha(18, 2, 2021), new Fecha(21, 2, 2021));
		// LA HABITACIoN 4 ESTa RESERVADA POR DOS CLIENTES DISTINTOS EL DiA 20 Y 21
		Reserva r08 = new Reserva(c3, h4, new Fecha(20, 2, 2021), new Fecha(23, 2, 2021));
		Reserva r09 = new Reserva(c2, h5, new Fecha(20, 2, 2021), new Fecha(24, 2, 2021));

		// AñADIMOS LAS RESERVAS AL HOTEL
		hotel.anyadeReserva(r00);
		hotel.anyadeReserva(r01);
		hotel.anyadeReserva(r02);
		hotel.anyadeReserva(r03);
		hotel.anyadeReserva(r04);
		hotel.anyadeReserva(r05);
		hotel.anyadeReserva(r06);
		hotel.anyadeReserva(r07);
		hotel.anyadeReserva(r08);
		hotel.anyadeReserva(r09);

		// APARTADO A)
		System.out.println("Apartado a) reservas de la habitacion 1:");
		mostrarReservas(hotel.getReservasDeHabitacion(h1));
		System.out.println("Apartado a) reservas de la habitacion 5:");
		mostrarReservas(hotel.getReservasDeHabitacion(h5));

		// APARTADO B)
		System.out.println("Apartado b) habitaciones ocupadas el d�a 19/2/2021:");
		System.out.println(Arrays.toString(hotel.habitacionesOcupadasElDia(new Fecha(19, 2, 2021))));

		// APARTADO C)
		System.out.print("Apartado c) habitaci�n h1 disponible entre el 24/2/2021 y el 26/2/2021:");
		System.out.println(hotel.habitacionDisponible(h1, new Fecha(24, 2, 2021), new Fecha(26, 2, 2021)));
		System.out.print("Apartado c) habitaci�n h5 disponible entre el 19/2/2021 y el 20/2/2021:");
		System.out.println(hotel.habitacionDisponible(h5, new Fecha(19, 2, 2021), new Fecha(20, 2, 2021)));
		System.out.print("Apartado d) Hay alg�n error por reservas superpuestas: ");
		System.out.println(hotel.hayErroresEnReservas());

	}

	public static void mostrarReservas(Reserva tabla[]) {
		for (Reserva r : tabla)
			System.out.println(r);
	}

}
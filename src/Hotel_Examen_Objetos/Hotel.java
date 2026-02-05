package Hotel_Examen_Objetos;

import java.util.Arrays;

import Formula1_Examen_Objetos.Piloto;

public class Hotel {
	private Reserva tReservas[];
	private Cliente tClientes[];
	private Habitacion tHabitaciones[];

	public Hotel() {
		this.tClientes = new Cliente[0];
		this.tHabitaciones = new Habitacion[0];
		this.tReservas = new Reserva[0];
	}

	public void anyadeCliente(Cliente cliente) {
		Cliente tNueva[] = new Cliente[this.tClientes.length + 1];
		for (int i = 0; i < this.tClientes.length; i++)
			tNueva[i] = this.tClientes[i];
		tNueva[this.tClientes.length] = cliente;
		this.tClientes = tNueva;
	}

	public void anyadeHabitacion(Habitacion habitacion) {
		Habitacion tNueva[] = new Habitacion[this.tHabitaciones.length + 1];
		for (int i = 0; i < this.tHabitaciones.length; i++)
			tNueva[i] = this.tHabitaciones[i];
		tNueva[this.tHabitaciones.length] = habitacion;
		this.tHabitaciones = tNueva;
	}

	public void anyadeReserva(Reserva reserva) {
		Reserva tNueva[] = new Reserva[this.tReservas.length + 1];
		for (int i = 0; i < this.tReservas.length; i++)
			tNueva[i] = this.tReservas[i];
		tNueva[this.tReservas.length] = reserva;
		this.tReservas = tNueva;
	}

	public Reserva[] getReservasDeHabitacion(Habitacion habitacion)

	/*
	 * Empezamos recorriendo el Array de tReservas[] para luego poder ver si la
	 * habitación de la Reserva es = a la habitación que se pone en la entrada de
	 * datos, si es esa +1 al Array y lo insertamos al Array
	 * 
	 * 
	 */
	{
		Reserva[] reservasHabitacion = new Reserva[0];

		for (Reserva reserva : tReservas) {
			if (reserva.getHabitacion().equals(habitacion)) {
				reservasHabitacion = Arrays.copyOf(reservasHabitacion, reservasHabitacion.length + 1);
				reservasHabitacion[reservasHabitacion.length - 1] = reserva;
			}
		}

		return reservasHabitacion;
	}

	public Habitacion[] habitacionesOcupadasElDia(Fecha fecha) {
		/*
		 * Recorremos el Array de reservas ya que es donde se guarda las habitaciones y
		 * las Fechas. Si la fecha de entrada esta entre la fecha de INICIO y FIN se
		 * coge la habitación y se inserta en el Array.
		 * 
		 */

		Habitacion[] habitacionesFecha = new Habitacion[0];
		for (Reserva reserva : tReservas) {
			if (fecha.compareTo(reserva.getFechaInicio()) >= 0 && fecha.compareTo(reserva.getFechaFin()) <= 0) {
				habitacionesFecha = Arrays.copyOf(habitacionesFecha, habitacionesFecha.length + 1);
				habitacionesFecha[habitacionesFecha.length - 1] = reserva.getHabitacion();
			}

		}

		return habitacionesFecha;
	}

	public boolean habitacionDisponible(Habitacion habitacion, Fecha inicio, Fecha fin)

	/*
	 * Tengo que volver a recorrer el Arrays de Reservas y por cada Reserva COMPARAR
	 * si la fecha de inicio de la Reserva esta entre la fecha inicio y fin estan
	 * entre las que se pasan por parametro Si estan entre una de esas devuelvo
	 * False
	 */
	{
		for (Reserva reserva : tReservas) {
			if (reserva.getFechaInicio().compareTo(fin) <= 0 && reserva.getFechaFin().compareTo(inicio) > 0
					&& reserva.getHabitacion().equals(habitacion)) {

				return false;
			}

		}

		return true;
	}

	public boolean hayErroresEnReservas() {

		/*
		 * Recorremos el Array de Reservas, por cada Reserva vuelvo a recorrer el mismo
		 * Array pero empezando por el elemento siguiente para comprobar si la
		 * habitación es la misma el comprobar si esa habitacion esta ocupada durante el
		 * mismo periodo que la reserva
		 */

		for (int i = 0; i < tReservas.length - 1; i++) {
			Reserva reserva = tReservas[i];
			for (int j = i + 1; j < tReservas.length; j++) {
				if (reserva.getHabitacion().equals(tReservas[j].getHabitacion())
						&& tReservas[j].getFechaInicio().compareTo(reserva.getFechaFin()) < 0
						&& tReservas[j].getFechaFin().compareTo(reserva.getFechaInicio()) > 0) {
					return true;
				}
			}
		}
		return false;
	}

}
package Hotel_Examen_Objetos;

public class Reserva {
	private Cliente cliente;
	private Habitacion habitacion;
	private Fecha fechaInicio;
	private Fecha fechaFin;

	public Reserva(Cliente cliente, Habitacion habitacion, Fecha fechaInicio, Fecha fechaFin) {
		this.cliente = cliente;
		this.habitacion = habitacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Fecha getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Fecha fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Fecha getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Fecha fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "El " + this.cliente + " ha reservado la " + this.habitacion + " desde el " + this.fechaInicio
				+ " hasta el " + this.fechaFin;
	}

}
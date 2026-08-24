package ed2026.TP1;

import java.time.LocalDate; // permite usar acentos
import java.time.temporal.ChronoUnit; // mide la diferencia de tiempo entre dos fechas

public class Reserva {
    private String codigoReserva;
    private String nombreHuesped;
    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;

    // Constructor predeterminado
    public Reserva() {
        codigoReserva = "000";
        nombreHuesped = "Por confirmar";
        fechaCheckIn = LocalDate.now();
        fechaCheckOut = LocalDate.now().plusDays(1);
    }

    // Constructor con parámetros
    public Reserva(String codigoReserva, String nombreHuesped,
                   LocalDate fechaCheckIn, LocalDate fechaCheckOut) {
        this.codigoReserva = codigoReserva;
        this.nombreHuesped = nombreHuesped;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        validarFechas();
    }

    // Si las fechas no son válidas, se colocan fechas por defecto
    public void validarFechas() {
        if (!fechaCheckIn.isBefore(fechaCheckOut)) {
            fechaCheckIn = LocalDate.now();
            fechaCheckOut = LocalDate.now().plusDays(1);
        }
    }

    public boolean estaActiva(LocalDate fechaConsulta) {
        return !fechaConsulta.isBefore(fechaCheckIn)
                && fechaConsulta.isBefore(fechaCheckOut);
    }
    //permite devolverme un valor entero grande (la fecha)
    public long calcularDiasRestantesOTranscurridos(LocalDate fechaConsulta) {
        if (fechaConsulta.isBefore(fechaCheckIn)) {
            return ChronoUnit.DAYS.between(fechaConsulta, fechaCheckIn);
        } else if (fechaConsulta.isBefore(fechaCheckOut)) {
            return 0;
        } else {
            return -ChronoUnit.DAYS.between(fechaCheckOut, fechaConsulta);
        }
    }

    public LocalDate simularProrroga(int cantidadDias) {
        return fechaCheckOut.plusDays(cantidadDias);
    }

    @Override
    public String toString() {
        return "Codigo de reserva: " + codigoReserva
                + "\nHuesped: " + nombreHuesped
                + "\nCheck-in: " + fechaCheckIn
                + "\nCheck-out: " + fechaCheckOut;
    }
}


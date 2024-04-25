package ejercicio2.model;

import java.time.LocalDate;

public class Empleado {
    private String apellido;
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private String mail;

    public Empleado(String apellido, String nombre, LocalDate fechaDeNacimiento, String mail) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return this.apellido + " " + this.nombre + " " + this.fechaDeNacimiento + " " + this.mail;
    }

    public boolean esCumpleanios() {
        return fechaDeNacimiento.getDayOfMonth() == LocalDate.now().getDayOfMonth() && fechaDeNacimiento.getMonth() == LocalDate.now().getMonth();
    }
}

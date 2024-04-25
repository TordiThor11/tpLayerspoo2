package ejercicio2;

import ejercicio2.model.Empleado;
import ejercicio2.model.IOData;

import java.time.LocalDate;
import java.util.HashSet;

public class FakeIOData implements IOData {
    @Override
    public HashSet<Empleado> obtenerEmpleados() {
        var empleados = new HashSet<Empleado>();
        empleados.add(new Empleado("Perez", "Julian", LocalDate.of(2002, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()), "julito@outlook.com"));
        empleados.add(new Empleado("Gomez", "Jose", LocalDate.of(1999, 1, 9), "donjose@outlook.com"));
        empleados.add(new Empleado("Martinez", "Tomas", LocalDate.of(1990, 5, 15), "tomipro@outlook.com"));
        return empleados;
    }
}

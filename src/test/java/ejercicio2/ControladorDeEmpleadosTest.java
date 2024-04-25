package ejercicio2;

import ejercicio2.model.ControladorDeEmpleados;
import ejercicio2.model.Empleado;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class ControladorDeEmpleadosTest {
    @Test
    public void esCumpleanios() {
        var empleado = new Empleado("Perez", "Julian", LocalDate.of(1999, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()), "julito@outlook.com");
        Assert.assertTrue(empleado.esCumpleanios());
    }

    public void enviarSaludosDeCumpleanios() {
        var controladorDeEmpleados = new ControladorDeEmpleados(new FakeIOData(), new FakeEnvioDeMail());
        controladorDeEmpleados.enviarSaludoDeCumpleanios();
        //No tengo asserts?
    }

}
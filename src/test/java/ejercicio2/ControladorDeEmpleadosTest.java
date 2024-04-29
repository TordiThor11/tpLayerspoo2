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

    @Test
    public void enviarSaludosDeCumpleanios() {
        var fakeData = new FakeIOData();
        var fakeEnvioDeMail = new FakeEnvioDeMail();
        var controladorDeEmpleados = new ControladorDeEmpleados(fakeData, fakeEnvioDeMail);
        controladorDeEmpleados.enviarSaludoDeCumpleanios(); //irrelevante para el test, pero ejecuta las lineas de codigo y me da mas coverage, es util?
        Assert.assertEquals(1, fakeEnvioDeMail.cantidadDeSaludosMandados(fakeData));
    }

}
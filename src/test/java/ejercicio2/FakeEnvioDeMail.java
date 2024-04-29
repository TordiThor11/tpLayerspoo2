package ejercicio2;

import ejercicio2.model.Empleado;
import ejercicio2.model.EnvioDeMail;

public class FakeEnvioDeMail implements EnvioDeMail {
    @Override
    public void enviarMail(String mailTo, String tema, String mensaje) {

    }

    public int cantidadDeSaludosMandados(FakeIOData fakeIOData) {
        int contadorMailsEnviados = 0;
        var empleados = fakeIOData.obtenerEmpleados();
        for (Empleado empleado : empleados) {
            if (empleado.esCumpleanios()) {
                this.enviarMail(empleado.getMail(), "Feliz cumpleanios", "Te deseamos FC");
                contadorMailsEnviados++;
            }
        }
        return contadorMailsEnviados;
    }
}

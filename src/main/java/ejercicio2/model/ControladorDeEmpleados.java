package ejercicio2.model;

public class ControladorDeEmpleados {
    private ejercicio2.model.IOData IOData;

    private EnvioDeMail envioDeMail;

    public ControladorDeEmpleados(IOData IOData, EnvioDeMail envioDeMail) {
        this.IOData = IOData;
        this.envioDeMail = envioDeMail;
    }

    public void enviarSaludoDeCumpleanios() {
        var empleados = this.IOData.obtenerEmpleados();
        for (Empleado empleado : empleados) {
            if (empleado.esCumpleanios()) {
                envioDeMail.enviarMail(empleado.getMail(), "Feliz cumpleanios", "Te deseamos FC");
            }
        }
    }
}

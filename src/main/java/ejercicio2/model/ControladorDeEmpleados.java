package ejercicio2.model;

public class ControladorDeEmpleados {
    private IOData IOData;

    private EnvioDeMail envioDeMail;

    public ControladorDeEmpleados(IOData IOData, EnvioDeMail envioDeMail) {
        this.IOData = IOData;
        this.envioDeMail = envioDeMail;
    }

    public void enviarSaludoDeCumpleanios() {
        var empleados = this.IOData.obtenerEmpleados();
        for (Empleado empleado : empleados) {
            
        }
    }
}

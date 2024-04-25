package ejercicio2.main;

import ejercicio2.dataBase.EnDiscoDB;
import ejercicio2.mail.MailJakarta;
import ejercicio2.model.ControladorDeEmpleados;

public class main {
    public static void main(String[] args) {
        EnDiscoDB db = new EnDiscoDB("C:\\Users\\Valentin\\IdeaProjects\\tpLayers\\src\\main\\resources\\layers2.txt");
//        HashSet<Empleado> empleadoHashSet = db.obtenerEmpleados();
        /*for (Empleado empleado : empleadoHashSet) {
            System.out.println(empleado.toString());
        }*/
        var controladorDeEmpleados = new ControladorDeEmpleados(db, new MailJakarta("sandbox.smtp.mailtrap.io", "2525", "136bf073b21441", "035c321df45fe7"));
//        System.out.println(new Empleado("gomez", "juan", LocalDate.of(1999, 4, 25), "juan@gmail.com").esCumpleanios());
        controladorDeEmpleados.enviarSaludoDeCumpleanios();
    }

}

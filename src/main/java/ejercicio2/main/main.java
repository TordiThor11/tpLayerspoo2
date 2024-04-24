package ejercicio2.main;

import ejercicio2.dataBase.EnDiscoDB;
import ejercicio2.model.Empleado;

import java.util.HashSet;

public class main {
    public static void main(String[] args) {
        EnDiscoDB db = new EnDiscoDB("C:\\Users\\Valentin\\IdeaProjects\\tpLayers\\src\\main\\resources\\layers2.txt");
        HashSet<Empleado> empleadoHashSet = db.obtenerEmpleados();
        for (Empleado empleado : empleadoHashSet) {
            System.out.println(empleado.toString());
        }

    }
}

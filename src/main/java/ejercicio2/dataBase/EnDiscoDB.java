package ejercicio2.dataBase;

import ejercicio2.model.Empleado;
import ejercicio2.model.IOData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class EnDiscoDB implements IOData {
    private String filePath;

    public EnDiscoDB(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public HashSet<Empleado> obtenerEmpleados() {
        var empleadoHashSet = new HashSet<Empleado>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split(", ");
                if (parts.length != 4) {
                    throw new IOException("Error en la recuperacion de los datos");
                }
                empleadoHashSet.add(new Empleado(parts[0], parts[1], LocalDate.parse(parts[2], DateTimeFormatter.ofPattern("yyyy/MM/dd")), parts[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return empleadoHashSet;
    }
}

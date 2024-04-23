package ejercicio1.main;

import ejercicio1.dataBase.JdbcRegistroParticipante;
import ejercicio1.model.ControladorDeParticipantes;
import ejercicio1.ui.VentanaDeCarga;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
//                    new AgregarParticipante();
                    JdbcRegistroParticipante registroParticipante = new JdbcRegistroParticipante();
                    ControladorDeParticipantes controladorDeParticipantes = new ControladorDeParticipantes(registroParticipante);
                    new VentanaDeCarga(controladorDeParticipantes);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}

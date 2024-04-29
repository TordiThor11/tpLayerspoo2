package ejercicio1.dataBase;

import ejercicio1.model.Participante;
import ejercicio1.model.RegistroDeParticipantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcRegistroParticipante implements RegistroDeParticipantes {
    private Connection dbConn;

    public JdbcRegistroParticipante() throws Exception {
        String url = "jdbc:mysql://localhost:3306/ejercicio1layering";
        String user = "root";
        String password = "";
        try {
            this.dbConn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        }

    }

    public void registrar(Participante participante) throws Exception {
        try (PreparedStatement st = dbConn.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");) {
            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

}

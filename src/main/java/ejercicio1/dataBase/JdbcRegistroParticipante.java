package ejercicio1.dataBase;

import ejercicio1.model.Participante;
import ejercicio1.model.RegistroDeParticipantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcRegistroParticipante implements RegistroDeParticipantes {
    private Connection dbConn;

    public JdbcRegistroParticipante() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ejercicio1layering";
        String user = "root";
        String password = "";
        this.dbConn = DriverManager.getConnection(url, user, password);
    }

    public void registrar(Participante participante) {
        try (PreparedStatement st = dbConn.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");) {
            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

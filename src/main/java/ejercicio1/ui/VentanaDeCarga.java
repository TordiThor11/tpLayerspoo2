package ejercicio1.ui;

import ejercicio1.model.ControladorDeParticipantes;
import ejercicio1.model.Participante;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaDeCarga extends JFrame {
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private ControladorDeParticipantes controladorDeParticipantes;

    public VentanaDeCarga(ControladorDeParticipantes controladorDeParticipantes) {
        this.controladorDeParticipantes = controladorDeParticipantes;
        setupUIComponents();
    }

    private void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);
        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);
        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onBotonCargar();
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() throws Exception {
        if (nombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe cargar un nombre");
            return;
        }
        if (telefono.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe cargar un telefono");
            return;
        }
        if (!validarTelefono(telefono.getText())) {
            JOptionPane.showMessageDialog(this, "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
            return;
        }
        if (validarRegion()) {
            JOptionPane.showMessageDialog(this, "Region desconocida. Las conocidas son: China, US, Europa");
            return;
        }
        controladorDeParticipantes.registrarParticipante(new Participante(nombre.getText(), telefono.getText(), region.getText()));
        dispose();
    }

    private boolean validarRegion() {
        return !region.getText().equals("China") && !region.getText().equals("US") && !
                region.getText().equals("Europa");
    }

    private boolean validarTelefono(String telefono) { //Realizo la misma validacion en el constructor de Participante
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }
}

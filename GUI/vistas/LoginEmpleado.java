package GUI.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginEmpleado extends JPanel {
    private JTextField textUser;
    private JPasswordField fieldPassword;
    private JButton atrasBoton;
    private JButton aceptarBoton;

    public LoginEmpleado() {
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Componentes del formulario
        addTitle(constraints);
        addNIF(constraints);
        addPasswordField(constraints);
        addButtons(constraints);
    }

    private void addTitle(GridBagConstraints constraints) {
        JLabel titleLabel = new JLabel("Login de empleados");
        titleLabel.setFont(new Font(getName(), Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.CENTER;

        add(titleLabel, constraints);

    }

    private void addNIF(GridBagConstraints constraints) {
        JLabel labelUser = new JLabel("DNI/NIF:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(labelUser, constraints);

        this.textUser = new JTextField(30);
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(textUser, constraints);
    }

    private void addPasswordField(GridBagConstraints constraints) {
        JLabel labelPassword = new JLabel("Contraseña:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(labelPassword, constraints);

        this.fieldPassword = new JPasswordField(30);
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(fieldPassword, constraints);
    }

    public void addButtons(GridBagConstraints constraints) {
        aceptarBoton = new JButton("Aceptar");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        add(aceptarBoton, constraints);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        atrasBoton = new JButton("Atrás");

        buttonPanel.add(atrasBoton);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.LAST_LINE_END;
        add(buttonPanel, constraints);
    }

    public String getUsuario() {
        return this.textUser.getText();
    }

    public String getPassword() {
        return new String(this.fieldPassword.getPassword());
    }

    public void setControlador(ActionListener cAceptar, ActionListener cAtras){
        aceptarBoton.addActionListener(cAceptar);
        atrasBoton.addActionListener(cAtras);
    }

    public void update() {
        textUser.setText("");
        fieldPassword.setText("");
    }
    
}
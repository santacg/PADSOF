package gui.vistas;

import java.awt.*;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Set;

import javax.swing.*;

import gui.modelo.centroExposicion.CentroExposicion;
import gui.modelo.exposicion.Exposicion;

public class SorteoFormulario extends JDialog {
    private String tipoSorteo;
    private JList<String> exposiciones;
    private JTextField fechaSorteo;
    private JTextField n_entradas;
    private JTextField diaSorteo;
    private JTextField horaSorteo;
    private JTextField fechaInicioSorteo;
    private JTextField fechaFinSorteo;
    private JButton aceptarBtn;
    private JButton cancelarBtn;
    private JPanel panelExposiciones;

    /**
     * Constructor de la clase SalaFormulario
     * 
     * @param accion String que indica la acción a realizar
     */
    public SorteoFormulario() {
        setSize(600, 700);
        setLocationRelativeTo(null); // Centrar el formulario
        setModal(true); // Hacer el diálogo modal para bloquear otras ventanas hasta que se cierre

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        JPanel panelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        this.tipoSorteo = formularioTipoSorteo();
        if (tipoSorteo == null) {
            dispose();
            return;
        }

        formularioAñadirSorteo(panelFormulario, constraints);

        if (tipoSorteo == "Sorteo por día y hora") {
            addCampo("Dia del sorteo:", diaSorteo = new JTextField(20), panelFormulario, constraints, 2);
            addCampo("Hora del sorteo:", horaSorteo = new JTextField(20), panelFormulario, constraints, 3);
        } else if (tipoSorteo == "Sorteo por fechas") {
            addCampo("Fecha inicio (yyyy-mm-dd):", fechaInicioSorteo = new JTextField(20), panelFormulario, constraints,
                    2);
            addCampo("Fecha fin (yyyy-mm-dd):", fechaFinSorteo = new JTextField(20), panelFormulario, constraints, 3);
        }

        this.exposiciones = new JList<>();
        JScrollPane scrollExposiciones = new JScrollPane(this.exposiciones);
        scrollExposiciones.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollExposiciones.setBorder(BorderFactory.createTitledBorder("Exposiciones"));

        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);
        panelPrincipal.add(scrollExposiciones, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addBotones(buttonPanel); 
        panelPrincipal.add(buttonPanel, BorderLayout.SOUTH); 

        add(panelPrincipal);
    }

    /**
     * Método que crea un formulario para seleccionar el tipo de sorteo
     * 
     * @return String con el tipo de sorteo seleccionado
     */
    public String formularioTipoSorteo() {
        String[] opcionesSorteo = { "Sorteo por día y hora", "Sorteo por exposición", "Sorteo por fechas" };
        JComboBox<String> comboSorteo = new JComboBox<>(opcionesSorteo);

        int seleccion = JOptionPane.showConfirmDialog(null, comboSorteo, "Seleccione el tipo de sorteo",
                JOptionPane.OK_CANCEL_OPTION);

        if (seleccion == JOptionPane.OK_OPTION) {
            return (String) comboSorteo.getSelectedItem();
        }

        return null;
    }

    /**
     * Método que crea el formulario para añadir un sorteo
     * 
     * @param panelFormulario JPanel en el que se añadirán los campos
     * @param constraints     GridBagConstraints que definen la posición de los
     *                        campos
     */
    public void formularioAñadirSorteo(JPanel panelFormulario, GridBagConstraints constraints) {
        addCampo("Fecha del sorteo (yyyy-mm-dd):", fechaSorteo = new JTextField(20), panelFormulario, constraints, 0);
        addCampo("Numero de entradas:", n_entradas = new JTextField(20), panelFormulario, constraints, 1);
    }

    /**
     * Método que muestra las exposiciones de un centro de exposición
     * 
     * @param centroExposicion CentroExposicion del que se mostrarán las
     *                         exposiciones disponibles
     */
    public void mostrarExposiciones(CentroExposicion centroExposicion) {
        Set<Exposicion> exposicionesSet = centroExposicion.getExposiciones();
        DefaultListModel<String> model = new DefaultListModel<>();

        if (exposicionesSet.isEmpty()) {
            model.addElement("No hay exposiciones disponibles.");
        } else {
            for (Exposicion exposicion : exposicionesSet) {
                model.addElement(exposicion.getNombre());
            }
        }

        exposiciones.setModel(model);
    }

    /**
     * Método que añade un campo al formulario
     * 
     * @param label       String que indica el nombre del campo
     * @param comp        Component que se añadirá al formulario
     * @param panel       JPanel en el que se añadirá el campo
     * @param constraints GridBagConstraints que definen la posición del campo
     * @param gridy       int que indica la fila en la que se añadirá el campo
     */
    private void addCampo(String label, Component comp, JPanel panel, GridBagConstraints constraints, int gridy) {
        JLabel jlabel = new JLabel(label);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        constraints.gridwidth = 1;
        panel.add(jlabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = gridy;
        panel.add(comp, constraints);
    }

    /**
     * Método que añade los botones de aceptar y cancelar al formulario
     * 
     * @param panel JPanel en el que se añadirán los botones
     */
    private void addBotones(JPanel buttonPanel) {
        this.aceptarBtn = new JButton("Aceptar");
        this.cancelarBtn = new JButton("Cancelar");

        buttonPanel.add(aceptarBtn);
        buttonPanel.add(cancelarBtn);
    }

    /**
     * Método que devuelve el tipo de sorteo seleccionado en el formulario
     * 
     * @return String con el tipo de sorteo seleccionado
     */
    public String getTipoSorteo() {
        return tipoSorteo;
    }

    /**
     * Método que devuelve la fecha de sorteo introducida en el formulario
     * 
     * @return LocalDate con la fecha introducida
     */
    public LocalDate getFechaSorteo() {
        if (this.fechaSorteo.getText().equals("")) {
            return null;
        }

        try {
            return LocalDate.parse(this.fechaSorteo.getText());
        } catch (DateTimeException e) {
            return null;
        }
    }

    /**
     * Fecha que devuelve el número de entradas introducido en el formulario
     * 
     * @return Integer con el número de entradas introducido
     */
    public Integer getSorteoEntradas() {
        try {
            return Integer.parseInt(n_entradas.getText());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Método que devuelve el día introducido en el formulario
     * 
     * @return LocalDate con el día introducido
     */
    public LocalDate getDiaSorteo() {
        if (this.diaSorteo.getText().equals("")) {
            return null;
        }

        try {
            return LocalDate.parse(this.diaSorteo.getText());
        } catch (DateTimeException e) {
            return null;
        }
    }

    /**
     * Método que devuelve la hora introducida en el formulario
     * 
     * @return String con la hora introducida
     */
    public String getHoraSorteo() {
        return horaSorteo.getText();
    }

    /**
     * Método que devuelve la fecha de inicio del sorteo
     * 
     * @return LocalDate con la fecha de inicio del sorteo
     */
    public LocalDate getFechaInicioSorteo() {
        if (this.fechaInicioSorteo.getText().equals("")) {
            return null;
        }

        try {
            return LocalDate.parse(this.fechaInicioSorteo.getText());
        } catch (DateTimeException e) {
            return null;
        }
    }

    /**
     * Método que devuelve la fecha de fin del sorteo
     * 
     * @return LocalDate con la fecha de fin del sorteo
     */
    public LocalDate getFechaFinSorteo() {
        if (this.fechaFinSorteo.getText().equals("")) {
            return null;
        }

        try {
            return LocalDate.parse(this.fechaFinSorteo.getText());
        } catch (DateTimeException e) {
            return null;
        }
    }

    /**
     * Método que devuelve la exposición seleccionada en el formulario
     * 
     * @return String con la exposición seleccionada
     */
    public String getSelectedExposicion() {
        return exposiciones.getSelectedValue();
    }

    /**
     * Método que establece los controladores de los botones del formulario
     * 
     * @param cAceptar  ActionListener que se añadirá al botón de aceptar
     * @param cCancelar ActionListener que se añadirá al botón de cancelar
     */
    public void setControlador(ActionListener cAceptar, ActionListener cCancelar) {
        aceptarBtn.addActionListener(cAceptar);
        cancelarBtn.addActionListener(cCancelar);
        setVisible(true);
    }

}

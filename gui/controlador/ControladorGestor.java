package gui.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import gui.modelo.centroExposicion.CentroExposicion;
import gui.modelo.exposicion.Exposicion;
import gui.modelo.exposicion.SalaExposicion;
import gui.modelo.obra.Estado;
import gui.modelo.obra.Obra;
import gui.modelo.sala.Sala;
import gui.modelo.utils.LectorCSVObras;
import gui.vistas.GestorPrincipal;
import gui.vistas.ModeloTablaObras;
import gui.vistas.Ventana;

/**
 * Clase ControladorGestor.
 * Implementa el controlador de la vista del gestor.
 * 
 * @author Carlos García Santa, Joaquín Abad Díaz y Eduardo Junoy Ortega
 */
public class ControladorGestor {

    private Ventana frame;
    private GestorPrincipal vista;
    private CentroExposicion centro;

    /**
     * Constructor de la clase ControladorGestor.
     * 
     * @param frame  Ventana principal de la aplicación.
     * @param centro Centro de exposición.
     */
    public ControladorGestor(Ventana frame, CentroExposicion centro) {
        this.frame = frame;
        this.frame.setCartaGestorPrincipal();
        this.centro = centro;
        this.vista = frame.getVistaGestorPrincipal();

        mostrarExposiciones();
        mostrarSalas();
        mostrarObras();
        mostrarEmpleados();
        mostrarSorteos();
        mostrarDescuentos();
        mostrarInfo();
    }

    /**
     * Método que muestra la vista del gestor.
     */
    public void mostrarExposiciones() {
        vista.addPanelExposiciones(centro);
    }

    /**
     * Método que muestra la vista de las salas.
     */
    public void mostrarSalas() {
        vista.addPanelSalas(centro);
    }

    /**
     * Método que muestra la vista de las obras.
     */
    public void mostrarObras() {
        vista.addPanelObras(centro);
    }

    /**
     * Metodo que muestra la vista de empleados
     */
    public void mostrarEmpleados() {
        vista.addPanelEmpleados(centro);
    }

    /**
     * Método que muestra la vista de los sorteos.
     */
    public void mostrarSorteos() {
        vista.addPanelSorteos(centro);
    }

    /**
     * Método que muestra la vista de los descuentos.
     */
    public void mostrarDescuentos() {
        vista.addPanelDescuentos(centro);
    }

    /**
     * Método que muestra la información del centro de exposición.
     */
    public void mostrarInfo() {
        vista.actualizarInfo(centro);
    }

    /**
     * Método que actualiza la vista de las exposiciones segun la ejecucion que se
     * haya realizado.
     */
    private ActionListener exposicionEjecutarListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String accion = vista.getExposicionAccionSeleccionada();
            JTable tabla = vista.getTablaExposiciones();

            int selectedRow = tabla.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Debes seleccionar una exposición.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Exposicion exposicion : centro.getExposiciones()) {
                if (exposicion.getNombre().equals(tabla.getValueAt(selectedRow, 0))) {
                    ControladorExposicionFormulario controladorExposicionFormulario = new ControladorExposicionFormulario(
                            vista, centro, exposicion, accion);
                    vista.setControladorExposicionFormulario(controladorExposicionFormulario);
                    break;
                }
            }

        }
    };

    /**
     * Método que actualiza la vista de las obras segun la ejecucion que se haya
     * realizado.
     */
    private ActionListener obraEjecutarListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String accion = vista.getObraAccionSeleccionada();
            JTable tabla = vista.getTablaObras();
            ModeloTablaObras modelo = (ModeloTablaObras) tabla.getModel();
            List<Obra> obras = new ArrayList<>();

            for (int i = 0; i < modelo.getRowCount(); i++) {
                Boolean seleccionado = (Boolean) modelo.getValueAt(i, 0);
                if (seleccionado) {
                    String nombreObra = (String) modelo.getValueAt(i, 1);
                    for (Obra obra : centro.getObras()) {
                        if (obra.getNombre().equals(nombreObra)) {
                            obras.add(obra);
                            switch (accion) {
                                case "Retirar Obra":
                                    if (obra.retirarObra() == false) {
                                        JOptionPane.showMessageDialog(frame,
                                                "No se puede retirar la obra " + nombreObra);
                                        continue;
                                    }
                                    modelo.setValueAt(Estado.RETIRADA, i, 8);
                                    JOptionPane.showMessageDialog(frame, "Obra retirada correctamente.");
                                    break;
                                case "Almacenar Obra":
                                    obra.almacenarObra();
                                    modelo.setValueAt(Estado.ALMACENADA, i, 8);
                                    JOptionPane.showMessageDialog(frame, "Obra almacenada correctamente.");
                                    break;
                                case "Exponer Obra":
                                    Map<String, Set<SalaExposicion>> exposicionesYSalas = new HashMap<>();
                                    for (Exposicion exposicion : centro.getExposiciones()) {
                                        exposicionesYSalas.put(exposicion.getNombre(), exposicion.getSalas());
                                    }

                                    String exposicionSeleccionada = (String) JOptionPane.showInputDialog(frame,
                                            "Seleccione la exposición donde quiere exponer la obra " + nombreObra,
                                            "Exponer Obra",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            exposicionesYSalas.keySet().toArray(),
                                            exposicionesYSalas.keySet().toArray()[0]);

                                    if (exposicionSeleccionada == null) {
                                        JOptionPane.showMessageDialog(frame,
                                                "No se seleccionó ninguna exposición.");
                                        continue;
                                    }

                                    Set<SalaExposicion> salas = exposicionesYSalas.get(exposicionSeleccionada);
                                    SalaExposicion[] salasArray = salas.toArray(new SalaExposicion[0]);

                                    if (salasArray.length == 0) {
                                        JOptionPane.showMessageDialog(frame,
                                                "No hay salas disponibles en la exposición seleccionada, debes agregar salas a la exposicíon.");
                                        continue;
                                    }

                                    SalaExposicion salaSeleccionada = (SalaExposicion) JOptionPane.showInputDialog(
                                            frame,
                                            "Seleccione la sala donde quiere exponer la obra " + nombreObra,
                                            "Exponer Obra",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            salasArray,
                                            null);

                                    if (salaSeleccionada == null) {
                                        JOptionPane.showMessageDialog(frame,
                                                "No se seleccionó ninguna sala.");
                                        continue;
                                    }

                                    if (salaSeleccionada.addObra(obra) == false) {
                                        JOptionPane.showMessageDialog(frame,
                                                "No se puede exponer la obra " + nombreObra);
                                        continue;
                                    }

                                    modelo.setValueAt(Estado.EXPUESTA, i, 8);
                                    String salaSeleccionadaNombre = salaSeleccionada.getSala().getNombre();

                                    JOptionPane.showMessageDialog(frame,
                                            "Obra " + nombreObra + "expuesta correctamente en "
                                                    + exposicionSeleccionada + " - " + salaSeleccionadaNombre);

                                    break;
                                case "Prestar Obra":
                                    if (obra.prestarObra() == false) {
                                        JOptionPane.showMessageDialog(frame,
                                                "No se puede prestar la obra " + nombreObra);
                                        continue;
                                    }
                                    modelo.setValueAt(Estado.PRESTADA, i, 8);
                                    JOptionPane.showMessageDialog(frame, "Obra prestada correctamente.");
                                    break;
                                case "Restaurar Obra":
                                    if (obra.restaurarObra() == false) {
                                        JOptionPane.showMessageDialog(frame,
                                                "No se puede restaurar la obra " + nombreObra);
                                        continue;
                                    }
                                    modelo.setValueAt(Estado.RESTAURACION, i, 8);
                                    JOptionPane.showMessageDialog(frame, "Obra puesta en restauracion correctamente.");
                                    break;
                            }
                            break;
                        }
                    }
                }
            }
            vista.deseleccionarTabla();
        }
    };

    /**
     * Método que inicializa un listener para leer las obras desde un CSV.
     */
    private ActionListener obraLeerCSVListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String fileName = JOptionPane.showInputDialog(vista,
                    "Introduce el nombre del archivo CSV (debes incluir el .csv)");
            if (LectorCSVObras.leerObras(centro, fileName) == false) {
                JOptionPane.showMessageDialog(frame, "Error al leer las obras.");
                return;
            }
            JOptionPane.showMessageDialog(frame, "Obras leídas correctamente.");
            vista.actualizarTablaObras(centro);
        }
    };

    /**
     * Método que actualiza la vista de las obras incializando un listener.
     */
    private ActionListener obraAgregarListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ControladorObraFormulario controladorObraFormulario = new ControladorObraFormulario(vista, centro);
            vista.setControladorObraFormulario(controladorObraFormulario);
        }
    };

    /**
     * Método que inicializa un listener para ejecutar las salas.
     */
    private ActionListener salaEjecutarListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String accion = vista.getSalaAccionSeleccionada();
            ControladorSalaFormulario controladorSalaFormulario = new ControladorSalaFormulario(vista, centro, accion);
            vista.setControladorSalaFormulario(controladorSalaFormulario);
        }
    };

    /**
     * Método que inicializa un listener para agregar exposiciones.
     */
    private ActionListener exposicionAgregarListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ControladorExposicionFormulario controladorExposicionFormulario = new ControladorExposicionFormulario(vista,
                    centro);
            vista.setControladorExposicionFormulario(controladorExposicionFormulario);
        }
    };

    /**
     * Método que inicializa un listener para agregar empleados.
     */
    private ActionListener empleadoAgregarListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ControladorEmpleadoFormulario controladorEmpleadoFormulario = new ControladorEmpleadoFormulario(vista,
                    centro);
            vista.setControladorEmpleadoFormulario(controladorEmpleadoFormulario);
        }
    };

    /**
     * Método que inicializa un listener para configurar la contraseña de un
     * empleado.
     */
    private ActionListener empleadoConfigurarContraseniaListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String contrasenia = JOptionPane.showInputDialog(vista, "Introduce la nueva contraseña");
            centro.setContraseniaEmpleado(contrasenia);
            if (contrasenia == null || contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No se ha actualizado la contraseña");
                return;

            }
            JOptionPane.showMessageDialog(frame, "Contraseña actualizada correctamente");
        }
    };

    /**
     * Método que inicializa un listener para agregar sorteos.
     */
    private ActionListener sorteoAgregarListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ControladorSorteoFormulario controladorSorteoFormulario = new ControladorSorteoFormulario(vista, centro);
            vista.setControladorSorteoFormulario(controladorSorteoFormulario);
        }
    };

    /**
     * Método que inicializa un listener para agregar descuentos.
     */
    private ActionListener descuentoAgregarListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ControladorDescuentoFormulario controladorDescuentoFormulario = new ControladorDescuentoFormulario(vista,
                    centro);
            vista.setControladorDescuentoFormulario(controladorDescuentoFormulario);
        }
    };

    /**
     * Método que inicializa un listener para cerrar sesion.
     */
    private ActionListener cerrarSesionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            centro.getGestor().logOut();
            vista.removeControlador(salaEjecutarListener, obraLeerCSVListener, obraEjecutarListener,
                    obraAgregarListener, exposicionEjecutarListener, exposicionAgregarListener, empleadoAgregarListener,
                    empleadoConfigurarContraseniaListener, sorteoAgregarListener, descuentoAgregarListener,
                    cerrarSesionListener);
            vista.removeAll();
            JOptionPane.showMessageDialog(frame, "Se ha cerrado la sesión.");
            frame.mostrarPanel(frame.getPanelPrincipal());
        }
    };

    /**
     * Método que obtiene el listener de de ejecucion de obras.
     * 
     * @return ActionListener para ejecutar obras.
     */
    public ActionListener getObraEjecutarListener() {
        return obraEjecutarListener;
    }

    /**
     * Método que obtiene el listener de agregar obras.
     * 
     * @return ActionListener para agregar obras.
     */
    public ActionListener getObraAgregarListener() {
        return obraAgregarListener;
    }

    /**
     * Método que obtiene el listener de leer obras desde un CSV.
     * 
     * @return ActionListener para leer obras desde un CSV.
     */
    public ActionListener getObraLeerCSVListener() {
        return obraLeerCSVListener;
    }

    /**
     * Método que obtiene el listener de ejecucion de salas.
     * 
     * @retunr ActionListener para ejecutar salas
     */
    public ActionListener getSalaEjecutarListener() {
        return salaEjecutarListener;
    }

    /**
     * Método que obtiene el listener de ejecucion de exposiciones.
     * 
     * @return ActionListener para ejecutar exposiciones
     */
    public ActionListener getExposicionEjecutarListener() {
        return exposicionEjecutarListener;
    }

    /**
     * Método que obtiene el listener de agregar exposiciones.
     * 
     * @return ActionListener para agregar exposiciones
     */
    public ActionListener getExposicionAgregarListener() {
        return exposicionAgregarListener;
    }

    /**
     * Metodo que devuelve el listener de agregar empleados
     * 
     * @return ActionListener para agregar empleados
     */
    public ActionListener getEmpleadoAgregarListener() {
        return empleadoAgregarListener;
    }

    /**
     * Método que devuelve el listener de configurar contraseña de empleado.
     * 
     * @return ActionListener para configurar contraseña de empleado.
     */
    public ActionListener getEmpleadoConfigurarContraseniaListener() {
        return empleadoConfigurarContraseniaListener;
    }

    /**
     * Método que devuelve el ActionListener para agregar sorteos.
     * 
     * @return ActionListener para agregar sorteos.
     */
    public ActionListener getSorteoAgregarListener() {
        return sorteoAgregarListener;
    }

    /**
     * Método que devuelve el ActionListener para agregar descuentos.
     * 
     * @return ActionListener para agregar descuentos.
     */
    public ActionListener getDescuentoAgregarListener() {
        return descuentoAgregarListener;
    }

    /**
     * Método que devuelve el ActionListener para cerrar la sesión del gestor.
     * 
     * @return ActionListener para cerrar la sesión del cliente.
     */
    public ActionListener getCerrarSesionListener() {
        return cerrarSesionListener;
    }

}
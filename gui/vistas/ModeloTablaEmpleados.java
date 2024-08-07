package gui.vistas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import gui.modelo.centroExposicion.Empleado;

/**
 * Modelo de tabla para la vista de empleados.
 * 
 * @author Carlos Garcia Santa
 */
public class ModeloTablaEmpleados extends AbstractTableModel {
    private String[] titulos;
    private Object[][] filas;
    private List<Empleado> empleados;

    /**
     * Constructor de la clase ModeloTablaEmpleados.
     * 
     * @param columnNames Nombres de las columnas.
     * @param data        Datos de las filas.
     * @param empleados   Lista de empleados.
     * 
     */
    public ModeloTablaEmpleados(String[] columnNames, Object[][] data, List<Empleado> empleados) {
        this.titulos = columnNames;
        this.filas = data;
        this.empleados = empleados;
    }

    /**
     * Añade una fila a la tabla.
     * 
     * @param rowData Datos de la fila.
     */
    public void addRow(Object[] rowData) {
        List<Object[]> filasList = new ArrayList<>(Arrays.asList(filas));
        filasList.add(rowData);
        filas = filasList.toArray(new Object[0][]);
        fireTableDataChanged();
    }

    /**
     * Obtiene el recuento de columnas.
     */
    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    /**
     * Obtiene el recuento de filas.
     */
    @Override
    public int getRowCount() {
        return filas.length;
    }

    /**
     * Obtiene el valor de una celda.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return filas[rowIndex][columnIndex];
    }

    /**
     * Obtiene si las 4 últimas columnas son editables.
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 5 && columnIndex <= 8;
    }

    /**
     * Establece el valor de una celda.
     */
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        filas[rowIndex][columnIndex] = value;
        Empleado empleado = empleados.get(rowIndex);

        switch (columnIndex) {
            case 5:
                empleado.setPermisoVenta((Boolean) value);
                break;
            case 6:
                empleado.setPermisoControl((Boolean) value);
                break;
            case 7:
                empleado.setPermisoMensajes((Boolean) value);
                break;
            case 8:
                empleado.setPermisoActividades((Boolean) value);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    /**
     * Obtiene el nombre de una columna.
     */
    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }

    /**
     * Obtiene las clases de una columna.
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex >= 5 && columnIndex <= 8) {
            return Boolean.class;
        }
        return String.class;
    }

    /**
     * Establece el recuento de filas a 0.
     */
    public void setRowCountToNone() {
        filas = new Object[0][];
        fireTableDataChanged();
    }
}

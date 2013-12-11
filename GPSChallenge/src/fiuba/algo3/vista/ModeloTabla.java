package fiuba.algo3.vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> nombreColumnas = new ArrayList<String>();
	private List<List<?>> data = new ArrayList<List<?>>();

	{
		nombreColumnas.add("Nombre");
		nombreColumnas.add("Puntaje");
	}

	public void agregarFila(List<?> filaData) {
		data.add(filaData);
		fireTableRowsInserted(data.size() - 1, data.size() - 1);
	}

	public int getColumnCount() {
		return nombreColumnas.size();
	}

	public int getRowCount() {
		return data.size();
	}

	public String getColumnName(int col) {
		try {
			return nombreColumnas.get(col);
		} catch (Exception e) {
			return null;
		}
	}

	public Object getValueAt(int row, int col) {
		return data.get(row).get(col);
	}

	public boolean celdaEditable(int row, int col) {
		return false;
	}


}

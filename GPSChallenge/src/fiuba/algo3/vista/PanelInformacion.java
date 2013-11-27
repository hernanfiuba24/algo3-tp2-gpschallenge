package fiuba.algo3.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class PanelInformacion extends JPanel {
	private JTextField movimientos;

	/**
	 * Create the panel.
	 */
	public PanelInformacion() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movimientos");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 43, 117, 23);
		add(lblNewLabel);
		
		movimientos = new JTextField();
		movimientos.setEditable(false);
		movimientos.setBounds(10, 68, 86, 20);
		add(movimientos);
		movimientos.setColumns(10);

	}
	
	public void actualizarMovimientos(int movimientos){
		this.movimientos.setText(String.valueOf(movimientos));
	}

}

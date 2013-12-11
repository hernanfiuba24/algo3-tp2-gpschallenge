package fiuba.algo3.vista;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class PanelInformacion extends JPanel {
	private JTextField movimientos;
	private JLabel imagenVehiculo;
	private JLabel NombreJugador;

	/**
	 * Create the panel.
	 */
	public PanelInformacion() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movimientos");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(10, 218, 160, 23);
		add(lblNewLabel);
		
		movimientos = new JTextField();
		movimientos.setFont(new Font("Verdana", Font.PLAIN, 12));
		movimientos.setEditable(false);
		movimientos.setBounds(16, 246, 86, 20);
		add(movimientos);
		movimientos.setColumns(10);
		
		JLabel lblEstadisticas = new JLabel("Estadisticas");
		lblEstadisticas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEstadisticas.setBounds(37, 11, 143, 14);
		add(lblEstadisticas);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblJugador.setBounds(10, 50, 160, 23);
		add(lblJugador);
		
		NombreJugador = new JLabel("");
		NombreJugador.setFont(new Font("Verdana", Font.ITALIC, 13));
		NombreJugador.setBounds(16, 75, 149, 23);
		add(NombreJugador);
		
		JLabel lblVehiculo = new JLabel("Vehiculo");
		lblVehiculo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblVehiculo.setBounds(10, 118, 160, 14);
		add(lblVehiculo);
		
		imagenVehiculo = new JLabel("");
		imagenVehiculo.setBounds(10, 143, 160, 64);
		add(imagenVehiculo);

	}
	
	public void actualizarMovimientos(int movimientos){
		this.movimientos.setText(String.valueOf(movimientos));
	}

	public void setNombreJugador(String unNombreDeJugador) {
		this.NombreJugador.setText(unNombreDeJugador);
	}
	
	public void actualizarVehiculo(Vehiculo unVehiculo){
		if (unVehiculo instanceof Auto){
			imagenVehiculo.setIcon(new ImageIcon(VentanaMapa.class
					.getResource("/fiuba/algo3/vista/imagenes/autoGrande.png")));
		}else{
			if (unVehiculo instanceof Moto){
				imagenVehiculo.setIcon(new ImageIcon(VentanaMapa.class
						.getResource("/fiuba/algo3/vista/imagenes/motoGrande.png")));
			}
			else{
				if (unVehiculo instanceof Camioneta){
					imagenVehiculo.setIcon(new ImageIcon(VentanaMapa.class
							.getResource("/fiuba/algo3/vista/imagenes/camionetaGrande.png")));
				}
			}
		}
	}
}

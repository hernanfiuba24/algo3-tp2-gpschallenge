package fiuba.algo3.vista;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class PanelInformacion extends JPanel {
	private JTextField movimientos;
	private JTextField movimientosRestantes;
	private JLabel imagenVehiculo;
	private JLabel NombreJugador;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelInformacion() {
		setLayout(null);
		setSize(180, 713);
		
		JLabel lblNewLabel = new JLabel("Movimientos");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(10, 204, 160, 23);
		add(lblNewLabel);
		
		movimientos = new JTextField();
		movimientos.setFont(new Font("Verdana", Font.PLAIN, 12));
		movimientos.setEditable(false);
		movimientos.setBounds(16, 232, 86, 20);
		add(movimientos);
		movimientos.setColumns(10);
		
		JLabel lblEstadisticas = new JLabel("Estadisticas");
		lblEstadisticas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEstadisticas.setBounds(37, 11, 143, 14);
		add(lblEstadisticas);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblJugador.setBounds(10, 36, 160, 23);
		add(lblJugador);
		
		NombreJugador = new JLabel("");
		NombreJugador.setFont(new Font("Verdana", Font.ITALIC, 13));
		NombreJugador.setBounds(16, 61, 149, 23);
		add(NombreJugador);
		
		JLabel lblVehiculo = new JLabel("Vehiculo");
		lblVehiculo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblVehiculo.setBounds(10, 104, 160, 14);
		add(lblVehiculo);
		
		agregarReferencias();
		
		imagenVehiculo = new JLabel("");
		imagenVehiculo.setBounds(10, 129, 160, 64);
		add(imagenVehiculo);
		
		JLabel lblMovimientosRestantes = new JLabel("Movimientos");
		lblMovimientosRestantes.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblMovimientosRestantes.setBounds(10, 263, 99, 14);
		add(lblMovimientosRestantes);
		
		JLabel lblRestantes = new JLabel("Restantes");
		lblRestantes.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblRestantes.setBounds(10, 279, 108, 14);
		add(lblRestantes);
		
		movimientosRestantes = new JTextField();
		movimientosRestantes.setEditable(false);
		movimientosRestantes.setBounds(16, 301, 86, 20);
		add(movimientosRestantes);
		movimientosRestantes.setColumns(10);

	}
	
	public void agregarReferencias(){
		JLabel etiquetaLeyenda = new JLabel("Leyenda");
		etiquetaLeyenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		etiquetaLeyenda.setBounds(10, 332, 71, 23);
		add(etiquetaLeyenda);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(10, 356, 120, 143);
		add(panel);
		
		JLabel leyendaSorpresa = new JLabel("Sorpresa");
		leyendaSorpresa.setPreferredSize(new Dimension(100, 30));
		leyendaSorpresa.setBounds(new Rectangle(6, 0, 0, 0));
		leyendaSorpresa.setHorizontalAlignment(SwingConstants.LEFT);
		leyendaSorpresa.setVerticalAlignment(SwingConstants.BOTTOM);
		leyendaSorpresa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		leyendaSorpresa.setIcon(new ImageIcon(VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/sorpresa.png")));
		panel.add(leyendaSorpresa);
		
		JLabel leyendaPiquete = new JLabel("Piquete");
		leyendaPiquete.setPreferredSize(new Dimension(100, 30));
		leyendaPiquete.setIcon(new ImageIcon(VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/piquete.png")));
		leyendaPiquete.setVerticalAlignment(SwingConstants.BOTTOM);
		leyendaPiquete.setHorizontalAlignment(SwingConstants.LEFT);
		leyendaPiquete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(leyendaPiquete);
		
		JLabel leyendaPolicia = new JLabel("Policia");
		leyendaPolicia.setPreferredSize(new Dimension(100, 30));
		leyendaPolicia.setIcon(new ImageIcon(VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/policia.png")));
		leyendaPolicia.setVerticalAlignment(SwingConstants.BOTTOM);
		leyendaPolicia.setHorizontalAlignment(SwingConstants.LEFT);
		leyendaPolicia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(leyendaPolicia);
		
		JLabel leyendaPozo = new JLabel("Pozo");
		leyendaPozo.setPreferredSize(new Dimension(100, 30));
		leyendaPozo.setIcon(new ImageIcon(VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/pozo.png")));
		leyendaPozo.setVerticalAlignment(SwingConstants.BOTTOM);
		leyendaPozo.setHorizontalAlignment(SwingConstants.LEFT);
		leyendaPozo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(leyendaPozo);
	}
	
	public void actualizarMovimientos(int movimientos){
		this.movimientos.setText(String.valueOf(movimientos));
	}
	
	public void actualizarMovimientosRestantes(int movimientosRestantes){
		this.movimientosRestantes.setText(String.valueOf(movimientosRestantes));
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

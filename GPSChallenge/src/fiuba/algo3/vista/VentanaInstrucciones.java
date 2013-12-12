package fiuba.algo3.vista;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaInstrucciones extends JFrame {

	public VentanaInstrucciones() throws HeadlessException {
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 225);
		
		JPanel panelTexto = new JPanel();
		panelTexto.setBounds(0, 36, 434, 184);
		getContentPane().add(panelTexto);
		panelTexto.setLayout(null);
		
		JLabel lblGpsChallenge = new JLabel("GPS Challenge");
		lblGpsChallenge.setHorizontalAlignment(SwingConstants.CENTER);
		lblGpsChallenge.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblGpsChallenge.setBounds(148, 11, 141, 36);
		panelTexto.add(lblGpsChallenge);
		
		JLabel lblNewLabel = new JLabel("Gps Challenge es un juego para toda la familia, lleno de diversion, donde");
		lblNewLabel.setBounds(10, 46, 424, 14);
		panelTexto.add(lblNewLabel);
		
		JLabel lblQueElegirEl = new JLabel("usted tendra que elegir el vehiculo con el que quiere comenzar, y dirigirlo");
		lblQueElegirEl.setBounds(10, 58, 424, 14);
		panelTexto.add(lblQueElegirEl);
		
		JLabel lblLasFlechasDel = new JLabel("hacia la meta utilizando las flechas del teclado. Con cuidado, ya que va a");
		lblLasFlechasDel.setBounds(10, 71, 424, 14);
		panelTexto.add(lblLasFlechasDel);
		
		JLabel lblRestaranPuntosY = new JLabel("enfrentarse a obstaculos que le restaran puntos y sumaran movimiento. o");
		lblRestaranPuntosY.setBounds(10, 83, 424, 14);
		panelTexto.add(lblRestaranPuntosY);
		
		JLabel lblSasQueLe = new JLabel(" directamente no lo dejaran pasar, o sorpresas que le ayudaran a sumar");
		lblSasQueLe.setBounds(10, 96, 424, 14);
		panelTexto.add(lblSasQueLe);
		
		JLabel lblElGranGanador = new JLabel("mas puntos y restar movimientos, y asi usted pueda ser el gran ganador.");
		lblElGranGanador.setBounds(10, 108, 424, 14);
		panelTexto.add(lblElGranGanador);
		
		JLabel imagenfondo = new JLabel("");
		imagenfondo.setBounds(0, 0, 434, 261);
		imagenfondo.setIcon(new ImageIcon(VentanaRanking.class.getResource("/fiuba/algo3/vista/imagenes/background_flag_color.jpg")));
		getContentPane().add(imagenfondo);
		
		
		
	}
}

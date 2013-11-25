package fiuba.algo3.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.controlador.ControladorJuego;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.direccion.Izquierda;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class VentanaJuego extends JFrame implements KeyListener {

	private JPanel contentPane;
	private PanelMapa panelMapa;
	private final Action action = new SwingAction();
	private boolean seGuardoJuego = false;
    private ControladorJuego unControladorJuego;
    private Juego unJuego;

	/**
	 * Create the frame.
	 * @throws ExcepcionEsquinaInvalida 
	 */
	public VentanaJuego() throws ExcepcionEsquinaInvalida {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addKeyListener(this);
		setFocusable(true);
		this.unJuego = new Juego();
		
		panelMapa = new PanelMapa(this.unJuego.devolverMapaFila(), this.unJuego.devolverMapaColumna());
		panelMapa.setBounds(5, 5, 660, 730);    
		contentPane.add(panelMapa);
		panelMapa.setLayout(null);
		
		this.unControladorJuego = new ControladorJuego(this.unJuego, panelMapa);

		JButton btnSalirMapa = new JButton(new ImageIcon(
				VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/botonSalirMapa.png")));
		btnSalirMapa.setBorder(BorderFactory.createEmptyBorder());
		btnSalirMapa.setContentAreaFilled(false);
		btnSalirMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int eleccion = 0;
				if (!seGuardoJuego){
					eleccion = JOptionPane.showConfirmDialog(null,
						"Desea salir sin guardar?");
				}
				if (eleccion == 0) {
					JOptionPane.showMessageDialog(null,
							"Saliendo del GPSChallenge...");
					System.exit(0);
				}
				
			}
		});
		btnSalirMapa.setBounds(456, 609, 140, 46);
		contentPane.add(btnSalirMapa);

		JButton btnMenuMapa = new JButton(new ImageIcon(
				VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/botonMenuMapa.png")));
		btnMenuMapa.setBorder(BorderFactory.createEmptyBorder());
		btnMenuMapa.setContentAreaFilled(false);
		btnMenuMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPpal unaVentanaPpal = new VentanaPpal();
				unaVentanaPpal.setVisible(true);
			}
		});
		btnMenuMapa.setBounds(456, 566, 141, 46);
		contentPane.add(btnMenuMapa);

		JButton btnGuardarMapa = new JButton(new ImageIcon(
				VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/botonGuardarMapa.png")));
		btnGuardarMapa.setBorder(BorderFactory.createEmptyBorder());
		btnGuardarMapa.setContentAreaFilled(false);
		btnGuardarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//EN ESTA PARTE SE LLAMARIA AL METODO QUE SE ENCARGA DE LA PERSISITENCIA
				seGuardoJuego = true;
				JOptionPane.showMessageDialog(null, "Guardando partida...");
			}
		});
		btnGuardarMapa.setBounds(456, 523, 141, 46);
		contentPane.add(btnGuardarMapa);

		// panel_2.setBackgroundImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Samsung\\EclipseWorkspace\\GPSChallenge\\images\\bgImage.jpg"));
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()){
			case KeyEvent.VK_UP:
				this.unJuego.jugar(new Arriba());
				//panelMapa.moverArriba();
				break;
			case KeyEvent.VK_DOWN:
				this.unJuego.jugar(new Abajo());
				//panelMapa.moverAbajo();
				break;
			case KeyEvent.VK_RIGHT:
				this.unJuego.jugar(new Derecha());
				//panelMapa.moverDerecha();
				break;
			case KeyEvent.VK_LEFT:
				this.unJuego.jugar(new Izquierda());
				//panelMapa.moverIzquierda();
				break;
		}	
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

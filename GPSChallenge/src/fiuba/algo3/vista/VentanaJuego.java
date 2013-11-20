package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private PanelMapa panelMapa;
	private final Action action = new SwingAction();


	/**
	 * Create the frame.
	 */
	public VentanaJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnArriba = new JButton(new ImageIcon(
				VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/botonArriba.png")));
		btnArriba.setBorder(BorderFactory.createEmptyBorder());
		btnArriba.setContentAreaFilled(false);
		btnArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMapa.moverArriba();
			}
		});
		btnArriba.setBounds(98, 512, 126, 52);
		contentPane.add(btnArriba);

		panelMapa = new PanelMapa();
		panelMapa.setBounds(5, 5, 674, 507);
		contentPane.add(panelMapa);
		panelMapa.setLayout(null);


		JButton btnIzquierda = new JButton(new ImageIcon(
				VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/botonIzquierda.png")));
		btnIzquierda.setBorder(BorderFactory.createEmptyBorder());
		btnIzquierda.setContentAreaFilled(false);
		btnIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMapa.moverIzquierda();
			}
		});
		btnIzquierda.setBounds(30, 557, 126, 52);
		contentPane.add(btnIzquierda);

		JButton btnDerecha = new JButton(new ImageIcon(
				VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/botonDerecha.png")));
		btnDerecha.setBorder(BorderFactory.createEmptyBorder());
		btnDerecha.setContentAreaFilled(false);
		btnDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMapa.moverDerecha();
			}
		});
		btnDerecha.setBounds(161, 555, 134, 57);
		contentPane.add(btnDerecha);

		JButton btnAbajo = new JButton(new ImageIcon(
				VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/botonAbajo.png")));
		btnAbajo.setBorder(BorderFactory.createEmptyBorder());
		btnAbajo.setContentAreaFilled(false);
		btnAbajo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMapa.moverAbajo();
			}
		});
		btnAbajo.setBounds(92, 602, 141, 52);
		contentPane.add(btnAbajo);

		JButton btnNewButton = new JButton(new ImageIcon(
				VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/botonSalirMapa.png")));
		btnNewButton.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int eleccion = JOptionPane.showConfirmDialog(null,
						"Desea salir sin guardar?");
				if (eleccion == 0) {
					JOptionPane.showMessageDialog(null,
							"Saliendo del GPSChallenge...");
					System.exit(0);
				}
			}
		});
		btnNewButton.setBounds(456, 609, 140, 46);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton(new ImageIcon(
				VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/botonMenuMapa.png")));
		btnNewButton_1.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPpal unaVentanaPpal = new VentanaPpal();
				unaVentanaPpal.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(456, 566, 141, 46);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(new ImageIcon(
				VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/botonGuardarMapa.png")));
		btnNewButton_2.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Guardando partida...");
			}
		});
		btnNewButton_2.setBounds(456, 523, 141, 46);
		contentPane.add(btnNewButton_2);

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

}

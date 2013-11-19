package fiuba.algo3.vista;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.modelo.Juego;


public class Ventana extends JFrame {

	private JPanel contentPane;
	private PanelMapa panelMapa;
	private Juego GPSChallenge;
	private final Action action = new SwingAction();
	private JButton Derecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelMapa = new PanelMapa();
		panelMapa.setBounds(5, 5, 609, 492);
		contentPane.add(panelMapa);
		panelMapa.setLayout(null);
		
		JButton btnArriba = new JButton("Arriba");
		btnArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelMapa.moverArriba();
			}
		});
		btnArriba.setBounds(121, 508, 89, 23);
		contentPane.add(btnArriba);
		
		JButton btnIzquierda = new JButton("Izquierda");
		btnIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMapa.moverIzquierda();
			}
		});
		btnIzquierda.setBounds(30, 525, 89, 23);
		contentPane.add(btnIzquierda);
		
		Derecha = new JButton("Derecha");
		Derecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMapa.moverDerecha();
			}
		});
		Derecha.setBounds(213, 525, 89, 23);
		contentPane.add(Derecha);
		
		JButton btnAbajo = new JButton("Abajo");
		btnAbajo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMapa.moverAbajo();
			}
		});
		btnAbajo.setBounds(121, 542, 89, 23);
		contentPane.add(btnAbajo);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(428, 508, 159, 63);
		contentPane.add(btnNewButton);
		
		//panel_2.setBackgroundImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Samsung\\EclipseWorkspace\\GPSChallenge\\images\\bgImage.jpg"));
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

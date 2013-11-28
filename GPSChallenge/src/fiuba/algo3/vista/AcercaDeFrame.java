package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AcercaDeFrame extends JFrame {

	public AcercaDeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPS Challenge/Acerca De");
		setBounds(100, 100, 487, 215);
		getContentPane().setLayout(null);

		JLabel lblGpsChallenge = new JLabel("GPS Challenge");
		lblGpsChallenge
				.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblGpsChallenge.setBounds(157, 11, 139, 19);
		getContentPane().add(lblGpsChallenge);

		JLabel lblversion = new JLabel("-Version 1.0");
		lblversion.setBounds(53, 43, 112, 14);
		getContentPane().add(lblversion);

		JLabel lbldesarrolladoPorHernan = new JLabel(
				"-Desarrollado por: Hernan Arroyo, Nicolas Carolo, Ezequiel Grillo,");
		lbldesarrolladoPorHernan.setBounds(53, 64, 408, 34);
		getContentPane().add(lbldesarrolladoPorHernan);

		JLabel lblMartinStancanelli = new JLabel("Martin Stancanelli.");
		lblMartinStancanelli.setBounds(143, 93, 201, 14);
		getContentPane().add(lblMartinStancanelli);

		JLabel lblcontatenosSugerenciasgpschallengecom = new JLabel(
				"-Contactenos: sugerencias@gpschallenge.com");
		lblcontatenosSugerenciasgpschallengecom.setBounds(53, 118, 352, 19);
		getContentPane().add(lblcontatenosSugerenciasgpschallengecom);

		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(372, 143, 89, 23);
		getContentPane().add(btnOk);
	}
}

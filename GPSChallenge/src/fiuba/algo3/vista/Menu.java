package fiuba.algo3.vista;

import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.BevelBorder;

public class Menu extends JMenuBar {
	
	private AccionMenues accionGuardar;
	private VentanaJuego ventanaPerteneciente;
	

	public Menu(){
		JMenu opciones = this.crearMenuOpciones();
		add(opciones);
		
		JMenu ayuda = this.crearMenuAyuda(); 
		add(ayuda);
	}
	
	public Menu(VentanaJuego ventanaConFunciones) {
		this.ventanaPerteneciente = ventanaConFunciones;
		JMenu opciones = this.crearMenuOpciones();
		add(opciones);
		
		JMenu ayuda = this.crearMenuAyuda(); 
		add(ayuda);
	}

	private JMenu crearMenuAyuda() {
		JMenu ayuda = new JMenu("Ayuda");
		ayuda.setSize(new Dimension(50,20));
		ayuda.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		AccionMenues accionInstrucciones = new AccionMenues("Instrucciones");
		AccionMenues accionAcercaDe = new AccionMenues("Acerca De");
		
		ayuda.add(accionInstrucciones);
		ayuda.add(accionAcercaDe);
		
		return ayuda;
	}

	private JMenu crearMenuOpciones(){
		JMenu opciones = new JMenu("Opciones");
		opciones.setSize(new Dimension(50,20));
		opciones.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		this.accionGuardar = new AccionMenues("Guardar");
		this.accionGuardar.setearVentanaPerteneciente(this.ventanaPerteneciente);
		AccionMenues accionSalir = new AccionMenues("Salir");
		
		opciones.add(accionGuardar);
		opciones.add(accionSalir);
		
		return opciones;
	}
	
	public void deshabilitarGuardar(){
		this.accionGuardar.setEnabled(false);
	}
	
}
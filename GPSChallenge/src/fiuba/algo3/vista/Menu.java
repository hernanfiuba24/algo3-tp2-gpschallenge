package fiuba.algo3.vista;

import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.BevelBorder;

public class Menu extends JMenuBar {

	public Menu(){
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
		
		AccionMenues accionGuardar = new AccionMenues("Guardar");
		AccionMenues accionSalir = new AccionMenues("Salir");
		
		opciones.add(accionGuardar);
		opciones.add(accionSalir);
		
		return opciones;
	}
}

package fiuba.algo3.vista;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class AccionMenues  extends AbstractAction{
	
	String cadena;
	private VentanaJuego ventanaPerteneciente;
	
	public AccionMenues(String cadena)
	{
		super (cadena);
		this.cadena=cadena;
	}
		
	public void setearVentanaPerteneciente(VentanaJuego unaVentana){
		this.ventanaPerteneciente = unaVentana;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String accion=new String(e.getActionCommand());
		
		if (accion.equals("Salir"))
		{
			System.exit(0);
		}
		else if (accion.equals("Guardar"))
		{
			ventanaPerteneciente.guardarJuego();
		}
		else if (accion.equals("Acerca De")){
			AcercaDeFrame acercaDe = new AcercaDeFrame();
			acercaDe.setVisible(true);
		}
		else if (accion.equals("Instrucciones")){
			VentanaInstrucciones ventanaInstrucciones = new VentanaInstrucciones();
			ventanaInstrucciones.setVisible(true);
		}
	}

}
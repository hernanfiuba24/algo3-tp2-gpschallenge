package fiuba.algo3.vista;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class AccionMenues  extends AbstractAction{ //Clase interna para los eventos de ratón en la barra de menúes.
	
	String cadena;
	public AccionMenues(String cadena)
	{
		super (cadena);
		this.cadena=cadena;
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
			
		}
		else if (accion.equals("Acerca De")){
			AcercaDeFrame acercaDe = new AcercaDeFrame();
			acercaDe.setVisible(true);
		}
	}

}
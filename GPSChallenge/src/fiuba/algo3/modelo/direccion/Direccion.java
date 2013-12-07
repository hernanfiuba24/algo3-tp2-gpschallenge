package fiuba.algo3.modelo.direccion;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Posicion;

public abstract class Direccion {
	
	protected int x; //  posicion de las fila (en el eje vertical)
	protected int y; //  posicion de la columna (en el eje horizontal)
	
	public int devolverX() {
		return this.x;
	}
	
	public int devolverY(){
		return this.y;
	}

	public abstract Direccion cambiarDireccionContraria();

//	PUBLIC NODE TOXML(DOCUMENT DOC) {
//		ELEMENT XMLELEMENT = DOC.CREATEELEMENT("DIRECCION");
//		XMLELEMENT.SETATTRIBUTE("X", STRING.VALUEOF(THIS.X));
//		XMLELEMENT.SETATTRIBUTE("Y", STRING.VALUEOF(THIS.Y));
//
//		RETURN XMLELEMENT;
//	}
	
}

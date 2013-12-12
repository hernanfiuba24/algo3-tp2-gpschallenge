package fiuba.algo3.modelo;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.obstaculo.Bandera;

public class Mapa {
	private int filas;
	private int columnas;
	private Esquina[][] tablero;

	public Mapa(int fila, int columna) {
		filas = fila;
		columnas = columna;

		tablero = new Esquina[fila][columna];
		for (int i = 1; i <= this.devolverAlto(); i++) {
			for (int j = 1; j <= this.devolverAncho(); j++) {
				Posicion posicion = new Posicion(i, j);
				Esquina esquina = new Esquina(posicion);
				agregarUnaEsquina(esquina, posicion);
			}
		}
	}

	public int devolverAlto() {
		return this.filas;
	}

	public int devolverAncho() {
		return this.columnas;
	}

	public boolean existeEsquina(Posicion unaPosicion) {
		if ((unaPosicion.devolverPosicionAlto() > this.filas)
				|| (unaPosicion.devolverPosicionAlto() <= 0)) {
			return false;
		}
		if ((unaPosicion.devolverPosicionAncho() > this.columnas)
				|| (unaPosicion.devolverPosicionAncho() <= 0)) {
			return false;
		}
		return true;
	}

	public Esquina devolverUnaEsquina(Posicion unaPosicion)
			throws ExcepcionEsquinaInvalida {
		if (this.existeEsquina(unaPosicion)) {
			return tablero[unaPosicion.devolverPosicionAlto() - 1][unaPosicion
					.devolverPosicionAncho() - 1];
		} else {
			throw new ExcepcionEsquinaInvalida();
		}
	}

	private void agregarUnaEsquina(Esquina unaEsquina, Posicion unaPosicion) {
		tablero[unaPosicion.devolverPosicionAlto() - 1][unaPosicion
				.devolverPosicionAncho() - 1] = unaEsquina;
	}

	public void setearBandera(Posicion posicionBandera)
			throws ExcepcionEsquinaInvalida {
		if (this.existeEsquina(posicionBandera)) {
			this.devolverUnaEsquina(posicionBandera).setearObstaculo(new Bandera());
		}
	}

	public Node toXml(Document doc) throws DOMException, ExcepcionEsquinaInvalida {
		Element xmlElement = doc.createElement("Mapa");
		xmlElement.setAttribute("Alto", String.valueOf(this.filas));
		xmlElement.setAttribute("Ancho", String.valueOf(this.columnas));

		for (int i = 1; i <= this.filas; i++){
			for (int j = 1; j <= this.columnas; j++){
				if (this.existeEsquina(new Posicion(i,j)))
					xmlElement.appendChild(this.devolverUnaEsquina(new Posicion(i,j)).toXml(doc));
			}
		}
		return xmlElement;
	}

}
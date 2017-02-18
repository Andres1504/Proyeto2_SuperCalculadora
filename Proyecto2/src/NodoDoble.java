
public class NodoDoble {	
	private NodoDoble siguiente;
	private NodoDoble anterior;
	private long dato;
	
	public NodoDoble() {}
	
	public NodoDoble getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoDoble siguiente) {
		this.siguiente = siguiente;
	}
	public NodoDoble getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoDoble anterior) {
		this.anterior = anterior;
	}
	public long getDato() {
		return dato;
	}
	public void setDato(long dato2) {
		this.dato = dato2;
	}


}

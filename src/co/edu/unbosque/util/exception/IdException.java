package co.edu.unbosque.util.exception;

public class IdException extends Exception {
	
	public IdException() {
		super("No se permiten mas de 10 caracteres, numeros negativos, simbolos o letras");
	}
	
	public IdException(String msg) {
		super(msg);
	}
	

}

package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface DAO <E>{

	public void crear(E nuevoDato);
	public boolean eliminar(int index);
	public boolean actualizar(int index,E datoActualziado);
	//esto es polimorfismo de sobre carga
	public String mostrar();
	public String mostrar(int index);
	
	public ArrayList<E> mostrarTodo();
	
}

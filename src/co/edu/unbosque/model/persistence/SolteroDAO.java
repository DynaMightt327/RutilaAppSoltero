package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.Soltero;

public class SolteroDAO implements DAO<Soltero>{
	
	private ArrayList<Soltero> listaSolteros;
	private final String URL_ARCHIVO_TEXTO = "solteros.csv";
	private final String URL_ARCHIVO_SERIALIZADO = "solteros.dat";
	
	public SolteroDAO() {
		listaSolteros = new ArrayList<>();
		leerSerializado();
	}

	@Override
	public void crear(Soltero nuevoDato) {
		listaSolteros.add(nuevoDato);
		escribirArchivo();
		escribirSerializado();
	}

	@Override
	public boolean eliminar(int index) {
		if(index < 0 || index >= listaSolteros.size()) {
			return false;
		}else {
			listaSolteros.remove(index);
			escribirArchivo();
			escribirSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int index, Soltero datoActualziado) {
		if(index <0 || index >= listaSolteros.size()) {
			return false;
		}else {
			listaSolteros.set(index, datoActualziado);
			escribirArchivo();
			escribirSerializado();
			return true;
		}
	}

	@Override
	public String mostrar() {
		String dato = "";
		int posicion = 0;
		for (Soltero soltero : listaSolteros) {
			dato += posicion + "";
			dato += soltero.toString() + "\n";
		}
		return dato;
	}

	@Override
	public String mostrar(int index) {
		return listaSolteros.get(index).toString();
	}

	@Override
	public ArrayList<Soltero> mostrarTodo() {
		return listaSolteros;
	}

	public ArrayList<Soltero> getListaSolteros() {
		return listaSolteros;
	}

	public void setListaSolteros(ArrayList<Soltero> listaSolteros) {
		this.listaSolteros = listaSolteros;
	}
	
	public Soltero buscarPorDocumento(long numeroDocumento) {
	    for (Soltero soltero : listaSolteros) {
	        if (soltero.getNumeroDocumento() == numeroDocumento) {
	            return soltero;
	        }
	    }
	    return null;
	}
	
//	METODOS AUXILIARES PARA ARCHIVOS DE TEXTO Y SERIALIZADOS
	public void escribirArchivo() {
		StringBuilder sb = new StringBuilder();
		for (Soltero soltero : listaSolteros) {
			sb.append(soltero.toString() + "\n");
		}
		FileHandler.crearYEscribirArchivo("solteros.csv", sb.toString());
	}
	
	public void escribirSerializado() {
		FileHandler.crearYEscribirArchivoSerializado(URL_ARCHIVO_SERIALIZADO, listaSolteros);
	}
	
	public void leerSerializado() {
		Object contenido = FileHandler.crearYLeerSerializable(URL_ARCHIVO_SERIALIZADO);
		if(contenido == null) {
			listaSolteros = new ArrayList<Soltero>();
		}else {
			listaSolteros = (ArrayList<Soltero>) contenido;
		}
	}

}

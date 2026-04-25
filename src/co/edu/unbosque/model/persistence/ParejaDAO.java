package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pareja;

public class ParejaDAO implements DAO<Pareja>{
	
	private ArrayList<Pareja> listaParejas;
    private final String URL_ARCHIVO_TEXTO = "parejas.csv";
    private final String URL_ARCHIVO_SERIALIZADO = "parejas.dat";
    
    public ParejaDAO() {
    	listaParejas = new ArrayList<>();
    	leerSerializado();
    }

	@Override
	public void crear(Pareja nuevoDato) {
		listaParejas.add(nuevoDato);
        escribirArchivo();
        escribirSerializado();
	}

	@Override
	public boolean eliminar(int index) {
		if (index < 0 || index >= listaParejas.size()) {
            return false;
        } else {
            listaParejas.remove(index);
            escribirArchivo();
            escribirSerializado();
            return true;
        }
	}
	
	@Override
	public boolean actualizar(int index, Pareja datoActualziado) {
		if (index < 0 || index >= listaParejas.size()) {
            return false;
        } else {
            listaParejas.set(index, datoActualziado);
            escribirArchivo();
            escribirSerializado();
            return true;
        }
	}

	@Override
	public String mostrar() {
		String dato = "";
        int posicion = 0;
        for (Pareja pareja : listaParejas) {
            dato += posicion + "";
            dato += pareja.toString() + "\n";
            posicion++;
        }
        return dato;
	}

	@Override
	public String mostrar(int index) {
		return listaParejas.get(index).toString();
	}

	@Override
	public ArrayList<Pareja> mostrarTodo() {
		return listaParejas;
	}
	
	// MÉTODOS AUXILIARES PARA ARCHIVOS
    public void escribirArchivo() {
        StringBuilder sb = new StringBuilder();
        for (Pareja pareja : listaParejas) {
            sb.append(pareja.toString() + "\n");
        }
        FileHandler.crearYEscribirArchivo(URL_ARCHIVO_TEXTO, sb.toString());
    }

    public void escribirSerializado() {
        FileHandler.crearYEscribirArchivoSerializado(URL_ARCHIVO_SERIALIZADO, listaParejas);
    }

    public void leerSerializado() {
        Object contenido = FileHandler.crearYLeerSerializable(URL_ARCHIVO_SERIALIZADO);
        if (contenido == null) {
            listaParejas = new ArrayList<Pareja>();
        } else {
            listaParejas = (ArrayList<Pareja>) contenido;
        }
    }

    public ArrayList<Pareja> getListaParejas() {
        return listaParejas;
    }

    public void setListaParejas(ArrayList<Pareja> listaParejas) {
        this.listaParejas = listaParejas;
    }

}

package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {

	private static File archivo;
	private Scanner lector; 
	private static PrintWriter escritor;
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;
	
	public static void crearCarpetaPrincipal() { 
													
		archivo = new File("files");
		if (!archivo.isDirectory() || !archivo.exists()) {
			archivo.mkdir();
		}
	}

	public static void crearYEscribirArchivo(String url, String contenido) {
		try {
			archivo = new File("files/" + url); 
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void crearYEscribirArchivoSerializado(String url, Object contenido) {
		archivo = new File("files/" + url);
		try {
			if(!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
	}
	
	public static String crearYLeerArchivo(String url) {
		archivo = new File("files/" + url);
		StringBuilder sb = new StringBuilder();
		try {
			if(!archivo.exists()) {
				archivo.createNewFile();
			}
			Scanner leer = new Scanner(archivo);
			while(leer.hasNext()) {
				sb.append(leer.nextLine() + "\n");
			}
			leer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static Object crearYLeerSerializable(String url) {
		archivo = new File("files/" + url);
			
		try {
			if(!archivo.exists()) {
				archivo.createNewFile();
			}
			
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			Object contenido = ois.readObject();
			ois.close();
			fis.close();
			
			return contenido;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

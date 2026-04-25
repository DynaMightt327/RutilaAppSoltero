package co.edu.unbosque.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Pareja;
import co.edu.unbosque.model.Soltero;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.model.persistence.ParejaDAO;
import co.edu.unbosque.model.persistence.SolteroDAO;
import co.edu.unbosque.util.exception.BornDateException;
import co.edu.unbosque.util.exception.ComboBoxException;
import co.edu.unbosque.util.exception.IdException;
import co.edu.unbosque.util.exception.ImageNotSelectedException;
import co.edu.unbosque.util.exception.LastNameException;
import co.edu.unbosque.util.exception.NameException;
import co.edu.unbosque.util.exception.UniversityCarrerException;
import co.edu.unbosque.util.exception.UniversityException;
import co.edu.unbosque.view.VentanaInicial;
import co.edu.unbosque.view.VentanaIniciarSesion;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VentanaRegistroPersona;

public class Controller implements ActionListener, ListSelectionListener {

	private SolteroDAO sDAO;
	private ParejaDAO pDAO;
	private Soltero solteroActual;

	private VentanaInicial vi;
	private VentanaRegistroPersona vrp;
	private VentanaIniciarSesion vis;
	private VentanaPrincipal vp;

	public Controller() {
		FileHandler.crearCarpetaPrincipal();
		sDAO = new SolteroDAO();
		pDAO = new ParejaDAO();

		vi = new VentanaInicial();
		vrp = new VentanaRegistroPersona();
		vis = new VentanaIniciarSesion();
		vp = new VentanaPrincipal();

		asignarOyentes();
	}

	public void asignarOyentes() {
		// ------VENTANA INICIAL---------
		vi.getIniciar().addActionListener(this);
		vi.getIniciar().setActionCommand("boton_iniciar");

		// ------VENTANA REGISTRO PERSONA------
		vrp.getGuardarPersona().addActionListener(this);
		vrp.getGuardarPersona().setActionCommand("boton_registrar");

		vrp.getSubirFoto().addActionListener(this);
		vrp.getSubirFoto().setActionCommand("boton_subir_foto");

		vrp.getIniciarSesion().addActionListener(this);
		vrp.getIniciarSesion().setActionCommand("boton_iniciar_sesion");

		// ------VENTANA INICIAR SESIÓN--------
		vis.getEntrar().addActionListener(this);
		vis.getEntrar().setActionCommand("boton_entrar_app");

		// ------VENTANA PRINCIPAL--------
		vp.getVerPareja().addActionListener(this);
		vp.getVerPareja().setActionCommand("boton_ver_parejas");

		vp.getVerSoltero().addActionListener(this);
		vp.getVerSoltero().setActionCommand("boton_ver_solteros");

		vp.getMiPerfil().addActionListener(this);
		vp.getMiPerfil().setActionCommand("boton_ver_perfil");
		
		vp.getPanelSoltero().getEmparejar().addActionListener(this);
		vp.getPanelSoltero().getEmparejar().setActionCommand("boton_emparejar");

		vp.getPanelSoltero().getTablaSoltero().getSelectionModel().addListSelectionListener(this);

		// --------BOTONES PARA VOLVER A VENTANA ANTERIOR--------
		vp.getVolver().addActionListener(this);
		vp.getVolver().setActionCommand("boton_volver_vp");

		vrp.getVolver().addActionListener(this);
		vrp.getVolver().setActionCommand("boton_volver_vrp");

		vis.getVolver().addActionListener(this);
		vis.getVolver().setActionCommand("boton_volver_vis");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();
		switch (alias) {
		// ---------VENTANA INICIAL--------
		case "boton_iniciar": {
			vi.setVisible(false);
			vrp.setVisible(true);
			break;
		}
		// -----------VENTANA REGISTRO PERSONA----------
		case "boton_registrar": {
			registrarSoltero();
			break;
		}
		case "boton_iniciar_sesion": {
			vrp.setVisible(false);
			vis.setVisible(true);
			break;
		}
		case "boton_volver_vrp": {
			vrp.setVisible(false);
			vi.setVisible(true);
			break;
		}
		case "boton_subir_foto": {
			subirFoto();
			break;
		}
		// -----------VENTANA INICIAR SESION--------
		case "boton_entrar_app": {
			iniciarSesion();
			break;
		}
		case "boton_volver_vis": {
			vis.setVisible(false);
			vrp.setVisible(true);
			break;
		}
		// -----------VENTANA PRINCIPAL--------
		case "boton_ver_parejas": {
			vp.getPanelSoltero().setVisible(false);
			vp.getPanelMiPerfil().setVisible(false);
			vp.getPanelPareja().setVisible(true);
			break;
		}
		case "boton_ver_solteros": {
			vp.getPanelPareja().setVisible(false);
			vp.getPanelMiPerfil().setVisible(false);
			vp.getPanelSoltero().setVisible(true);
			mostrarTodosLosSolteros();
			break;
		}
		case "boton_ver_perfil": {
			vp.getPanelPareja().setVisible(false);
			vp.getPanelSoltero().setVisible(false);
			vp.getPanelMiPerfil().setVisible(true);
			mostrarMiPerfil();
			break;
		}
		case "boton_emparejar":{
			emparejarConSoltero();
			break;
		}
		case "boton_volver_vp": {
			vp.setVisible(false);
			vis.setVisible(true);
			break;
		}
		default:
			break;
		}

	}

	// === MÉTODOS PARA REGISTRAR ===

	public void subirFoto() {
		try {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagen PNG", "png", "jpeg", "jpg");
			chooser.setFileFilter(filter);
			chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
			int result = chooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = chooser.getSelectedFile();
				String fileName = selectedFile.getName();

				File destinationFolder = new File("sources");
				if (!destinationFolder.exists()) {
					destinationFolder.mkdirs();
				}
				File destinationFile = new File(destinationFolder, fileName);

				try {
					Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
					return;
				}
				vrp.setRutaImagenSeleccionada("sources/" + fileName);

				ImageIcon image = new ImageIcon(destinationFile.getAbsolutePath());
				ImageIcon scaled = new ImageIcon(image.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH));
				vrp.getFotoPreview().setIcon(scaled);

				JOptionPane.showMessageDialog(null, "Imagen cargada con éxito");

			} else {
				// excepcion de imagen no seleccionada
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public int calcularEdad(String fechaNacimiento) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formatter);
			LocalDate hoy = LocalDate.now();
			return Period.between(fechaNac, hoy).getYears();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(vi, "Eres menor de edad aún. No es posible tu ingreso al bar**");
			return 0;
		}
	}

	public void registrarSoltero() {
		try {
			String nombre = vrp.getNombre().getText();
			verificarNombre(nombre);

			String apellido = vrp.getApellido().getText();
			verificarApellido(apellido);

			String fechaNacimiento = vrp.getFechaNacimiento().getText();
			verificarFechaNacimiento(fechaNacimiento);

			String genero = (String) vrp.getGenero().getSelectedItem();
			verificarComboBox(genero);

			long numeroDocumento = (long) Long.parseLong(vrp.getDocumento().getText());
			verificarDocumento(numeroDocumento);

			String universidad = vrp.getUniversidad().getText();
			verificarNombreUniversidad(universidad);

			String progAcademico = vrp.getProgAcademico().getText();
			verificarCarrera(progAcademico);

			String rutaFotoPerfil = vrp.getRutaImagenSeleccionada();
			verificarImagenSeleccionada(rutaFotoPerfil);

			sDAO.crear(new Soltero(nombre, apellido, fechaNacimiento, genero, numeroDocumento, universidad,
					progAcademico, rutaFotoPerfil));
			JOptionPane.showMessageDialog(null, "Soltero registrado con éxito¡!");

			limpiarCamposRegistroSoltero();

			vrp.setVisible(false);
			vis.setVisible(true);
		} catch (BornDateException e) {
			JOptionPane.showMessageDialog(null, "La fecha de nacimiento no es correcta");
		} catch (ComboBoxException e) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado su género.");
		} catch (IdException e) {
			JOptionPane.showMessageDialog(null, "Número de documento no válido");
		} catch (LastNameException e) {
			JOptionPane.showMessageDialog(null, "Apellido no válido");
		} catch (NameException e) {
			JOptionPane.showMessageDialog(null, "Nombre no válido");
		} catch (UniversityException e) {
			JOptionPane.showMessageDialog(null, "Nombre de universidad no válido.");
		} catch (UniversityCarrerException e) {
			JOptionPane.showMessageDialog(null, "Carrera universitaria no válida.");
		} catch (ImageNotSelectedException e) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado una foto de perfil.");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Número de documento no válido");
		}

	}

	public void limpiarCamposRegistroSoltero() {
		vrp.getNombre().setText("");
		vrp.getApellido().setText("");
		vrp.getFechaNacimiento().setText("");
		vrp.getUniversidad().setText("");
		vrp.getProgAcademico().setText("");
		vrp.getDocumento().setText("");
		vrp.getGenero().setSelectedIndex(0);
		vrp.getFotoPreview().setIcon(null);
	}

	public void limpiarCampoInicioSesion() {
		vis.getNumDocumento().setText("");
	}

	public void iniciarSesion() {
		try {
			long numeroDocumento;
			try {
				numeroDocumento = Long.parseLong(vis.getNumDocumento().getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "No se encuentra registrado ese documento");
				return;
			}

			verificarDocumento(numeroDocumento);

			solteroActual = sDAO.buscarPorDocumento(numeroDocumento);

			if (solteroActual == null) {
				JOptionPane.showMessageDialog(null, "No se encuentra registrado ese documento");
				return;
			}

			JOptionPane.showMessageDialog(null, "Bienvenido, " + solteroActual.getNombre() + " a rutila");
			// aquí abres la ventana principal
			limpiarCampoInicioSesion();
			vis.setVisible(false);
			vp.setVisible(true);

		} catch (IdException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra registrado ese documento");
		}
	}
	
	public void mostrarMiPerfil() {
		vp.getPanelMiPerfil().getNombre().setText(solteroActual.getNombre());
		vp.getPanelMiPerfil().getApellido().setText(solteroActual.getApellido());
		vp.getPanelMiPerfil().getGenero().setText(String.valueOf(solteroActual.getGenero()));
		vp.getPanelMiPerfil().getUniversidad().setText(solteroActual.getUniversidad());
		vp.getPanelMiPerfil().getProgAcademico().setText(solteroActual.getProgAcademico());

		int edad = calcularEdad(solteroActual.getFechaNacimiento());
		vp.getPanelMiPerfil().getFechaNacimiento().setText(edad + " años");
		try {
			ImageIcon imagen = new ImageIcon(solteroActual.getRutaFotoPerfil());
			ImageIcon imagenEscalada = new ImageIcon(imagen.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
			vp.getPanelMiPerfil().getFotoPreview().setIcon(imagenEscalada);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void mostrarTodosLosSolteros() {
		String contenido = FileHandler.crearYLeerArchivo("solteros.csv");
		if (contenido == null || contenido.isBlank()) {
			return;
		}

		DefaultTableModel modelo = (DefaultTableModel) vp.getPanelSoltero().getTablaSoltero().getModel();
		modelo.setRowCount(0);

		String[] filas = contenido.split("\n");
		for (String fila : filas) {
			String[] columnas = fila.split(";");
			if (columnas.length < 8)
				continue;

			int edad = calcularEdad(columnas[2]);
			modelo.addRow(new Object[] { columnas[0], columnas[1], columnas[3], edad, columnas[5] });
		}
	}

	public void mostrarDetallesSolteroSeleccionado() {
		int fila = vp.getPanelSoltero().getTablaSoltero().getSelectedRow();
		if (fila == -1) {
			return;
		}

		DefaultTableModel modelo = (DefaultTableModel) vp.getPanelSoltero().getTablaSoltero().getModel();

		String nombreSeleccionado = modelo.getValueAt(fila, 0).toString();

		ArrayList<Soltero> lista = sDAO.getListaSolteros();

		for (Soltero solteroSeleccionado : lista) {
			if (solteroSeleccionado.getNombre().equals(nombreSeleccionado)) {
				vp.getPanelSoltero().getNombre().setText(solteroSeleccionado.getNombre());
				vp.getPanelSoltero().getApellido().setText(solteroSeleccionado.getApellido());
				vp.getPanelSoltero().getUniversidad().setText(solteroSeleccionado.getUniversidad());
				vp.getPanelSoltero().getGenero().setText(solteroSeleccionado.getGenero());
				vp.getPanelSoltero().getProgAcademico().setText(solteroSeleccionado.getProgAcademico());
				int edad = calcularEdad(solteroSeleccionado.getFechaNacimiento());
				vp.getPanelSoltero().getFechaNacimiento().setText(edad + " años");
				ImageIcon imagen = new ImageIcon(solteroSeleccionado.getRutaFotoPerfil());
				ImageIcon imagenEscalada = new ImageIcon(imagen.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
				vp.getPanelSoltero().getFotoPreview().setIcon(imagenEscalada);
				
				break;
			}
		}
	}
	
	public void emparejarConSoltero() {
		int fila = vp.getPanelSoltero().getTablaSoltero().getSelectedRow();
	    if (fila == -1) {
	        JOptionPane.showMessageDialog(null, "Selecciona un soltero para realizar esta acción");
	        return;
	    }

	    DefaultTableModel modelo = (DefaultTableModel) vp.getPanelSoltero().getTablaSoltero().getModel();
	    String nombreSeleccionado = modelo.getValueAt(fila, 0).toString();

	    Soltero solteroSeleccionado = null;
	    ArrayList<Soltero> listaSolteros = sDAO.getListaSolteros();

	    for (Soltero soltero : listaSolteros) {
	        if (soltero.getNombre().equals(nombreSeleccionado)) {
	            solteroSeleccionado = soltero;
	            break;
	        }
	    }

	    if (solteroSeleccionado == null) {
	        JOptionPane.showMessageDialog(null, "No se encontró el soltero");
	        return;
	    }

	    if (solteroSeleccionado.getNumeroDocumento() == solteroActual.getNumeroDocumento()) {
	        JOptionPane.showMessageDialog(null, "No puedes emparejarte contigo mismo");
	        return;
	    }
	    //falta para juntar la pareja y eliminar los solteros
	    JOptionPane.showMessageDialog(null, "¡Pareja formada con éxito!");

	    mostrarTodosLosSolteros();

	}
	
	// === VERIFICAR CAMPOS (EXCEPCIONES) ===

	public static void verificarComboBox(String genero) throws ComboBoxException {
		if (genero == null || genero.equals("...")) {
			throw new ComboBoxException();
		}
	}

	public static void verificarNombre(String nombre) throws NameException {
		if (nombre == null || nombre.isEmpty()) {
			throw new NameException();
		}
		if (!nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || nombre.length() < 5) {
			throw new NameException();
		}
	}

	public static void verificarNombreUniversidad(String universidad) throws UniversityException {
		if (universidad == null || universidad.isEmpty()) {
			throw new UniversityException();
		}
		if (!universidad.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || universidad.length() < 10) {
			throw new UniversityException();
		}
	}

	public static void verificarApellido(String apellido) throws LastNameException {
		if (apellido == null || apellido.isEmpty()) {
			throw new LastNameException();
		}
		if (!apellido.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || apellido.length() < 5) {
			throw new LastNameException();
		}
	}

	public static void verificarCarrera(String progAcademico) throws UniversityCarrerException {
		if (progAcademico == null || progAcademico.isEmpty()) {
			throw new UniversityCarrerException();
		}
		if (!progAcademico.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || progAcademico.length() < 5) {
			throw new UniversityCarrerException();
		}
	}

	public static void verificarFechaNacimiento(String fNacimiento) throws BornDateException {
		if (fNacimiento == null || fNacimiento.isEmpty()) {
			throw new BornDateException();
		}

		if (!fNacimiento.matches("^[0-9/]+$")) {
			throw new BornDateException();
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNacimiento;
		try {
			fechaNacimiento = LocalDate.parse(fNacimiento, formatter);
		} catch (DateTimeParseException e) {
			throw new BornDateException();
		}

		LocalDate hoy = LocalDate.now();
		int edad = Period.between(fechaNacimiento, hoy).getYears();

		if (edad < 18) {
			throw new BornDateException();
		}
	}

	public static void verificarDocumento(long numeroDocumento) throws IdException {

		String doc = Long.toString(numeroDocumento);
		if (!doc.matches("^[0-9]{8,10}$")) {
			throw new IdException();
		}
	}

	public static void verificarImagenSeleccionada(String imgurl) throws ImageNotSelectedException {
		if (imgurl == null || imgurl.isEmpty()) {
			throw new ImageNotSelectedException();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		 if (e.getValueIsAdjusting()) return;
		 mostrarDetallesSolteroSeleccionado();
	}

	public void iniciar() {
		vi.setVisible(true);
	}


}

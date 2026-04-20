package co.edu.unbosque.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.view.VentanaInicial;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VentanaRegistroPersona;

public class Controller implements ActionListener {

	private VentanaInicial vi;
	private VentanaRegistroPersona vrp;
	private VentanaPrincipal vp;

	public Controller() {
		vi = new VentanaInicial();
		vrp = new VentanaRegistroPersona();
		vp = new VentanaPrincipal();
		asignarOyentes();
	}

	public void asignarOyentes() {
		// ------VENTANA INICIAL---------
		vi.getIniciar().addActionListener(this);
		vi.getIniciar().setActionCommand("boton_iniciar");

		// ------VENTANA REGISTRO PERSONA------
		vrp.getGuardarPersona().addActionListener(this);
		vrp.getGuardarPersona().setActionCommand("boton_entrar");

		vrp.getSubirFoto().addActionListener(this);
		vrp.getSubirFoto().setActionCommand("boton_subir_foto");

		// ------VENTANA PRINCIPAL--------
		vp.getVerPareja().addActionListener(this);
		vp.getVerPareja().setActionCommand("boton_ver_parejas");

		vp.getVerSoltero().addActionListener(this);
		vp.getVerSoltero().setActionCommand("boton_ver_solteros");

		vp.getMiPerfil().addActionListener(this);
		vp.getMiPerfil().setActionCommand("boton_ver_perfil");

		// --------BOTONES PARA VOLVER A VENTANA ANTERIOR--------
		vp.getVolver().addActionListener(this);
		vp.getVolver().setActionCommand("boton_volver_vp");

		vrp.getVolver().addActionListener(this);
		vrp.getVolver().setActionCommand("boton_volver_vrp");
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
		case "boton_entrar": {
			vrp.setVisible(false);
			vp.setVisible(true);
			break;
		}
		case "boton_volver_vrp": {
			vrp.setVisible(false);
			vi.setVisible(true);
			break;
		}
		case "boton_subir_foto": {
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
						Files.copy(selectedFile.toPath(), destinationFile.toPath(),
								StandardCopyOption.REPLACE_EXISTING);

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
			break;
		}
		case "boton_ver_perfil": {
			vp.getPanelPareja().setVisible(false);
			vp.getPanelSoltero().setVisible(false);
			vp.getPanelMiPerfil().setVisible(true);
			break;
		}
		case "boton_volver_vp": {
			vp.setVisible(false);
			vrp.setVisible(true);
			break;
		}
		default:
			break;
		}

	}

	public void iniciar() {
		vi.setVisible(true);
	}
}

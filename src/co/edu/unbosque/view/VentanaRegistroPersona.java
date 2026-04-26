package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaRegistroPersona extends JFrame{
	
	private JTextArea titulo;
	private JLabel info;
	
	private JLabel label1;
	private JLabel label2;
	private JTextArea label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel fotoPreview;
	private JLabel lIniSesion;
	
	private JTextField nombre;
	private JTextField apellido;
	private JTextField fechaNacimiento;
	private JTextField progAcademico;
	private JTextField universidad;
	private JTextField documento;
	private JComboBox<String> genero;
	private JButton subirFoto;
	private JButton guardarPersona;
	private JButton iniciarSesion;
	
	private String rutaImagenSeleccionada;
	private JComboBox<String> changeLanguage;
	private JButton volver;
	
	public VentanaRegistroPersona() {
		iniComponentes();
		setVisible(false);
	}
	
	public void iniComponentes() {
		// CONFIGURACION DE LA VENTANA
		setTitle("Ventana registro personas");
		setBounds(230, 5, 1100, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(Color.decode("#270205"));
		getContentPane().setLayout(null);
		
		ImageIcon image = new ImageIcon(getClass().getResource("bolaDisco.PNG"));
		JLabel lImage = new JLabel(image);
		lImage.setBounds(700, 350, 400, 400);
		this.add(lImage);
		
		titulo = new JTextArea("¿ESTÁS LISTO PARA SER PARTE \nDE LA NOCHE DE SOLTEROS?");
		titulo.setBounds(100, 80, 750, 120);
		titulo.setFont(new Font("Arial", Font.BOLD, 45));
		titulo.setForeground(Color.white);
		titulo.setBackground(Color.decode("#270205"));
		titulo.setEditable(false);
		add(titulo);
		
		info = new JLabel("Ingrese la información que se le solicita a continuación");
		info.setBounds(100, 200, 600, 20);
		info.setFont(new Font("Arial", Font.BOLD, 18));
		info.setForeground(Color.white);
		add(info);

		lIniSesion = new JLabel("¿Ya creaste tu cuenta? ");
		lIniSesion.setBounds(165, 654, 150, 20);
		lIniSesion.setFont(new Font("Arial", Font.BOLD, 12));
		lIniSesion.setForeground(Color.white);
		add(lIniSesion);
		
		label1 = new JLabel("Nombre(s):");
		label1.setBounds(100, 240, 200, 18);
		label1.setFont(new Font("Arial", Font.BOLD, 16));
		label1.setForeground(Color.white);
		add(label1);
		
		nombre = new JTextField();
		nombre.setBounds(100, 260, 150, 24);
		add(nombre);
		
		label2 = new JLabel("Apellido(s):");
		label2.setBounds(100, 300, 200, 18);
		label2.setFont(new Font("Arial", Font.BOLD, 16));
		label2.setForeground(Color.white);
		add(label2);
		
		apellido = new JTextField();
		apellido.setBounds(100, 320, 150, 24);
		add(apellido);
		
		label3 = new JTextArea("Fecha de nacimiento\n(DD/MM/AAAA):");
		label3.setBounds(315, 360, 200, 38);
		label3.setFont(new Font("Arial", Font.BOLD, 16));
		label3.setEditable(false);
		label3.setBackground(Color.decode("#270205"));
		label3.setForeground(Color.white);
		add(label3);
		
		fechaNacimiento = new JTextField();
		fechaNacimiento.setBounds(315, 400, 150, 24);
		add(fechaNacimiento);
		
		label4 = new JLabel("Programa Académico:");
		label4.setBounds(100, 420, 200, 18);
		label4.setFont(new Font("Arial", Font.BOLD, 16));
		label4.setForeground(Color.white);
		add(label4);
		
		progAcademico = new JTextField();
		progAcademico.setBounds(100, 440, 150, 24);
		add(progAcademico);
		
		label5 = new JLabel("Universidad:");
		label5.setBounds(100, 360, 165, 18);
		label5.setFont(new Font("Arial", Font.BOLD, 16));
		label5.setForeground(Color.white);
		add(label5);
		
		universidad = new JTextField();
		universidad.setBounds(100, 380, 150, 24);
		add(universidad);
		
		label6 = new JLabel("Número de documento:");
		label6.setBounds(315, 240, 200, 18);
		label6.setFont(new Font("Arial", Font.BOLD, 16));
		label6.setForeground(Color.white);
		add(label6);
		
		documento = new JTextField();
		documento.setBounds(315, 260, 150, 24);
		add(documento);
		
		label7 = new JLabel("Género:");
		label7.setBounds(315, 300, 200, 18);
		label7.setFont(new Font("Arial", Font.BOLD, 16));
		label7.setForeground(Color.white);
		add(label7);
		
		genero = new JComboBox<String>(new String[] {"...", "Femenino", "Masculino"});
		genero.setBounds(315, 320, 150, 24);
		add(genero);
		
		label8 = new JLabel("Foto de perfil:");
		label8.setBounds(540, 240, 150, 18);
		label8.setFont(new Font("Arial", Font.BOLD, 16));
		label8.setForeground(Color.white);
		add(label8);
		
		subirFoto = new JButton("Subir foto");
		subirFoto.setBounds(540, 260, 130, 35);
		subirFoto.setBackground(Color.decode("#ab1a1c"));
		subirFoto.setForeground(Color.white);
		subirFoto.setBorderPainted(false);
		subirFoto.setFocusPainted(false);
		add(subirFoto);
		
		guardarPersona = new JButton("GUARDAR");
		guardarPersona.setBounds(330, 590, 90, 45);
		guardarPersona.setBackground(Color.decode("#ab1a1c"));
		guardarPersona.setForeground(Color.white);
		guardarPersona.setFocusPainted(false);
		guardarPersona.setBorderPainted(false);
		add(guardarPersona);
		
		fotoPreview = new JLabel();
		fotoPreview.setBounds(540, 330, 160, 160);
		fotoPreview.setFont(new Font("Arial", Font.BOLD, 15));
		fotoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		add(fotoPreview);
		
		changeLanguage = new JComboBox<String>(new String[] {"Cambiar idioma", "Español", "Ingles", "Frances", "Ruso", "Latin", "Japones"});
		changeLanguage.setBounds(940, 140, 120, 40);
		changeLanguage.setBackground(Color.black);
		changeLanguage.setForeground(Color.white);
		changeLanguage.setBorder(BorderFactory.createLineBorder(Color.decode("#6d161a")));
		add(changeLanguage);
		
		volver = new JButton("VOLVER");
		volver.setBounds(207, 590, 95, 45);
		volver.setBackground(Color.decode("#ab1a1c"));
		volver.setForeground(Color.white);
		volver.setBorderPainted(false);
		volver.setFocusPainted(false);
		add(volver);

		iniciarSesion = new JButton("Inicia sesión aquí");
		iniciarSesion.setBounds(305, 650, 150, 25);
		iniciarSesion.setBackground(Color.white);
		iniciarSesion.setForeground(Color.decode("#270205"));
		iniciarSesion.setBorderPainted(false);
		iniciarSesion.setFocusPainted(false);
		add(iniciarSesion);
	}

	public JTextArea getTitulo() {
		return titulo;
	}

	public void setTitulo(JTextArea titulo) {
		this.titulo = titulo;
	}

	public JLabel getInfo() {
		return info;
	}

	public void setInfo(JLabel info) {
		this.info = info;
	}

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}

	public JTextArea getLabel3() {
		return label3;
	}

	public void setLabel3(JTextArea label3) {
		this.label3 = label3;
	}

	public JLabel getLabel4() {
		return label4;
	}

	public void setLabel4(JLabel label4) {
		this.label4 = label4;
	}

	public JLabel getLabel5() {
		return label5;
	}

	public void setLabel5(JLabel label5) {
		this.label5 = label5;
	}

	public JLabel getLabel6() {
		return label6;
	}

	public void setLabel6(JLabel label6) {
		this.label6 = label6;
	}

	public JLabel getLabel7() {
		return label7;
	}

	public void setLabel7(JLabel label7) {
		this.label7 = label7;
	}

	public JLabel getLabel8() {
		return label8;
	}

	public void setLabel8(JLabel label8) {
		this.label8 = label8;
	}

	public JLabel getFotoPreview() {
		return fotoPreview;
	}

	public void setFotoPreview(JLabel fotoPreview) {
		this.fotoPreview = fotoPreview;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getApellido() {
		return apellido;
	}

	public void setApellido(JTextField apellido) {
		this.apellido = apellido;
	}

	public JTextField getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(JTextField fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public JTextField getProgAcademico() {
		return progAcademico;
	}

	public void setProgAcademico(JTextField progAcademico) {
		this.progAcademico = progAcademico;
	}

	public JTextField getUniversidad() {
		return universidad;
	}

	public void setUniversidad(JTextField universidad) {
		this.universidad = universidad;
	}

	public JTextField getDocumento() {
		return documento;
	}

	public void setDocumento(JTextField documento) {
		this.documento = documento;
	}

	public JComboBox<String> getGenero() {
		return genero;
	}

	public void setGenero(JComboBox<String> genero) {
		this.genero = genero;
	}

	public JButton getSubirFoto() {
		return subirFoto;
	}

	public void setSubirFoto(JButton subirFoto) {
		this.subirFoto = subirFoto;
	}

	public JButton getGuardarPersona() {
		return guardarPersona;
	}

	public void setGuardarPersona(JButton guardarPersona) {
		this.guardarPersona = guardarPersona;
	}

	public JComboBox<String> getChangeLanguage() {
		return changeLanguage;
	}

	public void setChangeLanguage(JComboBox<String> changeLanguage) {
		this.changeLanguage = changeLanguage;
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public String getRutaImagenSeleccionada() {
		return rutaImagenSeleccionada;
	}

	public void setRutaImagenSeleccionada(String rutaImagenSeleccionada) {
		this.rutaImagenSeleccionada = rutaImagenSeleccionada;
	}

	public JLabel getlIniSesion() {
		return lIniSesion;
	}

	public void setlIniSesion(JLabel lIniSesion) {
		this.lIniSesion = lIniSesion;
	}

	public JButton getIniciarSesion() {
		return iniciarSesion;
	}

	public void setIniciarSesion(JButton iniciarSesion) {
		this.iniciarSesion = iniciarSesion;
	}

}

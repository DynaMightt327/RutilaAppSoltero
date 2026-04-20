package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelMiPerfil extends JPanel {

	private JPanel mostrarDetalle;
	private JLabel fotoPreview;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;

	private JTextField nombre;
	private JTextField apellido;
	private JTextField fechaNacimiento;
	private JTextField progAcademico;
	private JTextField universidad;
	private JTextField genero;

	public PanelMiPerfil() {
		initComponentes();
		setVisible(false);
	}

	public void initComponentes() {
		this.setBounds(0, 215, 1100, 450);
		this.setLayout(null);
		this.setBackground(new Color(240, 109, 22, 26));

		// VER PERFIL A DETALLE
		mostrarDetalle = new JPanel();
		mostrarDetalle.setBounds(400, 15, 300, 420);
		mostrarDetalle.setBackground(Color.black);
		mostrarDetalle.setLayout(null);
		add(mostrarDetalle);

		label1 = new JLabel("Nombre(s):");
		label1.setBounds(10, 150, 80, 18);
		label1.setFont(new Font("Arial", Font.BOLD, 15));
		label1.setForeground(Color.white);
		mostrarDetalle.add(label1);

		nombre = new JTextField();
		nombre.setBounds(110, 150, 150, 24);
		nombre.setEditable(false);
		mostrarDetalle.add(nombre);

		label2 = new JLabel("Apellido(s):");
		label2.setBounds(10, 190, 80, 18);
		label2.setFont(new Font("Arial", Font.BOLD, 15));
		label2.setForeground(Color.white);
		mostrarDetalle.add(label2);

		apellido = new JTextField();
		apellido.setBounds(110, 190, 150, 24);
		apellido.setEditable(false);
		mostrarDetalle.add(apellido);

		label3 = new JLabel("Edad:");
		label3.setBounds(10, 230, 280, 18);
		label3.setFont(new Font("Arial", Font.BOLD, 15));
		label3.setForeground(Color.white);
		mostrarDetalle.add(label3);

		fechaNacimiento = new JTextField();
		fechaNacimiento.setBounds(110, 230, 150, 24);
		fechaNacimiento.setEditable(false);
		mostrarDetalle.add(fechaNacimiento);

		label6 = new JLabel("Género:");
		label6.setBounds(10, 270, 200, 18);
		label6.setFont(new Font("Arial", Font.BOLD, 15));
		label6.setForeground(Color.white);
		mostrarDetalle.add(label6);

		genero = new JTextField();
		genero.setBounds(110, 270, 150, 24);
		genero.setEditable(false);
		mostrarDetalle.add(genero);

		label5 = new JLabel("Universidad:");
		label5.setBounds(10, 310, 200, 18);
		label5.setFont(new Font("Arial", Font.BOLD, 15));
		label5.setForeground(Color.white);
		mostrarDetalle.add(label5);

		universidad = new JTextField();
		universidad.setBounds(110, 310, 150, 24);
		universidad.setEditable(false);
		mostrarDetalle.add(universidad);

		label4 = new JLabel("Carrera:");
		label4.setBounds(10, 350, 200, 18);
		label4.setFont(new Font("Arial", Font.BOLD, 15));
		label4.setForeground(Color.white);
		mostrarDetalle.add(label4);

		progAcademico = new JTextField();
		progAcademico.setBounds(110, 350, 150, 24);
		progAcademico.setEditable(false);
		mostrarDetalle.add(progAcademico);

		fotoPreview = new JLabel();
		fotoPreview.setBounds(95, 15, 120, 120);
		fotoPreview.setFont(new Font("Arial", Font.BOLD, 15));
		fotoPreview.setBorder(BorderFactory.createLineBorder(Color.white));
		mostrarDetalle.add(fotoPreview);

	}

	public JPanel getMostrarDetalle() {
		return mostrarDetalle;
	}

	public void setMostrarDetalle(JPanel mostrarDetalle) {
		this.mostrarDetalle = mostrarDetalle;
	}

	public JLabel getFotoPreview() {
		return fotoPreview;
	}

	public void setFotoPreview(JLabel fotoPreview) {
		this.fotoPreview = fotoPreview;
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

	public JLabel getLabel3() {
		return label3;
	}

	public void setLabel3(JLabel label3) {
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

	public JTextField getGenero() {
		return genero;
	}

	public void setGenero(JTextField genero) {
		this.genero = genero;
	}

}

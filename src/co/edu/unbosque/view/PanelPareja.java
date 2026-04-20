package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelPareja extends JPanel {

	private JButton romperPareja;
	private JLabel titulo;
	private JTable tablaPareja;

	private JPanel mostrarDetalle;
	private JLabel fotoPreview1;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;

	private JTextField nombre1;
	private JTextField apellido1;
	private JTextField fechaNacimiento1;
	private JTextField progAcademico1;
	private JTextField universidad1;
	private JTextField genero1;

	private JLabel fotoPreview2;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;

	private JTextField nombre2;
	private JTextField apellido2;
	private JTextField fechaNacimiento2;
	private JTextField progAcademico2;
	private JTextField universidad2;
	private JTextField genero2;

	public PanelPareja() {
		iniComponentes();
		setVisible(false);
	}

	public void iniComponentes() {
		this.setBounds(0, 215, 1100, 450);
		this.setLayout(null);
		this.setBackground(new Color(240, 109, 22, 26));

		titulo = new JLabel("Parejas registradas esta noche");
		titulo.setBounds(20, 30, 500, 22);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setForeground(Color.white);
		add(titulo);

		String[] columnas = { "Pareja" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		tablaPareja = new JTable(modelo);
		tablaPareja.setBackground(Color.decode("#fad0ce"));
		tablaPareja.setForeground(Color.decode("#40110f"));
		tablaPareja.getTableHeader().setBackground(Color.decode("#cd3a35"));
		tablaPareja.getTableHeader().setForeground(Color.decode("#fdf3f3"));
		tablaPareja.getColumnModel().getColumn(0).setPreferredWidth(320);
		JScrollPane scroll = new JScrollPane(tablaPareja);
		scroll.setBounds(20, 70, 320, 300);
		scroll.setBackground(Color.decode("#fad0ce"));
		add(scroll);

		romperPareja = new JButton("SEPARAR PAREJA");
		romperPareja.setBounds(20, 390, 150, 40);
		romperPareja.setBackground(Color.decode("#efbfce"));
		romperPareja.setForeground(Color.decode("#3d0b0d"));
		romperPareja.setBorderPainted(false);
		romperPareja.setFocusPainted(false);
		add(romperPareja);

		// VER PERFIL A DETALLE
		mostrarDetalle = new JPanel();
		mostrarDetalle.setBounds(380, 15, 670, 420);
		mostrarDetalle.setBackground(Color.black);
		mostrarDetalle.setLayout(null);
		add(mostrarDetalle);

		label1 = new JLabel("Nombre(s):");
		label1.setBounds(40, 150, 80, 18);
		label1.setFont(new Font("Arial", Font.BOLD, 15));
		label1.setForeground(Color.white);
		mostrarDetalle.add(label1);

		nombre1 = new JTextField();
		nombre1.setBounds(140, 150, 150, 24);
		nombre1.setEditable(false);
		mostrarDetalle.add(nombre1);

		label2 = new JLabel("Apellido(s):");
		label2.setBounds(40, 190, 80, 18);
		label2.setFont(new Font("Arial", Font.BOLD, 15));
		label2.setForeground(Color.white);
		mostrarDetalle.add(label2);

		apellido1 = new JTextField();
		apellido1.setBounds(140, 190, 150, 24);
		apellido1.setEditable(false);
		mostrarDetalle.add(apellido1);

		label3 = new JLabel("Edad:");
		label3.setBounds(40, 230, 280, 18);
		label3.setFont(new Font("Arial", Font.BOLD, 15));
		label3.setForeground(Color.white);
		mostrarDetalle.add(label3);

		fechaNacimiento1 = new JTextField();
		fechaNacimiento1.setBounds(140, 230, 150, 24);
		fechaNacimiento1.setEditable(false);
		mostrarDetalle.add(fechaNacimiento1);

		label6 = new JLabel("Género:");
		label6.setBounds(40, 270, 200, 18);
		label6.setFont(new Font("Arial", Font.BOLD, 15));
		label6.setForeground(Color.white);
		mostrarDetalle.add(label6);

		genero1 = new JTextField();
		genero1.setBounds(140, 270, 150, 24);
		genero1.setEditable(false);
		mostrarDetalle.add(genero1);

		label5 = new JLabel("Universidad:");
		label5.setBounds(40, 310, 200, 18);
		label5.setFont(new Font("Arial", Font.BOLD, 15));
		label5.setForeground(Color.white);
		mostrarDetalle.add(label5);

		universidad1 = new JTextField();
		universidad1.setBounds(140, 310, 150, 24);
		universidad1.setEditable(false);
		mostrarDetalle.add(universidad1);

		label4 = new JLabel("Carrera:");
		label4.setBounds(40, 350, 200, 18);
		label4.setFont(new Font("Arial", Font.BOLD, 15));
		label4.setForeground(Color.white);
		mostrarDetalle.add(label4);

		progAcademico1 = new JTextField();
		progAcademico1.setBounds(140, 350, 150, 24);
		progAcademico1.setEditable(false);
		mostrarDetalle.add(progAcademico1);

		fotoPreview1 = new JLabel();
		fotoPreview1.setBounds(125, 15, 120, 120);
		fotoPreview1.setFont(new Font("Arial", Font.BOLD, 15));
		fotoPreview1.setBorder(BorderFactory.createLineBorder(Color.white));
		mostrarDetalle.add(fotoPreview1);

		label7 = new JLabel("Nombre(s):");
		label7.setBounds(360, 150, 80, 18);
		label7.setFont(new Font("Arial", Font.BOLD, 15));
		label7.setForeground(Color.white);
		mostrarDetalle.add(label7);

		nombre2 = new JTextField();
		nombre2.setBounds(460, 150, 150, 24);
		nombre2.setEditable(false);
		mostrarDetalle.add(nombre2);

		label8 = new JLabel("Apellido(s):");
		label8.setBounds(360, 190, 80, 18);
		label8.setFont(new Font("Arial", Font.BOLD, 15));
		label8.setForeground(Color.white);
		mostrarDetalle.add(label8);

		apellido2 = new JTextField();
		apellido2.setBounds(460, 190, 150, 24);
		apellido2.setEditable(false);
		mostrarDetalle.add(apellido2);

		label9 = new JLabel("Edad:");
		label9.setBounds(360, 230, 280, 18);
		label9.setFont(new Font("Arial", Font.BOLD, 15));
		label9.setForeground(Color.white);
		mostrarDetalle.add(label9);

		fechaNacimiento2 = new JTextField();
		fechaNacimiento2.setBounds(460, 230, 150, 24);
		fechaNacimiento2.setEditable(false);
		mostrarDetalle.add(fechaNacimiento2);

		label10 = new JLabel("Género:");
		label10.setBounds(360, 270, 200, 18);
		label10.setFont(new Font("Arial", Font.BOLD, 15));
		label10.setForeground(Color.white);
		mostrarDetalle.add(label10);

		genero2 = new JTextField();
		genero2.setBounds(460, 270, 150, 24);
		genero2.setEditable(false);
		mostrarDetalle.add(genero2);

		label11 = new JLabel("Universidad:");
		label11.setBounds(360, 310, 200, 18);
		label11.setFont(new Font("Arial", Font.BOLD, 15));
		label11.setForeground(Color.white);
		mostrarDetalle.add(label11);

		universidad2 = new JTextField();
		universidad2.setBounds(460, 310, 150, 24);
		universidad2.setEditable(false);
		mostrarDetalle.add(universidad2);

		label12 = new JLabel("Carrera:");
		label12.setBounds(360, 350, 200, 18);
		label12.setFont(new Font("Arial", Font.BOLD, 15));
		label12.setForeground(Color.white);
		mostrarDetalle.add(label12);

		progAcademico2 = new JTextField();
		progAcademico2.setBounds(460, 350, 150, 24);
		progAcademico2.setEditable(false);
		mostrarDetalle.add(progAcademico2);

		fotoPreview2 = new JLabel();
		fotoPreview2.setBounds(425, 15, 120, 120);
		fotoPreview2.setFont(new Font("Arial", Font.BOLD, 15));
		fotoPreview2.setBorder(BorderFactory.createLineBorder(Color.white));
		mostrarDetalle.add(fotoPreview2);

	}

	public JButton getRomperPareja() {
		return romperPareja;
	}

	public void setRomperPareja(JButton romperPareja) {
		this.romperPareja = romperPareja;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JTable getTablaPareja() {
		return tablaPareja;
	}

	public void setTablaPareja(JTable tablaPareja) {
		this.tablaPareja = tablaPareja;
	}

	public JPanel getMostrarDetalle() {
		return mostrarDetalle;
	}

	public void setMostrarDetalle(JPanel mostrarDetalle) {
		this.mostrarDetalle = mostrarDetalle;
	}

	public JLabel getFotoPreview1() {
		return fotoPreview1;
	}

	public void setFotoPreview1(JLabel fotoPreview1) {
		this.fotoPreview1 = fotoPreview1;
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

	public JTextField getNombre1() {
		return nombre1;
	}

	public void setNombre1(JTextField nombre1) {
		this.nombre1 = nombre1;
	}

	public JTextField getApellido1() {
		return apellido1;
	}

	public void setApellido1(JTextField apellido1) {
		this.apellido1 = apellido1;
	}

	public JTextField getFechaNacimiento1() {
		return fechaNacimiento1;
	}

	public void setFechaNacimiento1(JTextField fechaNacimiento1) {
		this.fechaNacimiento1 = fechaNacimiento1;
	}

	public JTextField getProgAcademico1() {
		return progAcademico1;
	}

	public void setProgAcademico1(JTextField progAcademico1) {
		this.progAcademico1 = progAcademico1;
	}

	public JTextField getUniversidad1() {
		return universidad1;
	}

	public void setUniversidad1(JTextField universidad1) {
		this.universidad1 = universidad1;
	}

	public JTextField getGenero1() {
		return genero1;
	}

	public void setGenero1(JTextField genero1) {
		this.genero1 = genero1;
	}

	public JLabel getFotoPreview2() {
		return fotoPreview2;
	}

	public void setFotoPreview2(JLabel fotoPreview2) {
		this.fotoPreview2 = fotoPreview2;
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

	public JLabel getLabel9() {
		return label9;
	}

	public void setLabel9(JLabel label9) {
		this.label9 = label9;
	}

	public JLabel getLabel10() {
		return label10;
	}

	public void setLabel10(JLabel label10) {
		this.label10 = label10;
	}

	public JLabel getLabel11() {
		return label11;
	}

	public void setLabel11(JLabel label11) {
		this.label11 = label11;
	}

	public JLabel getLabel12() {
		return label12;
	}

	public void setLabel12(JLabel label12) {
		this.label12 = label12;
	}

	public JTextField getNombre2() {
		return nombre2;
	}

	public void setNombre2(JTextField nombre2) {
		this.nombre2 = nombre2;
	}

	public JTextField getApellido2() {
		return apellido2;
	}

	public void setApellido2(JTextField apellido2) {
		this.apellido2 = apellido2;
	}

	public JTextField getFechaNacimiento2() {
		return fechaNacimiento2;
	}

	public void setFechaNacimiento2(JTextField fechaNacimiento2) {
		this.fechaNacimiento2 = fechaNacimiento2;
	}

	public JTextField getProgAcademico2() {
		return progAcademico2;
	}

	public void setProgAcademico2(JTextField progAcademico2) {
		this.progAcademico2 = progAcademico2;
	}

	public JTextField getUniversidad2() {
		return universidad2;
	}

	public void setUniversidad2(JTextField universidad2) {
		this.universidad2 = universidad2;
	}

	public JTextField getGenero2() {
		return genero2;
	}

	public void setGenero2(JTextField genero2) {
		this.genero2 = genero2;
	}

}

package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaIniciarSesion extends JFrame {
	
	private JLabel fondoo;
	private JTextArea info;
	private JLabel labelDoc;
	private JTextField numDocumento;
	private JButton entrar;
	private JButton volver;

	public VentanaIniciarSesion() {
		initComponentes();
		setVisible(false);
	}

	public void initComponentes() {
		// CONFIGURACION DE LA VENTANA
		setTitle("Ventana Iniciar Sesion");
		setBounds(230, 5, 1100, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(Color.decode("#d2d5d3"));
		getContentPane().setLayout(null);
		
		ImageIcon fondoImagen = new ImageIcon(getClass().getResource("fondo.png"));
		fondoo = new JLabel(fondoImagen);
		fondoo.setBounds(0, 0, 1100, 720);
		fondoo.setLayout(null);
		add(fondoo);
		
		info = new JTextArea("INICIA SESIÓN PARA ENTRAR \nA LA APP DE RUTILA BAR");
		info.setBounds(100, 80, 750, 120);
		info.setFont(new Font("Arial", Font.BOLD, 45));
		info.setForeground(Color.white);
		info.setBackground(Color.decode("#270205"));
		info.setOpaque(false);
		info.setEditable(false);
		fondoo.add(info);
		
		labelDoc = new JLabel("Número de documento:");
		labelDoc.setBounds(315, 240, 200, 18);
		labelDoc.setFont(new Font("Arial", Font.BOLD, 16));
		labelDoc.setForeground(Color.white);
		fondoo.add(labelDoc);
		
		numDocumento = new JTextField();
		numDocumento.setBounds(315, 260, 150, 30);
		fondoo.add(numDocumento);
		
		entrar = new JButton("ENTRAR");
		entrar.setBounds(330, 600, 90, 45);
		entrar.setBackground(Color.decode("#ab1a1c"));
		entrar.setForeground(Color.white);
		entrar.setFocusPainted(false);
		entrar.setBorderPainted(false);
		fondoo.add(entrar);
		
		volver = new JButton("VOLVER");
		volver.setBounds(220, 600, 95, 45);
		volver.setBackground(Color.decode("#ab1a1c"));
		volver.setForeground(Color.white);
		volver.setBorderPainted(false);
		volver.setFocusPainted(false);
		fondoo.add(volver);
	}

	public JLabel getFondoo() {
		return fondoo;
	}

	public void setFondoo(JLabel fondoo) {
		this.fondoo = fondoo;
	}

	public JTextArea getInfo() {
		return info;
	}

	public void setInfo(JTextArea info) {
		this.info = info;
	}

	public JLabel getLabelDoc() {
		return labelDoc;
	}

	public void setLabelDoc(JLabel labelDoc) {
		this.labelDoc = labelDoc;
	}

	public JTextField getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(JTextField numDocumento) {
		this.numDocumento = numDocumento;
	}

	public JButton getEntrar() {
		return entrar;
	}

	public void setEntrar(JButton entrar) {
		this.entrar = entrar;
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

}

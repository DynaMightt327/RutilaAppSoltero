package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaInicial extends JFrame {

	private JLabel titulo;
	private JLabel background;
	private JButton iniciar;
	private JLabel info;

	// BOTONES DE IDIOMAS
	private JButton espanol;
	private JButton ingles;
	private JButton frances;
	private JButton ruso;
	private JButton latin;
	private JButton japones;

	public VentanaInicial() {
		iniComponentes();
		setVisible(true);
	}

	public void iniComponentes() {
		// CONFIGURACION DE LA VENTANA
		setTitle("Ventana Inicio Rutila - App solteros");
		setBounds(230, 5, 1100, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(Color.decode("#d2d5d3"));
		getContentPane().setLayout(null);

		ImageIcon backgroundImage = new ImageIcon(getClass().getResource("backgroundInicial.PNG"));
		background = new JLabel(backgroundImage);
		background.setBounds(0, 0, 1100, 720);
		background.setLayout(null);
		this.getContentPane().add(background);

		titulo = new JLabel("RUTILA BAR");
		titulo.setBounds(100, 300, 400, 70);
		titulo.setFont(new Font("Arial", Font.BOLD, 65));
		titulo.setForeground(Color.white);
		titulo.setBackground(null);
		background.add(titulo);

		info = new JLabel("Seleccione un idioma antes de comenzar");
		info.setBounds(150, 645, 400, 20);
		info.setFont(new Font("Arial", Font.BOLD, 15));
		info.setForeground(Color.white);
		info.setBackground(null);
		background.add(info);

		iniciar = new JButton("APP PARA SOLTEROS");
		iniciar.setBounds(170, 385, 250, 45);
		iniciar.setBackground(Color.decode("#6d161a"));
		iniciar.setForeground(Color.white);
		iniciar.setBorderPainted(false);
		iniciar.setFocusPainted(false);
		background.add(iniciar);

		ImageIcon imagen1 = new ImageIcon(getClass().getResource("spanish.png"));
		JLabel labelImagen1 = new JLabel(imagen1);
		espanol = new JButton(imagen1);
		espanol.setBounds(105, 580, 50, 50);
		espanol.setContentAreaFilled(false);
		espanol.setFocusPainted(false);
		espanol.setBorderPainted(false);
		background.add(espanol);

		ImageIcon imagen2 = new ImageIcon(getClass().getResource("english.png"));
		JLabel labelImagen2 = new JLabel(imagen2);
		ingles = new JButton(imagen2);
		ingles.setBounds(175, 580, 50, 50);
		ingles.setContentAreaFilled(false);
		ingles.setFocusPainted(false);
		ingles.setBorderPainted(false);
		background.add(ingles);

		ImageIcon imagen3 = new ImageIcon(getClass().getResource("francess.png"));
		JLabel labelImagen3 = new JLabel(imagen3);
		frances = new JButton(imagen3);
		frances.setBounds(245, 580, 50, 50);
		frances.setContentAreaFilled(false);
		frances.setFocusPainted(false);
		frances.setBorderPainted(false);
		background.add(frances);

		ImageIcon imagen4 = new ImageIcon(getClass().getResource("ruso.png"));
		JLabel labelImagen4 = new JLabel(imagen4);
		ruso = new JButton(imagen4);
		ruso.setBounds(315, 580, 50, 50);
		ruso.setContentAreaFilled(false);
		ruso.setFocusPainted(false);
		ruso.setBorderPainted(false);
		background.add(ruso);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("latinn.png"));
		JLabel labelImagen5 = new JLabel(imagen5);
		latin = new JButton(imagen5);
		latin.setBounds(385, 580, 50, 50);
		latin.setContentAreaFilled(false);
		latin.setFocusPainted(false);
		latin.setBorderPainted(false);
		background.add(latin);

		ImageIcon imagen6 = new ImageIcon(getClass().getResource("japonn.png"));
		JLabel labelImagen6 = new JLabel(imagen6);
		japones = new JButton(imagen6);
		japones.setBounds(455, 580, 50, 50);
		japones.setContentAreaFilled(false);
		japones.setFocusPainted(false);
		japones.setBorderPainted(false);
		background.add(japones);
	}


	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public void setBackground(JLabel background) {
		this.background = background;
	}

	public JButton getIniciar() {
		return iniciar;
	}

	public void setIniciar(JButton iniciar) {
		this.iniciar = iniciar;
	}

	public JLabel getInfo() {
		return info;
	}

	public void setInfo(JLabel info) {
		this.info = info;
	}

	public JButton getEspanol() {
		return espanol;
	}

	public void setEspanol(JButton espanol) {
		this.espanol = espanol;
	}

	public JButton getIngles() {
		return ingles;
	}

	public void setIngles(JButton ingles) {
		this.ingles = ingles;
	}

	public JButton getFrances() {
		return frances;
	}

	public void setFrances(JButton frances) {
		this.frances = frances;
	}

	public JButton getRuso() {
		return ruso;
	}

	public void setRuso(JButton ruso) {
		this.ruso = ruso;
	}

	public JButton getLatin() {
		return latin;
	}

	public void setLatin(JButton latin) {
		this.latin = latin;
	}

	public JButton getJapones() {
		return japones;
	}

	public void setJapones(JButton japones) {
		this.japones = japones;
	}

}

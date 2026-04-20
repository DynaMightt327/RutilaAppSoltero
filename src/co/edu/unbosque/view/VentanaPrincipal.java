package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame{
	
	private JLabel titulo;
	private JLabel fondoo;
	private JLabel deco1;
	private JLabel deco2;
	private JPanel panelSuperior;
	private JPanel panelMenu;
	
	private JButton miPerfil;
	private JButton verSoltero;
	private JButton verPareja;
	private PanelSoltero panelSoltero;
	private PanelPareja panelPareja;
	private PanelMiPerfil panelMiPerfil;
	
	private JComboBox<String> changeLanguage;
	private JButton volver;
	
	public VentanaPrincipal() {
		iniComponentes();
		setVisible(false);
	}
	
	public void iniComponentes() {
		// CONFIGURACION DE LA VENTANA
		setTitle("Ventana principal");
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
		
		panelSoltero = new PanelSoltero();
		panelSoltero.setVisible(false);
		fondoo.add(panelSoltero);
		
		panelPareja = new PanelPareja();
		panelPareja.setVisible(false);
		fondoo.add(panelPareja);
		
		panelMiPerfil = new PanelMiPerfil();
		panelMiPerfil.setVisible(false);
		fondoo.add(panelMiPerfil);
		
		panelSuperior = new JPanel();
		panelSuperior.setBounds(0, 0, 1100, 130);
		panelSuperior.setBackground(Color.decode(("#3d0b0d")));
		panelSuperior.setLayout(null);
		fondoo.add(panelSuperior);
		
		panelMenu = new JPanel();
		panelMenu.setBounds(0, 130, 1100, 60);
		panelMenu.setBackground(Color.decode("#6d161a"));
		panelMenu.setLayout(null);
		fondoo.add(panelMenu);

		ImageIcon imagen1 = new ImageIcon(getClass().getResource("deco.PNG"));
		deco1 = new JLabel(imagen1);
		deco1.setBounds(40, 0, 250, 130);
		deco1.setLayout(null);
		panelSuperior.add(deco1);
		
		ImageIcon imagen2 = new ImageIcon(getClass().getResource("deco.PNG"));
		deco2 = new JLabel(imagen2);
		deco2.setBounds(800, 0, 250, 130);
		deco2.setLayout(null);
		panelSuperior.add(deco2);
		
		titulo = new JLabel("RUTILA");
		titulo.setBounds(415, 30, 450, 70);
		titulo.setFont(new Font("Arial", Font.BOLD, 65));
		titulo.setForeground(Color.white);
		titulo.setBackground(null);
		panelSuperior.add(titulo);

		miPerfil = new JButton("MI PERFIL");
		miPerfil.setBounds(20, 10, 120, 40);
		miPerfil.setBackground(Color.black);
		miPerfil.setForeground(Color.white);
		miPerfil.setBorderPainted(false);
		miPerfil.setFocusPainted(false);
		panelMenu.add(miPerfil);
		
		verSoltero = new JButton("VER SOLTEROS");
		verSoltero.setBounds(160, 10, 150, 40);
		verSoltero.setBackground(Color.black);
		verSoltero.setForeground(Color.white);
		verSoltero.setBorderPainted(false);
		verSoltero.setFocusPainted(false);
		panelMenu.add(verSoltero);
		
		verPareja = new JButton("VER PAREJAS");
		verPareja.setBounds(330, 10, 150, 40);
		verPareja.setBackground(Color.black);
		verPareja.setForeground(Color.white);
		verPareja.setBorderPainted(false);
		verPareja.setFocusPainted(false);
		panelMenu.add(verPareja);
		
		changeLanguage = new JComboBox<String>(new String[] {"Cambiar idioma", "Español", "Ingles", "Frances", "Ruso", "Latin", "Japones"});
		changeLanguage.setBounds(820, 10, 120, 40);
		changeLanguage.setBackground(Color.black);
		changeLanguage.setForeground(Color.white);
		changeLanguage.setBorder(BorderFactory.createLineBorder(Color.decode("#6d161a")));
		panelMenu.add(changeLanguage);
		
		volver = new JButton("VOLVER");
		volver.setBounds(960, 10, 95, 40);
		volver.setBackground(Color.black);
		volver.setForeground(Color.white);
		volver.setBorderPainted(false);
		volver.setFocusPainted(false);
		panelMenu.add(volver);
	
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JLabel getFondoo() {
		return fondoo;
	}

	public void setFondoo(JLabel fondoo) {
		this.fondoo = fondoo;
	}

	public JLabel getDeco1() {
		return deco1;
	}

	public void setDeco1(JLabel deco1) {
		this.deco1 = deco1;
	}

	public JLabel getDeco2() {
		return deco2;
	}

	public void setDeco2(JLabel deco2) {
		this.deco2 = deco2;
	}

	public JPanel getPanelSuperior() {
		return panelSuperior;
	}

	public void setPanelSuperior(JPanel panelSuperior) {
		this.panelSuperior = panelSuperior;
	}

	public JPanel getPanelMenu() {
		return panelMenu;
	}

	public void setPanelMenu(JPanel panelMenu) {
		this.panelMenu = panelMenu;
	}

	public JButton getMiPerfil() {
		return miPerfil;
	}

	public void setMiPerfil(JButton miPerfil) {
		this.miPerfil = miPerfil;
	}

	public JButton getVerSoltero() {
		return verSoltero;
	}

	public void setVerSoltero(JButton verSoltero) {
		this.verSoltero = verSoltero;
	}

	public JButton getVerPareja() {
		return verPareja;
	}

	public void setVerPareja(JButton verPareja) {
		this.verPareja = verPareja;
	}

	public PanelSoltero getPanelSoltero() {
		return panelSoltero;
	}

	public void setPanelSoltero(PanelSoltero panelSoltero) {
		this.panelSoltero = panelSoltero;
	}

	public PanelPareja getPanelPareja() {
		return panelPareja;
	}

	public void setPanelPareja(PanelPareja panelPareja) {
		this.panelPareja = panelPareja;
	}

	public PanelMiPerfil getPanelMiPerfil() {
		return panelMiPerfil;
	}

	public void setPanelMiPerfil(PanelMiPerfil panelMiPerfil) {
		this.panelMiPerfil = panelMiPerfil;
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

	
}

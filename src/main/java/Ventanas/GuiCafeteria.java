package Ventanas;

import gestioncafeteria.Cafeteria;
import gestioncafeteria.Cafe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuiCafeteria extends JFrame {
	private Cafeteria cafeteria;
	private JButton btnVerListaCafes;
	private JButton btnAgregarCafe;
	private JButton btnObtenerCafesPorTamaño;
	private JButton btnDescontinuarCafe;
	private JButton btnModificarInfo;
	private JButton btnSalir;

	public GuiCafeteria(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
		setTitle("Gestión de Cafetería");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Inicializar botones
		btnVerListaCafes = new JButton("Ver Lista de Cafés");
		btnAgregarCafe = new JButton("Agregar Café");
		btnObtenerCafesPorTamaño = new JButton("Obtener Cafés por Tamaño");
		btnDescontinuarCafe = new JButton("Descontinuar Café");
		btnModificarInfo = new JButton("Modificar Información");
		btnSalir = new JButton("Salir");

		// Panel para los botones
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 1));
		panel.add(btnVerListaCafes);
		panel.add(btnAgregarCafe);
		panel.add(btnObtenerCafesPorTamaño);
		panel.add(btnDescontinuarCafe);
		panel.add(btnModificarInfo);
		panel.add(btnSalir);

		add(panel);

		// Configuración de eventos
		btnVerListaCafes.addActionListener(e -> verListaCafes());
		btnAgregarCafe.addActionListener(e -> agregarCafe());
		btnObtenerCafesPorTamaño.addActionListener(e -> obtenerCafesPorTamaño());
		btnDescontinuarCafe.addActionListener(e -> descontinuarCafe());
		btnModificarInfo.addActionListener(e -> modificarInfo());
		btnSalir.addActionListener(e -> salir());
	}

	private void verListaCafes() {
		StringBuilder listaCafes = new StringBuilder("Lista de Cafés:\n");
		for (Cafe cafe : cafeteria.getCafes()) {
			listaCafes.append(cafe.getNombre()).append(" - ").append(cafe.getTamaño()).append("\n");
		}
		JOptionPane.showMessageDialog(this, listaCafes.toString());
	}

	private void agregarCafe() {
		String nombre = JOptionPane.showInputDialog("Nombre del café:");
		int gramosCafe = Integer.parseInt(JOptionPane.showInputDialog("Gramos de café:"));
		int mlAgua = Integer.parseInt(JOptionPane.showInputDialog("Mililitros de agua:"));
		String tamaño = JOptionPane.showInputDialog("Tamaño (Pequeño, Mediano, Grande):");
		String ingredientes = JOptionPane.showInputDialog("Ingredientes opcionales (separados por comas):");

		List<String> ingredientesList = new ArrayList<>();
		for (String ingrediente : ingredientes.split(",")) {
			ingredientesList.add(ingrediente.trim());
		}

		Cafe nuevoCafe = new Cafe(nombre, gramosCafe, mlAgua, tamaño, ingredientesList);
		cafeteria.agregarCafe(nuevoCafe);
		JOptionPane.showMessageDialog(this, "Café agregado exitosamente.");
	}

	private void obtenerCafesPorTamaño() {
		String tamaño = JOptionPane.showInputDialog("Ingrese el tamaño del café a buscar:");
		List<Cafe> cafes = cafeteria.obtenerCafesPorTamaño(tamaño);

		if (cafes.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No se encontraron cafés de tamaño " + tamaño);
		} else {
			StringBuilder resultado = new StringBuilder("Cafés de tamaño " + tamaño + ":\n");
			for (Cafe cafe : cafes) {
				resultado.append(cafe.getNombre()).append("\n");
			}
			JOptionPane.showMessageDialog(this, resultado.toString());
		}
	}

	private void descontinuarCafe() {
		String nombreCafe = JOptionPane.showInputDialog("Nombre del café a descontinuar:");
		boolean resultado = cafeteria.descontinuarCafe(nombreCafe);

		if (resultado) {
			JOptionPane.showMessageDialog(this, "Café descontinuado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(this, "No se encontró un café con el nombre " + nombreCafe);
		}
	}

	private void modificarInfo() {
		String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre de la cafetería:", cafeteria.getNombre());
		String nuevaDireccion = JOptionPane.showInputDialog("Nueva dirección:", cafeteria.getDireccion());
		String redes = JOptionPane.showInputDialog("Redes sociales (separadas por comas):");

		List<String> nuevasRedes = new ArrayList<>();
		for (String red : redes.split(",")) {
			nuevasRedes.add(red.trim());
		}

		cafeteria.modificarInfo(nuevoNombre, nuevaDireccion, nuevasRedes);
		JOptionPane.showMessageDialog(this, "Información de la cafetería modificada.");
	}

	private void salir() {
		System.exit(0);
	}

	public static void main(String[] args) {
		// Crear una instancia de Cafeteria para inicializar la GUI
		List<String> redes = Arrays.asList("Instagram", "Facebook");
		Cafeteria cafeteria = new Cafeteria("Cafetería Central", "123 Calle Principal", redes);

		GuiCafeteria gui = new GuiCafeteria(cafeteria);
		gui.setVisible(true);
	}
}

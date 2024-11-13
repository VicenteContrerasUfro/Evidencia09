package gestioncafeteria;

import java.util.ArrayList;
import java.util.List;

public class Cafeteria {
	private String nombre;
	private String direccion;
	private List<String> redesSociales;
	private List<Cafe> cafes;

	// Constructor para inicializar una cafetería
	public Cafeteria(String nombre, String direccion, List<String> redesSociales) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.redesSociales = redesSociales;
		this.cafes = new ArrayList<>();
	}

	// Método para agregar un café a la lista de cafés
	public void agregarCafe(Cafe aCafe) {
		cafes.add(aCafe);
	}

	// Método para obtener cafés según el tamaño especificado
	public List<Cafe> obtenerCafesPorTamaño(String aTamaño) {
		List<Cafe> cafesPorTamaño = new ArrayList<>();
		for (Cafe cafe : cafes) {
			if (cafe.getTamaño().equalsIgnoreCase(aTamaño)) {
				cafesPorTamaño.add(cafe);
			}
		}
		return cafesPorTamaño;
	}

	// Método para descontinuar un café basado en el nombre
	public boolean descontinuarCafe(String nombreCafe) {
		for (Cafe cafe : cafes) {
			if (cafe.getNombre().equalsIgnoreCase(nombreCafe)) {
				cafes.remove(cafe);
				return true;
			}
		}
		return false; // Retorna falso si no encontró el café
	}

	// Método para modificar la información de la cafetería
	public void modificarInfo(String nuevoNombre, String nuevaDireccion, List<String> nuevasRedesSociales) {
		this.nombre = nuevoNombre;
		this.direccion = nuevaDireccion;
		this.redesSociales = nuevasRedesSociales;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<String> getRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(List<String> redesSociales) {
		this.redesSociales = redesSociales;
	}

	public List<Cafe> getCafes() {
		return cafes;
	}

	@Override
	public String toString() {
		return "Cafeteria{" +
				"nombre='" + nombre + '\'' +
				", direccion='" + direccion + '\'' +
				", redesSociales=" + redesSociales +
				", cafes=" + cafes +
				'}';
	}
}

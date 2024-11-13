package gestioncafeteria;

import java.util.List;

public class Cafe {
	private String nombre;
	private int gramosCafe;
	private int mlAgua;
	private String tamaño;
	private List<String> ingredientesOpcionales;

	public Cafe(String nombre, int gramosCafe, int mlAgua, String tamaño, List<String> ingredientesOpcionales) {
		this.nombre = nombre;
		this.gramosCafe = gramosCafe;
		this.mlAgua = mlAgua;
		this.tamaño = tamaño;
		this.ingredientesOpcionales = ingredientesOpcionales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGramosCafe() {
		return gramosCafe;
	}

	public void setGramosCafe(int gramosCafe) {
		this.gramosCafe = gramosCafe;
	}

	public int getMlAgua() {
		return mlAgua;
	}

	public void setMlAgua(int mlAgua) {
		this.mlAgua = mlAgua;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	public List<String> getIngredientesOpcionales() {
		return ingredientesOpcionales;
	}

	public void setIngredientesOpcionales(List<String> ingredientesOpcionales) {
		this.ingredientesOpcionales = ingredientesOpcionales;
	}

	public void actualizarDetalles(int gramosCafe, int mlAgua, String tamaño, List<String> ingredientesOpcionales) {
		this.gramosCafe = gramosCafe;
		this.mlAgua = mlAgua;
		this.tamaño = tamaño;
		this.ingredientesOpcionales = ingredientesOpcionales;
	}

	@Override
	public String toString() {
		return "Cafe{" +
				"nombre='" + nombre + '\'' +
				", gramosCafe=" + gramosCafe +
				", mlAgua=" + mlAgua +
				", tamaño='" + tamaño + '\'' +
				", ingredientesOpcionales=" + ingredientesOpcionales +
				'}';
	}
}

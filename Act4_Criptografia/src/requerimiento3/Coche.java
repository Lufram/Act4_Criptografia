package requerimiento3;

import java.io.Serializable;

public class Coche implements Serializable {

	private static final long serialVersionUID = 5892482677785015315L;
	
	private String matricula;
	private String marca;
	private String modelo;
	private String precio;
	
	public Coche() {
		super();
	}
	
	public Coche(String matricula, String marca, String modelo, String precio) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + "€" + "]";
	}
	
	
}

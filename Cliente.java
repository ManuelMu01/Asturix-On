
Hola Ramon, soy Hector


public class Cliente {
	private String nombre;
	private String dni;
	

	public Cliente(String n, String d) {
		this.setNombre(n);
		this.dni=dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public Cliente(String n,String dn) {
		nombre=n;
		dni=dn;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public String getDni() {
		return this.dni;
	}
	

}

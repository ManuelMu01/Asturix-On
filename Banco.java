
//Hola Joan, soy Hector

// Hola Ramon, soy Hector

import java.math.BigDecimal;
import java.util.LinkedList;

public class Banco {


	private String nombre;
	private LinkedList<Cuenta> cuentas;

	public Banco(String n) {
		cuentas=new LinkedList<Cuenta>();


	}

	public Cuenta abrirCuenta(Cliente c) {
		Cuenta nc=new Cuenta(c);
		this.cuentas.add(nc);

		return nc;

	}

	public void eliminarCuenta(Cuenta c) {

		this.cuentas.remove(c);

	}

	public Cuenta buscarCuenta(int n) {
		for (Cuenta c:this.cuentas) {
			if (c.getNum()==n) return c;


		}
		
		return null;

	}

	public Cuenta buscarCuenta(String dni) {
		for(Cuenta c:this.cuentas) {
			if (c.getCliente().getDni().equalsIgnoreCase(dni)) return c;

		}
		
		return null;

	}

	public BigDecimal dameLaPasta() {

		BigDecimal total=new BigDecimal(0);

		for(Cuenta c:this.cuentas) {
			total=total.add(c.getSaldo());

		}
		return total;


	}





=======
	private String nombre;
	private LinkedList<registro> registros;
	private LinkedList<Persona> personas;
	//clase cuentas para clientes
	public Banco(String n) {
		this.nombre=n;
		cuentas=new LinkedList<Cuenta>();
		
		
	}
	
	public Cuenta abrirCuenta(Cliente cli) {
		Cuenta nc=new Cuenta(cli);
	this.cuentas.add(nc);
		return nc;
	}
	
	public void delCuenta(Cuenta cuen) {
		this.cuentas.remove(cuen);
	}
	
	
	public BigDecimal dameLaPasta() {
		BigDecimal total=new BigDecimal(0);
		for(Cuenta c:this.cuentas) {
			total=total.add(c.getSaldo());
			
		}
		return total;
	}
	
	public Cuenta findCuenta(int id) {
		for(Cuenta cu:this.cuentas) {
			if(cu.getNum()==id) {
				return cu;
			}
			
		}
		return null;
	} 
	public Cuenta findCuenta(String dni) {
		for(Cuenta cu:this.cuentas) {
			if(cu.getDni().equalsIgnoreCase(dni)) {
				return cu;
			}
			
		}
		return null;
		
	}
	public LinkedList<Cuenta> getCuentas(){
		return this.cuentas;
	}


	public String getNombre() {
		return nombre;
	}
	

}

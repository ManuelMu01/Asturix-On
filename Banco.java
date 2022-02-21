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





}

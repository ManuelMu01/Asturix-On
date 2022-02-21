import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;

import excepciones.SaldoInsuficiente;
//Puedes añadir transferencias ente cuentas
public class Cuenta {
	private BigDecimal saldo;
	private int num;
	private String dni;
	private LinkedList<Movimiento> movimientos;
	private Cliente cliente;
	private static int numsig=1000;
	
	public Cuenta(Cliente cli) {
		this.saldo=new BigDecimal(0);
		this.cliente=cli;
		this.num=Cuenta.numsig++;
		this.movimientos=new LinkedList<Movimiento>();
	}
	
	
	public BigDecimal ingresar(BigDecimal importe,String concepto) {
		this.movimientos.add(new Movimiento(concepto,importe,this.saldo));
		this.saldo=importe.add(saldo);
		return this.saldo;
		
		}
	
	public BigDecimal retirardinero(BigDecimal importe) {
		if(this.saldo.compareTo(importe)==-1) {
			throw new SaldoInsuficiente("Saldo actual " + this.saldo+ " y quieres sacar " + importe);
		}
		
		this.movimientos.add(new Movimiento("retirada en efectivo",importe.negate(),this.saldo));
		this.saldo=importe.subtract(saldo);
		return this.saldo;
		
		
	}
	
	public LinkedList<Movimiento> BuscarMovimientos(Date fechaini,Date fechafin){
		LinkedList<Movimiento> lista=new LinkedList<Movimiento>();
		
		for(Movimiento m:lista) {
			if(m.getFecha().compareTo(fechaini)>0 && m.getFecha().compareTo(fechaini)<=0) {
				lista.add(m);
				
			}
			
		}
		return lista;
	}
	
	
	public BigDecimal getSaldo() {
		return this.saldo;
	}
	public int getNum() {
		return this.num;
	}
	public String getDni() {
		return this.dni;
	}
	public LinkedList<Movimiento> getMovimientos() {
		return this.movimientos;
	}


	public Cliente getCliente() {
		return cliente;
	}
	
	
	
}

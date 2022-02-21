import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;


import excecpciones.SaldoInsuficiente;

public class Cuenta {
	private BigDecimal saldo;
	private int num;
	private Cliente cliente;
	private LinkedList<Movimiento> movimientos;
	private static int numSig=1000;
	
	public Cuenta(Cliente c) {
		this.saldo=new BigDecimal(0);
		
		//this.num=Cuenta.numSig;
		//Cuenta.numSig++;
		
		this.num=Cuenta.numSig++;
		this.cliente=c;
		
		this.movimientos=new LinkedList<Movimiento>();
	}
	
	public BigDecimal ingresar(BigDecimal importe, String c) {
		
		//Movimiento m=new Movimiento(importe, this.saldo, c);
		//this.movimientos.add(m);
	
		
		this.movimientos.add(new Movimiento(importe, this.saldo, c));
		
		this.saldo=this.saldo.add(importe);
		
		return this.saldo;
	}

		public BigDecimal retirar(BigDecimal importe) {
			
			if (this.saldo.compareTo(importe)==-1) {
				throw new SaldoInsuficiente("Saldo actual: "+this.saldo+" y quieres sacar: "+importe);				
			}
		
			this .movimientos.add(new Movimiento(importe.negate(), this.saldo, "Retirada en efectivo"));
			
			this.saldo=this.saldo.add(importe);
			
			return this.saldo;
		
		
		}
		public LinkedList<Movimiento> buscarMovimientos(Date fechaIni, Date fechaFin){
			
			LinkedList<Movimiento> lista=new LinkedList<Movimiento>();
			
			for (Movimiento m:this.movimientos) {
				if ((m.getFecha().compareTo(fechaIni)>=0) && m.getFecha().compareTo(fechaFin)<=0){
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


		public Cliente getCliente() {
			return this.cliente;
		}
		
		
		public LinkedList<Movimiento> getMovimientos(){
			return this.movimientos;

		}















}



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


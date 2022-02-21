import java.math.BigDecimal;

import java.util.Date;

public class Movimiento {

	private Date fecha;
	private BigDecimal importe;
	private BigDecimal saldoAnterior;
	private BigDecimal saldoActual;
	private String concepto;
	
	public Movimiento(BigDecimal i, BigDecimal sant, String c  ) {
		this.fecha=new Date();
		this.importe=i;
		this.saldoAnterior=sant;
		this.saldoActual=sant.add(i);
		this.concepto=c;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public BigDecimal getSaldoActual() {
		return this.saldoActual;
	}

	public BigDecimal getSaldoAnterior() {
		return this.saldoAnterior;
	}

	public String getConcepto() {
		return this.concepto;
	}

	

	

	
	
	
	
	
	


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//Decir si es retirar o añadir dinero
public class Movimiento {
	private String concepto;
	private BigDecimal importe;
	private BigDecimal saldoAnt;
	private BigDecimal saldoAct;
	private Date fecha;
	
	public Movimiento(String con,BigDecimal imp,BigDecimal sal) {
		this.concepto=con;
		this.importe=imp;
		this.saldoAnt=sal;
		this.saldoAct=new BigDecimal(0);
		this.saldoAct.add(sal);		
		fecha=new Date();
	}
	
	public Date getFecha() {
		return this.fecha;
	}
	public String getConcepto() {
		return this.concepto;
	}
	public BigDecimal getImporte() {
		return this.importe;
	}
	public BigDecimal getSaldoAct() {
		return this.saldoAct;
	}
	public BigDecimal getSaldoAnt() {
		return this.saldoAnt;
	}
	

}

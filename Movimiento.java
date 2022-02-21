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

	

	

	
	
	
	
	
	

}

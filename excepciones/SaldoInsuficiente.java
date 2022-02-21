package excepciones;

public class SaldoInsuficiente extends RuntimeException {

	public SaldoInsuficiente() {
		super();
		
	}
	public SaldoInsuficiente(String msg) {
		super(msg);
		
	}
	
	
}

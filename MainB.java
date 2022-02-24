import java.util.Scanner;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		Edad edades=null;
		boolean error=true;
		
		Edad a1=new Edad(1,100);
		Edad a2=new Edad(1,100);
		
		a1.setEdad(16);
		a2.setEdad(26);
		
		System.out.println(a1.compareTo(a2)); // -1
		System.out.println(a2.compareTo(a1)); // 1
		System.out.println(a1.compareTo(a1)); // 0
		
		
		
		
		do {
			try {
				System.out.println("Edad m�nima:");
				int v = Integer.parseInt(sc.nextLine());
				System.out.println("Edad m�xima:");
				int v2 = Integer.parseInt(sc.nextLine());
				edaddes = new Edad(v, v2);
				error=false;
			} catch (RangoIncorrectoException e) {
				System.out.println("Valores incorrectos!!!");
			} catch (NumberFormatException e) {
				System.out.println("La edad debe ser un n�mero entero!!");
			}
		} while (error);
		
		
		error=true;
		do {
			try {
				System.out.println("Introduce tu edad");
				edad.setEdad(Integer.parseInt(sc.nextLine()));

				error=false;
			} catch (NumberFormatException e) {
				System.out.println("Edad incorrecta!!!");
			} catch (EdadFueraDeRangoException e) {
				System.out.println("La edad debe estar entre "+edades.getMin()+" y "+edades.getMax());
			}
		} while (error);

	}

}


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Editado por Joan
//Ramon no sabe de Java

import excepciones.SaldoInsuficiente;

public class Main {
	static SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy HH:mm");
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco bank=new Banco("Santander");
		String resp;
		do {
			System.out.println("Banco: " + bank.getNombre());
			System.out.println("---------------------------");
			System.out.println("1.Abrir cuenta");
			System.out.println("2.Buscar y modificar cuenta");
			System.out.println("3.Listar cuentas");
			System.out.println("x.Salir");
			System.out.println("4.Eliminar Cuenta");

			System.out.println("---------------------------");
			resp = sc.nextLine();
			System.out.println("***************************");
			if (resp.equals("1")) {
				System.out.println("Tu nombre?");
				String nom = sc.nextLine();
				String dn;
				boolean error;
				do {
					error=false;
					System.out.println("Tu dni?");
					dn = sc.nextLine();
					if(dn.length()!=9) {
						System.out.println("dni incorrecto");
						error=true;
					}

				} while (error);
				Cliente cli = new Cliente(nom, dn);
				menuCuenta(bank.abrirCuenta(cli),bank);
			}
			if (resp.equals("2")) {
				System.out.println("Buscar por \n 1.DNI \n 2.ID");
				switch (sc.nextLine()) {
				case "1":
					boolean error;
					String dn;
					do {
						error=false;
						System.out.println("Introduce tu dni");
						dn=sc.nextLine();
						if(dn.length()!=9) {
							System.out.println("dni incorrecto");
							error=true;
						}
					} while (error);
					menuCuenta(bank.findCuenta(dn),bank);
					break;
				case "2":
					System.out.println("Introduce tu id");
					menuCuenta(bank.findCuenta(Integer.parseInt(sc.nextLine())),bank);


				}


			}
			if(resp.equals("3")) {
				for(Cuenta cuen:bank.getCuentas()) {
					System.out.println("Nombre:"+cuen.getCliente().getNombre()+ "Dni:" + cuen.getDni());


				}

			}



		} while (!resp.equals("x"));
		System.out.println("Gracias por venir a nuestro banco");



	}

	public static void menuCuenta(Cuenta cuent,Banco bank) {
		String menu;
		do {

			System.out.println("---------------------------");
			System.out.println("1.Ingresar dinero");
			System.out.println("2.Retirar dinero");
			System.out.println("3.Historial de movimientos");
			System.out.println("4.Datos del cliente");
			System.out.println("5.Buscar movimientos");
			System.out.println("6.Eliminar cuenta");
			System.out.println("x.Salir");
			System.out.println("---------------------------");
			menu = sc.nextLine();
			System.out.println("***************************");
			if(menu.equals("1")) {
				System.out.println("Concepto del ingreso?");
				String con=sc.nextLine();

				boolean error;
				String ing;
				BigDecimal i=null;
				do {
					try {
						error=false;
						System.out.println("Dinero a ingresar?");
						ing = sc.nextLine();
						i = new BigDecimal(ing);
						if(i.intValue()<=0) {
							System.out.println("Ingreso no vàlido");
							error=true;
						}
					}catch(NumberFormatException e) {
						System.out.println("Formato incorrecto");
						error=true;
					}
				} while (error);


				cuent.ingresar(i,con);
				System.out.println("Dinero ingresado");
			}

			if(menu.equals("2")) {
				BigDecimal i = null;
				boolean error;
				do {
					try {
						error=false;
						System.out.println("Dinero a retirar?");
						String ing = sc.nextLine();
						i = new BigDecimal(ing);
						if(i.intValue()<=0) {
							System.out.println("Numero positivo porfavor");
							error=true;
						}
						cuent.retirardinero(i);
						System.out.println("Dinero retirado");
					}catch(NumberFormatException e) {
						System.out.println("Formato incorrecto");
						error=true;
					}catch(SaldoInsuficiente e) {
						error=true;
						System.out.println("Saldo insuficiente");
					}

				} while (error);


			}

			if(menu.equals("3")) {
				String fecha=null;
				for(Movimiento mov:cuent.getMovimientos()) {
					System.out.println(mov.getConcepto()+"----");

					System.out.println("Importe:" + mov.getImporte());
					fecha=formato.format(mov.getFecha());
					System.out.println("Fecha:" + fecha);
					System.out.println("___________________________");
				}


			}

			if(menu.equals("4")) {
				System.out.println("Dni:" + cuent.getDni());
				System.out.println("Nombre:" + cuent.getCliente().getNombre());
				System.out.println("Saldo:" + cuent.getSaldo());
			}
			if(menu.equals("5")) {
				Date fecha1=null;
				Date fecha2=null;
				String fecha;
				System.out.println("Fecha de inicio?");
				String fechaI=sc.nextLine()+" 00:00";
				System.out.println("Fecha de fin?");
				String fechaF=sc.nextLine()+" 23:59";
				try {
					fecha1=formato.parse(fechaI);
					fecha2=formato.parse(fechaF);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Movimiento mi:cuent.getMovimientos()) {
					if(mi.getFecha().compareTo(fecha1)==1 && mi.getFecha().compareTo(fecha2)==-1 || mi.getFecha().compareTo(fecha1)==0 ) {
						System.out.println(mi.getConcepto()+"----");

						System.out.println("Importe:" + mi.getImporte());
						fecha=formato.format(mi.getFecha());
						System.out.println("Fecha:" + fecha);
						System.out.println("___________________________");
					}


				}





			}











			if(menu.equals("6")) {
				bank.delCuenta(cuent);
				System.out.println("Cuenta eliminada");
			}




		} while (!menu.equalsIgnoreCase("x"));
	}




}

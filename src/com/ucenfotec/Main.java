package com.ucenfotec;

import java.io.*;
import Entities.*;
import Manager.*;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	static UserManager uManager = new UserManager();
	private static User sessionUser;

	public static void main(String[] args) throws Exception {
		// out.format("test: %s","1");
		// out.format("test: %d",1);
		// out.format("test: %f",1.1312);
		Start();
		DoIt();
	}

	public static void Menu(int pType) {
		switch (pType) {
		case 1:
			out.println("1- Iniciar Sesion.");
			out.println("2- Registrarme.");
			out.println("3- Precione cualquier letra para Salir.");
			break;
		case 2:
			out.println("1- Iniciar Gesti�n De Credito.");
			out.println("2- Continuar Gesti�n De Credito.");
			break;
		}
	}

	public static int Option() {
		try {
			out.print("Selecciona una opci�n: ");
			int op = Integer.parseInt(in.readLine());
			return op;
		} catch (Exception ex) {
			return -1;
		}

	}

	public static void Start() {
		try {
			Menu(1);
			switch (Option()) {
			case 1:
				Login();
				break;
			case 2:
				RegisterUser();
				break;
			default:
				System.exit(0);
				break;
			}
		} catch (Exception ex) {
			out.println("****************************************************");
			out.println("ERROR: -> " + ex.getMessage());
			out.println("****************************************************");

		} finally {
			Start();
		}

	}

	public static void Login() {
		try {
			String Email, Password;
			out.print("Escriba su Correo: ");
			Email = in.readLine();

			out.print("Escriba su Contrase�a: ");
			Password = in.readLine();
			User user = new User();
			user.EMAIL = Email;
			user.PASSWORD = Password;
			sessionUser = uManager.RetUser(user);
			out.println("---------------------------------------------------------------------------------");
			out.println("BIENVENIDO");
			out.println("Hola " + sessionUser.NAME + " " + sessionUser.LASTNAME+ "\n");
			DoIt();

		} catch (Exception ex) {
			out.println("****************************************************");
			out.println("ERROR: -> " + ex.getMessage());
			out.println("****************************************************");
		} finally {
			Login();
		}

	}

	public static void RegisterUser() throws Exception {
		out.println("Siga los pasos como se le indican. NO puede dejar datos en blanco.");
		out.println("Escriba su Nombre,Apellido,SegundoApellido,C�dula,Correo,Contrase�a \n");
		User user = new User(in.readLine());
		out.println("********************************************* \n" + uManager.CreUser(user)
				+ "\n*********************************************");

	}

	public static void DoIt() throws IOException {
		try {
			Menu(2);
			switch (Option()) {
			case 1:
				ModuleCredit();
				break;
			case 2:
				out.println("A�n no hay nada por aqu�");
				break;
			default:
				out.print("Escriba los datos correctamente... \n Preciona cualquier tecla para continuar:");
				in.readLine();
				break;
			}
		} catch (Exception ex) {
			out.println("****************************************************");
			out.println("ERROR: -> " + ex.getMessage());
			out.println("****************************************************");
		} finally {
			out.println("\n \n");
			out.print("Continuar? Y/N :");
			if (in.readLine().equalsIgnoreCase("Y")) {
				DoIt();
			}
			System.exit(0);
		}
	}

	public static void ModuleCredit() throws Exception{
		
		
	}

}

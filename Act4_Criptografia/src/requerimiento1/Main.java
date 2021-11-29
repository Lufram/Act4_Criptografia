package requerimiento1;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Main {

	public static void main(String[] args) {
		
		try {
			//Creamos el generador de claves
			KeyGenerator generador = KeyGenerator.getInstance("AES");
			//Generamos una clave simetrica
			SecretKey clave = generador.generateKey();
			
			//Creamos los objetos que se encargaran de encriptar y desencriptar y les pasamos la misma clave
			Encriptador encriptador = new Encriptador(clave);
			Desencriptador desencriptador = new Desencriptador(clave);
			
			Scanner read = new Scanner(System.in);
			
			//Variables
			String fraseCliente;
			byte[] fraseEncriptada = null;
			byte[] fraseDesencriptada;
			boolean continuar = true;
			
			//Hacemos el menu con un do while 
			do {
				System.out.println("-----------------------------------\n"
						+ "Tiene que elegir una de estas 4 opciones:\n1-.Salir del programa"
						+ "\n2-.Encriptar frase\n3-.Mostrar frase encriptada\n4-.Desencriptar frase");
	
				String valor = read.nextLine();
				
				//Validamos el menu para que solo se puedan seleccionar las opciones indicadas
				while (!valor.equals("3") && !valor.equals("1") &&!valor.equals("2") && !valor.equals("4")) {
					System.out.println("Tiene que escoger una de las 4 opciones");
					valor = read.nextLine();
				}
				
				switch (valor) {
					case "1":
						//Salimos del bucle por lo tanto se termina la ejecucion
						continuar = false;
						System.out.println("Cerrando programa");
						break;
					case "2":
						System.out.println("Escribe la frase que quieres encriptar");
						fraseCliente = read.nextLine();
						//Comprobaremos si hay contenido en la frase o no
						while(comprobar(fraseCliente)) {
							System.out.println("Tienes que escribir una frase");
							fraseCliente = read.nextLine();
						}
						//Utiliza un metodo del encriptador para encriptar la frase e indica que lo ha hecho
						fraseEncriptada = encriptador.encriptar(fraseCliente);
						System.out.println("La frase ha sido encriptada con el algoritmo AES y se ha guardado en memoria");
						break;
					case "3":
						//Si no hay nada encriptado lo indica y si lo hay lo muestra encriptado
						if (fraseEncriptada == null) {
							System.out.println("No hay ninguna frase encriptada en memoria");
						}else {
							System.out.println("Frase encriptada:\n" + new String(fraseEncriptada));							
						}
						break;
					case "4":
						//Si no hay nada encriptado lo indica y si hay algo encriptado utiliza un metodo del desencriptador para mostrarnos
						//la frase original
						if(fraseEncriptada == null) {
							System.out.println("No hay ninguna frase encriptada en memoria");
						}else {
							fraseDesencriptada = desencriptador.desencriptar(fraseEncriptada);
							System.out.println("Frase desencriptada:\n" + new String(fraseDesencriptada));
						}
						
						break;
				}

		}while(continuar);

			
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}
	
	//Metodo para comprobar si un String esta vacio o no
	public static boolean comprobar(String frase) {
		if(frase.trim().equals("")) {
			return true;
		}else {
			return false;			
		}
	}

}

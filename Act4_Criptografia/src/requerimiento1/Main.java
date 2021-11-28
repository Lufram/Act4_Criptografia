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
			KeyGenerator generador = KeyGenerator.getInstance("AES");
			SecretKey clave = generador.generateKey();
			
			Encriptador encriptador = new Encriptador(clave);
			Desencriptador desencriptador = new Desencriptador(clave);
			
			Scanner read = new Scanner(System.in);
			
			String fraseCliente;
			byte[] fraseEncriptada = null;
			byte[] fraseDesencriptada;
			boolean continuar = true;
			
			do {
				System.out.println("-----------------------------------\n"
						+ "Tiene que elegir una de estas 4 opciones:\n1-.Salir del programa"
						+ "\n2-.Encriptar frase\n3-.Mostrar frase encriptada\n4-.Desencriptar frase");
	
				String valor = read.nextLine();
				
				while (!valor.equals("3") && !valor.equals("1") &&!valor.equals("2") && !valor.equals("4")) {
					System.out.println("Tiene que escoger una de las 4 opciones");
					valor = read.nextLine();
				}
				
				switch (valor) {
					case "1":
						continuar = false;
						System.out.println("Cerrando programa");
						break;
					case "2":
						System.out.println("Escribe la frase que quieres encriptar");
						fraseCliente = read.nextLine();
						fraseEncriptada = encriptador.encriptar(fraseCliente);
						System.out.println("La frase a sido encriptada con el algoritmo AES y se ha guardado en memoria");
						break;
					case "3":
						if (fraseEncriptada == null) {
							System.out.println("No hay ninguna frase encriptada en memoria");
						}else {
							System.out.println("Frase encriptada:\n" + new String(fraseEncriptada));							
						}
						break;
					case "4":
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

}

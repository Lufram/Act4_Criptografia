package requerimiento3;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class Main {

	public static void main(String[] args) {
		
		try {
			KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
			KeyPair clave = generador.generateKeyPair();
			
			Encriptador encriptador = new Encriptador(clave);
			Desencriptador desencriptador = new Desencriptador(clave);
			EncriptadorObjetos encriptadorObjetos = new EncriptadorObjetos(clave);
			DesencriptadorObjetos desencriptadorObjetos = new DesencriptadorObjetos(clave);
			
			Scanner read = new Scanner(System.in);
			
			String fraseCliente;
			byte[] fraseEncriptada = null;
			byte[] fraseDesencriptada;
			SealedObject cocheEncriptado = null;
			Coche cocheDesencriptado;
			boolean continuar = true;
			
			do {
				System.out.println("-----------------------------------\n"
						+ "Tiene que elegir una de estas 4 opciones:\n1-.Salir del programa"
						+ "\n2-.Encriptar frase\n3-.Mostrar frase o coche encriptado\n4-.Desencriptar frase o coche"
						+ "\n5-.Encriptar Coche");
	
				String valor = read.nextLine();
				
				while (!valor.equals("3") && !valor.equals("1") &&!valor.equals("2") && !valor.equals("4") && !valor.equals("5")) {
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
						while(comprobar(fraseCliente)) {
							System.out.println("Tienes que escribir una frase");
							fraseCliente = read.nextLine();
						}
						fraseEncriptada = encriptador.encriptar(fraseCliente);
						cocheEncriptado = null;
						System.out.println("La frase a sido encriptada con el algoritmo RSA y se ha guardado en memoria");
						break;
					case "3":
						if (fraseEncriptada == null && cocheEncriptado == null) {
							System.out.println("No hay ninguna frase o coche encriptados en memoria");
						}else if(cocheEncriptado == null){
							System.out.println("Frase encriptada:\n" + new String(fraseEncriptada));							
						}else {
							System.out.println("Coche encriptado:\n" + cocheEncriptado);
						}
						break;
					case "4":
						if(fraseEncriptada == null && cocheEncriptado == null) {
							System.out.println("No hay ninguna frase o coche encriptados en memoria");
						}else if(cocheEncriptado == null){
							fraseDesencriptada = desencriptador.desencriptar(fraseEncriptada);
							System.out.println("Frase desencriptada:\n" + new String(fraseDesencriptada));
						}else {
							cocheDesencriptado = desencriptadorObjetos.desencriptarObjeto(cocheEncriptado);
							System.out.println("Coche desencriptado:\n" + cocheDesencriptado);
						}
						
						break;
					case "5":
						String  matricula, marca, modelo, precio;
						System.out.println("Introduce la matricula del coche");
						matricula = read.nextLine();
						while(comprobar(matricula)) {
							System.out.println("Tienes que escribir una matricula");
							matricula = read.nextLine();
						}
						System.out.println("Introduce la marca del coche");
						marca = read.nextLine();
						while(comprobar(marca)) {
							System.out.println("Tienes que escribir una marca");
							marca = read.nextLine();
						}
						System.out.println("Introduce el modelo del coche");
						modelo = read.nextLine();
						while(comprobar(modelo)) {
							System.out.println("Tienes que escribir un modelo");
							modelo = read.nextLine();
						}
						System.out.println("Introduce el precio del coche");
						precio = read.nextLine();
						while (!isNumeric(precio)) {
							System.out.println("Tienes que introducir un valor correcto");
							precio = read.nextLine();
						}
						Coche c1 = new Coche(matricula, marca, modelo, precio );
						cocheEncriptado = encriptadorObjetos.encriptarObjeto(c1);
						fraseEncriptada = null;
						System.out.println("El coche a sido encriptado con el algoritmo RSA y se ha guardado en memoria");
				}

		}while(continuar);

			read.close();
			
		} catch (GeneralSecurityException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    
	    try {
	        double d = Double.parseDouble(strNum);
	        if(Double.parseDouble(strNum) <= 0) {
	        	return false;
	        }
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean comprobar(String frase) {
		if(frase.trim().equals("")) {
			return true;
		}else {
			return false;			
		}
	}

}

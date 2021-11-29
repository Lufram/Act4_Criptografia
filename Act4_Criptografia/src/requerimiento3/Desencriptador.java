package requerimiento3;
import java.security.GeneralSecurityException;
import java.security.KeyPair;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Desencriptador {
	//Atributos
	 private KeyPair clave;
	 private Cipher desencriptador;
	 
	 //Constructor
	 public Desencriptador(KeyPair clave) throws GeneralSecurityException {
		 this.clave = clave;
		 desencriptador = Cipher.getInstance("RSA");
		 desencriptador.init(Cipher.DECRYPT_MODE, this.clave.getPrivate());
	 }
	 
	 //Metodo para desencriptar frases
	 public byte[] desencriptar(byte[] bytesFraseEncriptada) throws IllegalBlockSizeException, BadPaddingException {
		 byte[] bytesFraseNoEncriptada = desencriptador.doFinal(bytesFraseEncriptada);
		return bytesFraseNoEncriptada;
		 
	 }
}

package requerimiento3;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encriptador {
	 private KeyPair clave;
	 private Cipher encriptador;
	 
	 public Encriptador(KeyPair clave) throws GeneralSecurityException {
		 this.clave = clave;
		 this.encriptador = Cipher.getInstance("RSA");
		 encriptador.init(Cipher.ENCRYPT_MODE, this.clave.getPublic());
	 }
	 
	 public byte[] encriptar(String frase) throws IllegalBlockSizeException, BadPaddingException {
		 byte[] bytesFrase = frase.getBytes();
		 byte[] bytesFraseEncriptada = encriptador.doFinal(bytesFrase);
		return bytesFraseEncriptada;
		 
	 }

}

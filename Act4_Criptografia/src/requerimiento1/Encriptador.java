package requerimiento1;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encriptador {
	 private SecretKey clave;
	 Cipher encriptador;
	 
	 public Encriptador(SecretKey clave) throws GeneralSecurityException {
		 this.clave = clave;
		 this.encriptador = Cipher.getInstance("AES");
		 encriptador.init(Cipher.ENCRYPT_MODE, this.clave);
	 }
	 
	 public byte[] encriptar(String frase) throws IllegalBlockSizeException, BadPaddingException {
		 byte[] bytesFrase = frase.getBytes();
		 byte[] bytesFraseEncriptada = encriptador.doFinal(bytesFrase);
		return bytesFraseEncriptada;
		 
	 }

}

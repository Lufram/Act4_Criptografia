package requerimiento2;
import java.security.GeneralSecurityException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Desencriptador {
	 private SecretKey clave;
	 private Cipher desencriptador;
	 
	 public Desencriptador(SecretKey clave) throws GeneralSecurityException {
		 this.clave = clave;
		 desencriptador = Cipher.getInstance("AES");
		 desencriptador.init(Cipher.DECRYPT_MODE, this.clave);
	 }
	 
	 public byte[] desencriptar(byte[] bytesFraseEncriptada) throws IllegalBlockSizeException, BadPaddingException {
		 byte[] bytesFraseNoEncriptada = desencriptador.doFinal(bytesFraseEncriptada);
		return bytesFraseNoEncriptada;
		 
	 }
}

package requerimiento2;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class EncriptadorObjetos {
	private SecretKey clave;
	private Cipher encriptador;
	
	public EncriptadorObjetos(SecretKey clave) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		this.clave = clave;
		encriptador = Cipher.getInstance("AES");
		encriptador.init(Cipher.ENCRYPT_MODE, this.clave);
	}
	
	public SealedObject encriptarObjeto (Coche c1) throws IllegalBlockSizeException, IOException {
		SealedObject cocheCifrado = new SealedObject(c1, encriptador);
		return cocheCifrado;
		
	}
}

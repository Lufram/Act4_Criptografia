package requerimiento3;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class EncriptadorObjetos {
	private KeyPair clave;
	private Cipher encriptador;
	
	public EncriptadorObjetos(KeyPair clave) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		this.clave = clave;
		encriptador = Cipher.getInstance("RSA");
		encriptador.init(Cipher.ENCRYPT_MODE, this.clave.getPublic());
	}
	
	public SealedObject encriptarObjeto (Coche c1) throws IllegalBlockSizeException, IOException {
		SealedObject cocheCifrado = new SealedObject(c1, encriptador);
		return cocheCifrado;
		
	}
}

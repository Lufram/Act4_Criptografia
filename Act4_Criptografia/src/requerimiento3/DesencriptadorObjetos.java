package requerimiento3;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class DesencriptadorObjetos {
	private KeyPair clave;
	private Cipher desencriptador;
	
	public DesencriptadorObjetos(KeyPair clave) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		this.clave = clave;
		desencriptador = Cipher.getInstance("RSA");
		desencriptador.init(Cipher.DECRYPT_MODE, this.clave.getPrivate());
	}
	
	public Coche desencriptarObjeto (SealedObject cocheEncriptado) throws ClassNotFoundException, IllegalBlockSizeException, BadPaddingException, IOException {
		Coche cocheDesencriptado = (Coche)cocheEncriptado.getObject(desencriptador);
		return cocheDesencriptado;
		
	}
}

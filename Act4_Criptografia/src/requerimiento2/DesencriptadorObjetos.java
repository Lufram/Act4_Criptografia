package requerimiento2;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class DesencriptadorObjetos {
	//Aributos
	private SecretKey clave;
	private Cipher desencriptador;
	
	//Constructor
	public DesencriptadorObjetos(SecretKey clave) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		this.clave = clave;
		desencriptador = Cipher.getInstance("AES");
		desencriptador.init(Cipher.DECRYPT_MODE, this.clave);
	}
	
	//Metodo para desencriptar objetos
	public Coche desencriptarObjeto (SealedObject cocheEncriptado) throws ClassNotFoundException, IllegalBlockSizeException, BadPaddingException, IOException {
		Coche cocheDesencriptado = (Coche)cocheEncriptado.getObject(desencriptador);
		return cocheDesencriptado;
		
	}
}

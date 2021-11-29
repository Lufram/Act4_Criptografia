# Act4_Criptografia

## Requerimiento 1 📋

_Se pide hacer una aplicacion que encripte frases introducidas por el usuario de manera simétrica._

_Todos los datos se encriptaran usando el algoritmo "AES"_

### Cliente

_Vamos a hacer un menu en el que el usuario pueda introducir una frase y obtenerla mas tarde encriptada o sin encriptar ya que se guardara en memoria._

```
_El menu sería el siguiente:_

1. Salir del programa.
2. Encriptar frase.
3. Mostrar frase encriptada.
4. Desencriptar
```
### Cifradores

_Estos se encargaran de encriptar y desencriptar la frase del usuario mediante métodos creados especificamente para ello._

## Requermiento 2 📋

_Hay que añadir la opcion de encriptar un objeto coche a nuestra aplicación._

### Cliente

_Ahora el usuario tendrá disponible un opción que le permite introducir la matrícula, la marca, el modelo y el precio de su coche, estos datos se encriptarán y
se guardarán el memoria._

_El menú quedaría así_

1. Salir del programa.
2. Encriptar frase.
3. Mostrar frase o coche encriptado.
4. Desencriptar frase o coche.
5. Encriptar coche.

### Cifradores

_Se han añadido nuevos cifradores capaces de encriptar y desencriptar el objeto Coche utilizando métodos específicos para ello._

## Requerimiento 3 📋

_Tenemos que cambiar la forma de encriptar los datos de simétrica a asimétrica, por lo que se usarán claves públicas y privadas para ello._

_Se tratará de una encriptacion que busca la confidencialidad (RSA)_

### Cliente

_No se ha modificado nada que pueda afectar a la interfaz que percibe el usuario, pero si se ha modificado la funcionalidad para que la encriptación asimétrica funcione correctamente._

### Cifradores

_Se han modificado para que encripten y desencripten de forma asimétrica los datos._

## Restricciones
_Hay algunas validaciones en la aplicación para evitar su mal funcionamiento._

      -No se permite dejar campos vacios, para ello utilizamos los métodos _isNumeric()_ y _comprobar()_
      -Solo se pueden seleccionar las opciones mostradas en el menú, en caso de introduccir un valor distinto te lo indicará.
      -Si no hay ninguna frase u objeto encriptados te lo indicará.
      
## Despliegue 📦
_Dependiendo de que requerimiento quieras ejecutar tendrás que seleccionar uno u otro, dentro de estos la aplicación se inicia de la misma forma, solo hay que ejecutar la clase **Main** _

## Autores ✒️
* **Javier Barón Pérez** - (https://github.com/jabaron56)
* **Ismael De Gregorio López** - (https://github.com/Lufram)
* **Alberto Lozano Gómez** - (https://github.com/Tachenko)

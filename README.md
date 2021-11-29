# Act4_Criptografia

## Requerimiento 1

Se pide hacer una aplicacion que encripte frases introducidas por el usuario de manera simétrica.

Todos los datos se encriptaran usando el algoritmo "AES"

### Cliente

Vamos a hacer un menu en el que el usuario pueda introducir una frase y obtenerla mas tarde encriptada o sin encriptar ya que se guardara en memoria.

El menu sería el siguiente:

1. Salir del programa.
2. Encriptar frase.
3. Mostrar frase encriptada.
4. Desencriptar

### Cifradores

Estos se encargaran de encriptar y desencriptar la frase del usuario mediante métodos creados especificamente para ello.

## Requermiento 2

Hay que añadir la opcion de encriptar un objeto coche a nuestra aplicación.

### Cliente

Ahora el usuario tendrá disponible un opción que le permite introducir la matrícula, la marca, el modelo y el precio de su coche, estos datos se encriptarán y
se guardarán el memoria.

El menú quedaría así:

1. Salir del programa.
2. Encriptar frase.
3. Mostrar frase o coche encriptado.
4. Desencriptar frase o coche.
5. Encriptar coche.

### Cifradores

Se han añadido nuevos cifradores capaces de encriptar y desencriptar el objeto Coche utilizando métodos específicos para ello.

## Requerimiento 3

Tenemos que cambiar la forma de encriptar los datos de simétrica a asimétrica, por lo que se usarán claves públicas y privadas para ello.

Se tratará de una encriptacion que busca la confidencialidad (RSA)

### Cliente

No se ha modificado nada que pueda afectar a la interfaz que percibe el usuario, pero si se ha modificado la funcionalidad para que la encriptación asimétrica funcione correctamente.

### Cifradores

Se han modificado para que encripten y desencripten de forma asimétrica los datos.

## Restricciones
Hay algunas validaciones en la aplicación para evitar su mal funcionamiento.

      -No se permite dejar campos vacios, para ello utilizamos los métodos _isNumeric()_ y _comprobar()_
      -Solo se pueden seleccionar las opciones mostradas en el menú, en caso de introduccir un valor distinto te lo indicará.
      -Si no hay ninguna frase u objeto encriptados te lo indicará.
      
## Despliegue 📦
Dependiendo de que requerimiento quieras ejecutar tendrás que seleccionar uno u otro, dentro de estos la aplicación se inicia de la misma forma, solo hay que ejecutar la clase _Main_

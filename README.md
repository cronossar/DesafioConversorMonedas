# DesafioConversorMonedas

Estructura General

Importaciones:

import com.aluracurso.arregloAPI.TasaCambioAPI;: Es un m�todo para obtener tasas de cambio entre diferentes monedas. Es un servicio proveido por ExchangeRateAPI.

import java.util.Scanner;: Importa la clase Scanner para leer entradas del usuario.

Variables:

monedaBase y monedaDestino: Son variables est�ticas que almacenan las monedas involucradas en la conversi�n.

M�todo main ConversorMonedaApp.java
El main es el punto de entrada de la aplicaci�n:

Colores: Se definen variables de color para mejorar la presentaci�n en la consola.(Probando que se puede hacer)

Scanner: Se inicializa un objeto Scanner para leer la entrada del usuario.

Ciclo do-while: Se utiliza para mostrar un men� de opciones de conversi�n hasta que el usuario decida salir (opci�n 0).

Opciones de Conversi�n: Se imprimen diferentes opciones para convertir entre varias monedas (ARS a USD, USD a ARS, etc.).
Lectura de Opci�n: Se lee la opci�n seleccionada por el usuario.

Proceso de Conversi�n:

Si la opci�n no es 0, se pide al usuario que ingrese la cantidad a convertir.
Se usa un switch para determinar las monedas base y destino seg�n la opci�n seleccionada.

Obtener Tasa de Cambio:

Se llama a obtenerTasaCambio para obtener la tasa de conversi�n de la moneda base a la moneda destino usando la API.
Si hay un error al obtener la tasa, se captura la excepci�n y se imprime un mensaje de error, retornando un valor por defecto de 1.

Conversi�n:

Se llama al m�todo convertir, que multiplica la cantidad ingresada por la tasa de cambio para obtener el resultado de la conversi�n. Se imprime el resultado.

M�todos Auxiliares

obtenerTasaCambio:

Este m�todo se encarga de llamar a la API para obtener la tasa de cambio. Si ocurre un error, devuelve 1 como valor por defecto para evitar errores en la conversi�n.

convertir:

Este m�todo realiza la conversi�n multiplicando la cantidad por la tasa de cambio y retorna el resultado.

Registrar:
Se implementa un sencillo codigo para tomar las operaciones realizadas y guardarlas en un archivo txt.

GUI:
Solamente por curiosidad y no sin poca ayuda, se implementa un main para mostrar la app en un ambiente grafico utilizando la libreria swing.

Resumen
En resumen, este c�digo permite a los usuarios seleccionar diferentes opciones de conversi�n de moneda y realizar las oeraciones en funci�n de tasas de cambio obtenidas de una API. Utiliza un bucle para permitir m�ltiples conversiones hasta que el usuario decida salir tipenado la palabra "salir". Las excepciones manejan los fallos de la aplicaci�n y que as� no se rompa
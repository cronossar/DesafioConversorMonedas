# DesafioConversorMonedas

Estructura General
Importaciones:

import com.aluracurso.arregloAPI.TasaCambioAPI;: Importa una clase que probablemente contiene un método para obtener tasas de cambio entre diferentes monedas.
import java.util.Scanner;: Importa la clase Scanner para leer entradas del usuario.
Variables:

monedaBase y monedaDestino: Variables estáticas que almacenan las monedas involucradas en la conversión.
Método main
El main es el punto de entrada de la aplicación:

Colores: Se definen variables de color para mejorar la presentación en la consola.

Scanner: Se inicializa un objeto Scanner para leer la entrada del usuario.

Ciclo do-while: Se utiliza para mostrar un menú de opciones de conversión hasta que el usuario decida salir (opción 0).

Opciones de Conversión: Se imprimen diferentes opciones para convertir entre varias monedas (ARS a USD, USD a ARS, etc.).
Lectura de Opción: Se lee la opción seleccionada por el usuario.
Proceso de Conversión:

Si la opción no es 0, se pide al usuario que ingrese la cantidad a convertir.
Se usa un switch para determinar las monedas base y destino según la opción seleccionada.
Obtener Tasa de Cambio:

Se llama a obtenerTasaCambio para obtener la tasa de conversión de la moneda base a la moneda destino usando la API.
Si hay un error al obtener la tasa, se captura la excepción y se imprime un mensaje de error, retornando un valor por defecto de 1.
Conversión:

Se llama al método convertir, que multiplica la cantidad ingresada por la tasa de cambio para obtener el resultado de la conversión.
Se imprime el resultado.
Métodos Auxiliares
obtenerTasaCambio:

Este método se encarga de llamar a la API para obtener la tasa de cambio. Si ocurre un error, devuelve 1 como valor por defecto para evitar errores en la conversión.
convertir:

Este método realiza la conversión multiplicando la cantidad por la tasa de cambio y retorna el resultado.
Resumen
En resumen, este código permite a los usuarios seleccionar diferentes opciones de conversión de moneda y realizar las conversiones en función de tasas de cambio obtenidas de una API. Utiliza un bucle para permitir múltiples conversiones hasta que el usuario decida salir. Las excepciones se manejan para evitar que la aplicación falle por problemas al obtener tasas de cambio.
#  Conversor de Monedas en Java

Aplicación de consola desarrollada en Java que permite convertir monedas en tiempo real utilizando una API externa de tipo **Exchange Rate API**.  
Incluye validación de entradas, historial de conversiones y manejo de errores.

---

## 🚀 Funcionalidades

- Conversión entre:
    - USD ⇄ ARS
    - USD ⇄ BRL
    - USD ⇄ COP

- Validación de entradas de numeros (no permite letras ni valores inválidos)
- Historial de conversiones durante la sesión
- Limpieza del historial desde el menú
- Consumo de API en tiempo real
- Manejo de errores HTTP y de red

---

## 📁 Estructura del proyecto
src/

├── Main.java

├── ConsultaMoneda.java

├── Moneda.java

├── Conversion.java

├── HistorialDeConversiones.java

└── ValidacionesInput.java

---

## 🧠 Arquitectura

La aplicación sigue una separación clara de responsabilidades:

- `Main (Principal)`| Control del flujo del programa y menú 
- `ConsultaMoneda` | Comunicación con la API de tasas de cambio
- `Moneda` | Representa el JSON recibido de la API 
- `Conversion` | Representa una conversión individual
- `HistorialDeConversiones` | Almacena y gestiona el historial
- `ValidacionesInput` | Valida entradas del usuario

Esto permite que el código sea limpio, reutilizable y fácil de mantener.

---

## 🧭 Flujo de ejecución

1. Se muestra el menú principal.
2. El usuario selecciona una opción.
3. Se valida que la opción sea un número válido.
4. Se solicita el monto a convertir.
5. Se valida que el monto sea numérico y mayor que 0.
6. Se consulta la API.
7. Se muestra el resultado.
8. Se guarda en el historial.
9. El usuario puede ver o limpiar el historial.
10. El usuario puede salir cuando lo desee.

---

## 🔍 Validación de datos

Toda la entrada del usuario es validada usando la clase `ValidacionesInput`.

### Ejemplo
Si el usuario introduce: abc
el sistema responde: Entrada inválida. Debes ingresar solo números (por ejemplo: 1, 2, 3...).
Y vuelve a pedir el valor sin cerrar la aplicación.

---

## 🌐 Consumo de API

La aplicación utiliza la API: https://v6.exchangerate-api.com/

Ejemplo de endpoint:
/pair/USD/ARS/100

La respuesta se convierte automáticamente al record `Moneda` usando **Gson**.

---

## 🕓 Historial de conversiones

Cada conversión se guarda con:
- Fecha y hora
- Moneda origen
- Moneda destino
- Monto
- Resultado
- Tasa usada

Ejemplo de salida: [16/01/2026 18:42] 100.00 USD -> 87500.00 ARS (rate: 875.000000)

---

## ⚠️ Consideraciones importantes

### 1️⃣ API Key
La Api se ha establecido como variable de entorno:

```java
System.getenv("EXCHANGE_API_KEY");
```

### 2️⃣ El historial es temporal
El historial se mantiene solo en memoria.
Si se cierra la aplicación, el historial se pierde.

### 3️⃣ La aplicación no se cae por errores

Letras en el menú → Se vuelve a pedir.

Letras en el monto → Se vuelve a pedir.

Error de API → Se muestra mensaje y se continúa.


## ✨ ¿Y esto que es?
Proyecto desarrollado como ejercicio práctico para aprender:

- Java
- Consumo de APIs
- Arquitectura limpia
- Manejo de errores
- Programación orientada a objetos 





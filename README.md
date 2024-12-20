
Integrantes: - Mónica Jaña
             - Shamyr Quishpe
             - Miguel Carvajal
             - Freddy Villavicencio
             - Scarleth Luna
             - David Vela
             - Cristian Paredes
             
# 📱 Calculadora Básica en Kotlin para Android

Este proyecto es una aplicación Android desarrollada en **Kotlin** que implementa una **calculadora básica** con operaciones matemáticas estándar y funciones trigonométricas. A continuación, se proporciona una explicación detallada del código de la `MainActivity`.


### **Funciones de la Calculadora** 🧮

   - **`appendNumber(value: String)`**: Esta función se encarga de agregar el número que el usuario presiona al valor de entrada actual. Si el usuario ya está ingresando un número, simplemente lo concatena a `currentInput`. Si es un nuevo número, reinicia `currentInput`. 🔢
   
   - **`selectOperation(op: String)`**: Se llama cuando el usuario selecciona una operación matemática. Se guarda el primer operando (`firstOperand`) y se espera el segundo operando para realizar la operación. ➕➖✖️➗
   
   - **`calculateResult()`**: Realiza el cálculo de la operación seleccionada, usando `firstOperand` y `currentInput` como los dos operandos. Después de calcular el resultado, actualiza la pantalla y guarda el resultado en `currentInput` para posibles operaciones posteriores. 🎯
     - Si la operación es una división, verifica que el segundo operando no sea cero para evitar la división por cero. 🚫➗0️⃣
   
   - **`calculateTrigFunction(func: String)`**: Realiza el cálculo de funciones trigonométricas (`sin`, `cos`, `tan`). Convierte el valor ingresado en grados a radianes antes de realizar la operación. 📐
     - Si la operación es `tan`, también verifica que el valor de `cos` no sea cercano a cero (lo que resultaría en un valor indefinido para la tangente). ❌
   
   - **`clearDisplay()`**: Restablece todos los valores (entrada, operando, operación) y limpia la pantalla, mostrando un "0". 🧹0️⃣
   
   - **`updateDisplay(value: String)`**: Actualiza el texto del `TextView` para reflejar el valor calculado o ingresado. 🖥️

### 4. **Interacción con la Interfaz de Usuario** 💡
   El flujo de interacción es el siguiente:
   - El usuario ingresa un número presionando los botones del 0 al 9. 🔢
   - El usuario selecciona una operación matemática, lo que almacena el primer operando y la operación a realizar. ➕➖✖️➗
   - El usuario ingresa el segundo operando y presiona el botón "=" para calcular el resultado. 🎯
   - En caso de querer realizar funciones trigonométricas, se presionan los botones correspondientes (seno, coseno o tangente). 📐
   - El usuario puede limpiar la pantalla en cualquier momento con el botón "C". 🧹


<p align="center">
  <img src="https://github.com/user-attachments/assets/339c9401-af9a-4bbc-9faf-e761105fc11f" width="300"/>
</p>


# 📋 División de Tareas para la App

## 👩‍💻 **Mónica Jaña**
- **Diseño de la interfaz de usuario (UI)**:
  - Diseñar y maquetar la pantalla principal de la calculadora en XML.
  - Configurar los botones de la calculadora y la disposición del `TextView`.
  - Implementar la retroalimentación visual para los botones (colores, tamaños, etc.).
  - Verificar que la interfaz sea responsiva en diferentes tamaños de pantalla.
  
## 👨‍💻 **Shamyr Quishpe**
- **Implementación de las operaciones básicas**:
  - Programar las funciones matemáticas básicas (suma, resta, multiplicación, división).
  - Implementar la lógica para la entrada de números y el cálculo de resultados.
  - Asegurar que la operación se ejecute correctamente cuando el usuario presiona "igual (=)".
  - Manejar la validación para evitar errores como la división por cero.

## 👨‍💻 **Miguel Carvajal**
- **Implementación de funciones trigonométricas**:
  - Implementar las funciones trigonométricas (`sin`, `cos`, `tan`) utilizando la librería `Math` de Kotlin.
  - Asegurar que las funciones trigonométricas funcionen correctamente con valores en grados y convertirlos a radianes.
  - Gestionar los casos de error para valores indefinidos (como el caso de la tangente cuando el valor del coseno es 0).
  
## 👨‍💻 **Freddy Villavicencio**
- **Gestión de estado y lógica de la calculadora**:
  - Programar la lógica para almacenar y manejar el primer operando y la operación seleccionada.
  - Asegurarse de que el valor de la entrada se resetea correctamente al realizar una operación o al presionar "C".
  - Implementar el manejo de la entrada del usuario, asegurándose de que solo se pueda ingresar un número o resultado válido.
  
## 🛠️ **Generación del APK**:
- **Responsable**: Todo el equipo
  - Al finalizar las implementaciones y pruebas, generar la APK.
  - Asegurarse de que la APK esté optimizada para su distribución.

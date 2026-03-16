# The Voice of Braille

The Voice of Braille es una aplicación de escritorio desarrollada en Java, diseñada para controlar una impresora Braille a través de una interfaz accesible. El sistema está pensado para personas con discapacidad visual, permitiendo la conversión de texto digital a Braille físico mediante una interacción intuitiva que incluye comandos de voz y retroalimentación auditiva.

## ✨ Características Principales

- **✒️ Editor de Texto Integrado**: Incluye un área de texto para escribir o pegar el contenido a imprimir, con un límite de 250 caracteres por impresión.
- **📁 Gestión de Archivos**: Permite crear, abrir, guardar y guardar como archivos de texto (`.txt`), facilitando la reutilización de documentos.
- **🗣️ Control por Voz y Dictado**:
    - **Reconocimiento de Comandos**: Activa funciones clave de la aplicación (imprimir, guardar, etc.) mediante comandos de voz.
    - **Dictado a Texto**: Convierte la voz del usuario directamente a texto en el editor.
- **🔊 Síntesis de Voz (TTS)**:
    - **Lectura de Texto**: Lee en voz alta el contenido del área de texto.
    - **Retroalimentación Auditiva**: Notifica al usuario sobre el estado de la aplicación (ej. "Comandos activados", "Impresora conectada").
- **🔌 Conectividad con Arduino**: Escanea los puertos seriales disponibles, permite la conexión con la placa Arduino que controla la impresora y muestra el estado de la conexión.
- **🖨️ Impresión en Braille**: Envía el texto del editor al Arduino para ser impreso en formato Braille físico.
- **🔡 Visualizador de Fuente Braille**: Permite alternar la fuente del editor entre texto estándar y una fuente que simula los caracteres Braille.
- **⚙️ Configuración Personalizable**: Guarda la configuración del directorio por defecto y el puerto de la impresora para futuras sesiones.

## 🛠️ Cómo Funciona

La aplicación funciona como una interfaz de control para un hardware externo basado en Arduino. El flujo de trabajo es el siguiente:

1.  **Entrada de Texto**: El usuario introduce el texto en la aplicación, ya sea escribiéndolo, abriendo un archivo o usando el dictado por voz.
2.  **Conversión a Braille**: La lógica interna de la aplicación (clase `Braille.java`) procesa el texto y lo convierte en los patrones de puntos correspondientes al sistema Braille.
3.  **Comunicación Serial**: La aplicación envía las instrucciones (los patrones de Braille) al dispositivo Arduino a través del puerto serial (USB).
4.  **Impresión Física**: El firmware del Arduino recibe las instrucciones y activa los actuadores (solenoides o motores) de la impresora para marcar los puntos en el papel.

## 🚀 Tecnologías Utilizadas

- **Lenguaje de Programación**: Java 8
- **Interfaz Gráfica**: Java Swing
- **Comunicación Serial**: Biblioteca `PanamaHitek_Arduino`
- **Reconocimiento y Síntesis de Voz**: Java Speech API (JSAPI)
- **Hardware**: Placa Arduino (o compatible) para controlar la impresora Braille.
- **Entorno de Desarrollo**: Apache NetBeans

## 🟢 Cómo Empezar

### Requisitos Previos

- Tener **Java Development Kit (JDK) 8** o superior instalado.
- Tener el **hardware de la impresora Braille** conectado a la placa Arduino.
- Tener el **firmware correcto** cargado en la placa Arduino.

### Pasos para Usar la Aplicación

1.  **Conectar el Hardware**: Conecta la placa Arduino a la computadora mediante un cable USB.
2.  **Ejecutar la Aplicación**: Inicia la aplicación (ej. ejecutando el archivo `.jar`).
3.  **Configurar la Conexión**:
    - En el panel de "Dispositivos Bluetooth" (que en realidad maneja puertos seriales), haz clic en **Escanear**.
    - Selecciona el puerto COM correspondiente a tu Arduino en la lista desplegable.
    - Haz clic en **Conectar**. El estado cambiará a "Conectado".
4.  **Introducir Texto**: Escribe en el área de texto, abre un archivo o usa el botón de "Iniciar Dictado por Voz".
5.  **Imprimir**:
    - Una vez conectado y con el texto listo, el botón **Imprimir** se habilitará.
    - Al hacer clic, la aplicación enviará los datos al Arduino para que comience la impresión.

## 📂 Estructura del Proyecto

El código fuente está organizado en los siguientes paquetes principales:

- **`Ventanas`**: Contiene todas las clases de la interfaz gráfica (JFrame, JDialog), incluyendo la ventana principal (`Inicio.java`) y las secundarias (configuración, créditos, ayuda).
- **`Conexiones`**: Incluye las clases responsables de la lógica de negocio y la comunicación con el exterior:
    - `Arduino.java`: Gestiona la comunicación serial con el hardware.
    - `Voz.java` y `Comandos_Voz.java`: Manejan el reconocimiento de voz.
    - `LeerTTS.java`: Provee la funcionalidad de texto a voz.
    - `FileManager.java`: Administra las operaciones de lectura y escritura de archivos.
- **`Braille`**: Contiene la lógica para la conversión de texto a Braille (`Braille.java`) y la gestión de la fuente especializada (`FontBraille.java`).
- **`Imagenes`**: Almacena los recursos gráficos de la interfaz.
- **`Librerias`**: Contiene las bibliotecas `.jar` de las que depende el proyecto.

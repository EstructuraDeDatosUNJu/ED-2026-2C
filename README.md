# Estructura de Datos - 2026 - Trabajos Prácticos

## 👥 Integrantes

* **Nombre y Apellido:** Julio Tentor
* **Email:** <jtentor@fi.unju.edu.ar>

---

## 📝 Descripción del Proyecto

Este repositorio contiene la resolución de algunos ejercicios para la materia **Estructura de Datos (ED2026)**.

La carpeta `src/main/java/ed2026/` contiene la implementación de la lógica de algunos ejercicios y trabajos prácticos, mientras que

La carpeta `src/test/java/ed2026/` contiene los casos de prueba automatizados que permiten validar la correcta implementación de parte de la lógica de algunos ejercicios.

---

Pueden clonar este repositorio y ejecutar los casos de prueba para verificar que la lógica implementada funciona correctamente.

También pueden crear un Fork de este repositorio y luego clonar su propio repositorio para trabajar de manera local desarrollando la lógica de cada ejercicio y los casos de prueba correspondientes.

En este último caso se sugiere agregar una carpeta 'src/main/java/[tu-nombre]' para implementar su propia lógica en cada ejercicio, y una carpeta 'src/test/java/[tu-nombre]' para los casos de prueba.

---

La estructura de carpetas puede utilizarse en el o los proyectos integradores finales.

---

Este proyecto está desarrollado en **Java**; la gestión de dependencias se realiza mediante **Maven**.

En caso de usar un IDE como IntelliJ IDEA o Eclipse, se recomienda importar el proyecto como un proyecto Maven.

Personalmente utilizo **Visual Studio Code** con la extensión **Java Extension Pack** y la extensión **Maven for Java**.

## 🛠️ Requisitos

Para compilar y ejecutar este proyecto en un entorno local se necesita tener instalado:

* **Java JDK:** Versión 25 (o superior)
* **Apache Maven:** Versión 3.6 o superior
* **Git**

---

## 🚀 Ejecución y Pruebas

Descargar y verificar el proyecto:

### 1.a. Clonar el repositorio desde EstructuraDeDatosUNJu

```bash
cd [Directorio-De-Trabajo]
git clone https://github.com/EstructuraDeDatosUNJu/ED-2026-2C [Nombre-De-Tu-Repositorio-Local]
cd [Nombre-De-Tu-Repositorio-Local]
```

### 1.b. Clonar el repositorio desde un Fork de EstructuraDeDatosUNJu

Antes tienes que haber realizado el Fork en GitHub

```bash
cd [Directorio-De-Trabajo]
git clone https://github.com/[Tu-Usuario-De-GitHub]/[Nombre-De-Tu-Repositorio].git [Nombre-De-Tu-Repositorio-Local]
cd [Nombre-De-Tu-Repositorio-Local]
```

### 2. Compilar el proyecto

Este comando limpia compilaciones previas y descarga las dependencias necesarias:

```bash
mvn clean compile
```

### 3. Ejecutar las Pruebas Unitarias (JUnit)

Validar que la lógica implementada funciona correctamente sin necesidad de una interfaz gráfica:

```bash
mvn test
```

---

## 📂 Estructura del Repositorio

* `src/main/java/ed2026/`: Código fuente principal.
* `src/test/java/ed2026/`: Casos de prueba automatizados.
* `pom.xml`: Configuración de Maven (dependencias de JUnit 5).

* `formatter.xml`: Configuración del formateador de código para Java en Visual Studio Code.

---

## 📜 Licencia

Este proyecto está bajo la licencia [![License](https://img.shields.io/badge/CC0_1.0_Universal-blue.svg)](https://creativecommons.org/publicdomain/zero/1.0/legalcode.es).


# Actividad 2 - Desarrollo en Java con Maven

## Información del desarrollador

- **Nombre:** Cristian Mayuti
- **Actividad:** Trabajo práctico Actividad 2 – Java
- **Carrera:** Licenciatura en Tecnologías Digitales
- **Materia:** Programación de Vanguardia (Java - ChatGPT)
- **Fecha:** 10 de abril de 2025

---

## 🛠 Entorno de desarrollo

El desarrollo se realizó en **Visual Studio Code** sobre Windows 10, utilizando **Java 22.0.2** y **Apache Maven 3.9.6**.

Versión de Maven ejecutada en terminal:

```bash
C:\Users\admin>mvn --version
Apache Maven 3.9.6 (bc0240f3c744dd6b6ec2920b3cd08dcc295161ae)
Maven home: C:\apache-maven-3.9.6
Java version: 22.0.2, vendor: Oracle Corporation, runtime: C:\jdk-22.0.2
Default locale: en_US, platform encoding: UTF-8
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

---

## Estructura del proyecto

Se creó un proyecto Maven utilizando el siguiente comando:

```bash
mvn archetype:generate -DgroupId=ar.edu.udeci.pv -DartifactId=Actividad2 -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -Dversion=1.0-SNAPSHOT -DinteractiveMode=false
```

Salida:

> El proyecto se generó exitosamente en el directorio `C:\Users\admin\Actividad2` con la estructura estándar de Maven.

---

## Dependencias utilizadas

Se agregaron las siguientes dependencias en el archivo `pom.xml`:

### Apache Commons CLI

- Versión: 1.5.0
- Funcionalidad: Interpretación de argumentos por línea de comandos.

### Apache Log4j (Core + API)

- Versión: 2.24.3
- Funcionalidad: Registro de logs de eventos y mensajes de la aplicación.

---

## Ejemplo de código

El archivo `App.java` incluye el uso de ambas librerías:

```java
Options options = new Options();
options.addOption("n", "name", true, "Nombre de usuario");

CommandLineParser parser = new DefaultParser();
CommandLine cmd = parser.parse(options, args);

String name = cmd.getOptionValue("n");
logger.info("Hola, " + name + "!");
System.out.println("Hola, " + name + "!");
```

---

## Compilación y ejecución

### Compilación del proyecto y generación de JAR:

```bash
mvn clean package
```

Salida destacada:

```bash
[INFO] Building jar: C:\Users\admin\Actividad2\target\Actividad2-1.0-SNAPSHOT.jar
[INFO] BUILD SUCCESS
```

El archivo generado se encuentra en:

```
target/Actividad2-1.0-SNAPSHOT.jar
```

### Ejecución del JAR con argumentos:

```bash
java -jar target/Actividad2-1.0-SNAPSHOT.jar -n Juan
```

También se probó la ejecución vía plugin `exec`:

```bash
mvn exec:java -Dexec.mainClass="ar.edu.udeci.pv.App" -Dexec.args="-n Juan"
```

Salida esperada:

```
18:21:46 [ar.edu.udeci.pv.App.main()] INFO : Hola, Juan!
Hola, Juan!
```

---

## Configuración del logger

Se configuró el archivo `log4j2.xml` en `src/main/resources` con la siguiente estructura:

```xml
<Configuration status="WARN">
  <Appenders>
    <Console name="Console" target="SYSTEM_OUT">
      <PatternLayout pattern="%d{HH:mm:ss} [%t] %-5level: %msg%n"/>
    </Console>
  </Appenders>
  <Loggers>
    <Root level="info">
      <AppenderRef ref="Console"/>
    </Root>
  </Loggers>
</Configuration>
```

---

## Comentarios finales

El proyecto fue desarrollado de manera modular, respetando buenas prácticas de codificación y dependencias gestionadas con Maven. Se hizo especial hincapié en demostrar el uso funcional de las librerías solicitadas mediante ejemplos simples y claros.

---

## 🔗 Repositorio en GitHub

[Repositorio GitHub del proyecto](https://github.com/mayuti/actividad2-java)  
_(Completar al subir el proyecto)_

---

_Desarrollado por Cristian Mayuti - Abril 2025_

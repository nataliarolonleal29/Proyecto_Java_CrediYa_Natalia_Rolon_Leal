# Proyecto Java Sistema de Cobros de Cartera CrediYa

## Natalia Rolón Leal

Sistema de gestión de clientes, empleados, préstamos y pagos desarrollado en Java con arquitectura en capas (MVC + DAO + Utilidades), conexión a base de datos relacional MySQL y persistencia/respaldo en archivos de texto.

---


## Acerca del Proyecto

**Proyecto_Java_CrediYa** es una aplicación de consola modular diseñada para gestionar las operaciones fundamentales de una entidad crediticia. El sistema permite registrar, consultar, actualizar, eliminar y respaldar la información referente a:
- **Clientes:** Gestión de datos personales y de contacto.
- **Empleados:** Control de personal y roles de la entidad.
- **Préstamos:** Registro de montos, tasas de interés y estados.
- **Pagos:** Seguimiento e historial de amortizaciones.

---

## Arquitectura del Sistema

El proyecto está diseñado bajo un enfoque de **Separación de Responsabilidades** siguiendo los patrones:
- **MVC (Modelo-Vista-Controlador):** Desacopla la lógica de presentación (consola) de la lógica de negocio y persistencia.
- **DAO (Data Access Object) + Genéricos:** Uso de la interfaz `ICrudDAO<T>` para estandarizar las operaciones de acceso a datos sin duplicación de código.
- **Try-With-Resources & PreparedStatement:** Garantiza la gestión eficiente y segura de conexiones JDBC y previene ataques de inyección SQL.


---

## Tecnologías Utilizadas

- **Lenguaje:** Java (JDK 17+)
- **IDE:** Apache NetBeans IDE
- **Base de Datos:** MySQL
- **Conector DB:** MySQL Connector/J (JDBC)
- **Control de Versiones:** Git & GitHub

---

## Estructura del Proyecto

```text
src/main/java/com/mycompany/proyecto_java_crediya/
├── Controlador/
│   ├── ClienteController.java
│   ├── EmpleadoController.java
│   ├── PagoController.java
│   ├── PrestamoController.java
│   └── ReporteController.java
├── Modelo/
│   ├── Clases/
│   │   ├── Cliente.java
│   │   ├── Empleado.java
│   │   ├── Pago.java
│   │   ├── Persona.java
│   │   └── Prestamo.java
│   └── Persistencia/
│       ├── ClienteDAO.java
│       ├── ConexionDB.java
│       ├── EmpleadoDAO.java
│       ├── ICrudDAO.java
│       ├── PagoDAO.java
│       └── PrestamoDAO.java
├── Util/
│   ├── ArchivoUtil.java
│   └── ValidadorUtil.java
├── Vista/
│   └── MenuClientes.java
└── Proyecto_Java_CrediYa.java (Clase Principal)

```


## Requisitos Previos
Antes de ejecutar el proyecto, asegúrate de contar con los siguientes elementos instalados:

- Java Development Kit (JDK 17 o superior).

- Apache NetBeans IDE (o cualquier IDE de preferencia con soporte Java Maven/Ant).

- Servidor MySQL (a través de MySQL Workbench, XAMPP o Docker).

- El driver MySQL Connector/J en las dependencias del proyecto.



## Configuración e Instalación
Clonar el repositorio:

git clone [https://github.com/nataliarolonleal29/Proyecto_Java_CrediYa_Natalia_Rolon_Leal.git](https://github.com/tu-usuario/Proyecto_Java_CrediYa.git)


## Configurar la Base de Datos:

Abre MySQL y ejecuta el script de creación de la base de datos y sus tablas (clientes, empleados, prestamos, pagos).

Ajusta las credenciales de conexión (URL, usuario y contraseña) en la clase ConexionDB.java:


``` java
String url = "jdbc:mysql://localhost:3306/crediya_db";
String user = "root";
String password = "tu_contraseña";
```

## Abrir y Ejecutar:

Abre el proyecto en Apache NetBeans IDE.

Haz clic derecho sobre el proyecto y selecciona Clean and Build (Shift + F11).

Ejecuta la clase principal Proyecto_Java_CrediYa.java (F6).


## Diagrama UML

![diagrama_uml](/img/diagramaUML.JPG)

En caso de que no se vea muy bien el diagrama, este es el link para visualizarlo mejor:
https://drive.google.com/file/d/1OC8NZNiFWqcZXYln7jKE8vb8L8IeB4OK/view?usp=sharing



## Demostración y Capturas de Pantalla
A continuación se presentan las evidencias de funcionamiento del sistema en ejecución:

**1. Menú Principal y Navegación**
![menu_principal](/img/ejecucion1.JPG)

**2. Gestión de empleados**
![empleados_1](/img/ejecucion2.JPG)
![empleados_2](/img/ejecucion3.JPG)
![empleados_3](/img/ejecucion4.JPG)
![empleados_4](/img/ejecucion5.JPG)
![empleados_5](/img/ejecucion6.JPG)
![empleados_6](/img/ejecucion7.JPG)
![empleados_7](/img/ejecucion8.JPG)
![empleados_8](/img/ejecucion9.JPG)
![empleados_9](/img/ejecucion10.JPG)



**3. Gestión de clientes**
![clientes_1](/img/ejecucion11.JPG)
![clientes_2](/img/ejecucion12.JPG)
![clientes_3](/img/ejecucion13.JPG)
![clientes_4](/img/ejecucion14.JPG)
![clientes_5](/img/ejecucion15.JPG)
![clientes_6](/img/ejecucion16.JPG)
![clientes_7](/img/ejecucion17.JPG)
![clientes_7](/img/ejecucion18.JPG)



**4. Gestión de préstamos**
![prestamos_1](/img/ejecucion19.JPG)
![prestamos_2](/img/ejecucion20.JPG)
![prestamos_3](/img/ejecucion21.JPG)
![prestamos_4](/img/ejecucion22.JPG)
![prestamos_5](/img/ejecucion23.JPG)
![prestamos_6](/img/ejecucion24.JPG)
![prestamos_7](/img/ejecucion25.JPG)
![prestamos_8](/img/ejecucion26.JPG)
![prestamos_9](/img/ejecucion27.JPG)
![prestamos_10](/img/ejecucion28.JPG)
![prestamos_11](/img/ejecucion29.JPG)
![prestamos_12](/img/ejecucion30.JPG)



**5. Gestión de pagos**
![pagos_1](/img/ejecucion31.JPG)
![pagos_2](/img/ejecucion32.JPG)
![pagos_3](/img/ejecucion33.JPG)
![pagos_4](/img/ejecucion34.JPG)
![pagos_5](/img/ejecucion35.JPG)
![pagos_6](/img/ejecucion36.JPG)


## Autora
Natalia Rolón Leal
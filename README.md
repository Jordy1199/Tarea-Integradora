# Sistema de Gestión de Personal para Clínica Privada

## Descripción

Sistema desarrollado en Java para automatizar el registro y control de personal en una clínica privada. Implementa conceptos fundamentales de Programación Orientada a Objetos.

---
### Descripción de Paquetes

- **modelo/**: Clases del negocio (Empleado, Medico, Administrativo)
- **servicio/**: CRUD y operaciones (EmpleadoServicio)
- **util/**: Validaciones (Validador)
- **app/**: Menú principal (Main)

---

## 1. HERENCIA

La herencia permite que las subclases `Medico` y `Administrativo` hereden de la clase padre `Empleado`.

**Ejemplo:**
```java
public class Medico extends Empleado {
    private String especialidad;
    private int numeroPacientesAtendidos;
    private double valorConsulta;
}

public class Administrativo extends Empleado {
    private String departamento;
    private int horasTrabajadas;
    private double valorHora;
}
```

**Beneficio:** Reutilizar atributos y métodos comunes (cedula, nombre, edad, telefono, correo).

---

## 2. ENCAPSULAMIENTO

Todos los atributos son privados con métodos getter y setter públicos para acceder a ellos.

**Ejemplo:**
```java
private String cedula;
private String nombre;
private int edad;

public String getCedula() {
    return cedula;
}

public void setCedula(String cedula) {
    this.cedula = cedula;
}
```

**Beneficio:** Proteger los datos y controlar el acceso a ellos.

---

## 3. POLIMORFISMO

El polimorfismo permite sobrescribir métodos en las subclases con implementaciones diferentes.

**Ejemplo:**
```java
// En Medico
@Override
public double calcularPago() {
    return numeroPacientesAtendidos * valorConsulta;
}

// En Administrativo
@Override
public double calcularPago() {
    return horasTrabajadas * valorHora;
}
```

**Beneficio:** Mismo método, diferentes comportamientos según el tipo de empleado.

---

## 4. EXCEPCIONES

Se utilizan para capturar y manejar errores en tiempo de ejecución.

**Ejemplo:**
```java
try {
    opcion = Validador.obtenerEntero(scanner.nextLine());
} catch (NumberFormatException e) {
    System.out.println("✗ Error: opción inválida. Ingrese un número del 1 al 9.\n");
}
```

**Palabras clave:**
- `try`: Encierra el código que puede fallar
- `catch`: Captura y controla el error
- `finally`: Se ejecuta siempre
- `throw`: Lanza un error manualmente
- `throws`: Avisa que un método puede lanzar error

**Excepciones manejadas:**
- `NumberFormatException`: Conversión inválida de texto a número
- `InputMismatchException`: Tipo de dato no coincide
- `IndexOutOfBoundsException`: Índice fuera de rango
- `NullPointerException`: Acceso a objeto nulo

---

## 5. CONVERSIONES

Permiten cambiar un tipo de dato a otro.

**Conversión String a int:**
```java
String edad = "25";
int edadInt = Integer.parseInt(edad);
```

**Conversión String a double:**
```java
String valor = "15.75";
double precio = Double.parseDouble(valor);
```

**Conversión explícita (casting):**
```java
double promedio = 9.8;
int nota = (int) promedio;  // Resultado: 9 (se pierde 0.8)
```

**Riesgos:** Pérdida de información al convertir double a int.

---

## 6. VALIDACIONES

Aseguran que los datos cumplan requisitos antes de procesarlos.

**Validaciones implementadas:**

```java
validarOpcionMenu(opcion)           // 1-9
validarEdad(edad)                   // 1-149
validarCedulaDuplicada(cedula)      // No repetidas
validarNombre(nombre)               // No vacío
validarCorreo(correo)               // Contiene @ y .
validarTelefono(telefono)           // Solo números
validarEspecialidad(especialidad)   // No vacío
validarDepartamento(departamento)   // No vacío
validarPacientesAtendidos(pacientes) // Mayor a 0
validarValorConsulta(valor)         // Mayor a 0
validarHorasTrabajadas(horas)       // Mayor a 0
validarValorHora(valor)             // Mayor a 0
```

**Ejemplo:**
```java
if (!Validador.validarEdad(edad)) {
    System.out.println("✗ Error: La edad debe ser entre 1 y 149 años.\n");
}
```

---

## Funcionalidades Principales

- Registrar médicos y administrativos
- Mostrar todos los empleados
- Buscar empleados por cédula
- Actualizar información de empleados
- Eliminar empleados
- Calcular pagos
- Mostrar estadísticas

---

## Cómo Ejecutar

### Compilar
```bash
javac -d bin src/**/*.java
```

### Ejecutar
```bash
java -cp bin app.Main
```

---

## Requisitos

- Java 8 o superior
- IDE: IntelliJ IDEA, Eclipse o NetBeans

---

## Tecnologías Utilizadas

- **Lenguaje**: Java
- **Paradigma**: Programación Orientada a Objetos (POO)
- **Estructura de datos**: ArrayList
- **Control de versiones**: Git

---

## Autor

**Jordy Cajas**

Escuela Politécnica Nacional - Escuela de Formación de Tecnólogos

---

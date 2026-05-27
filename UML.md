# DIAGRAMA UML - Sistema de Gestión de Personal para Clínica Privada

## Estructura de clases y relaciones

```
┌─────────────────────────────────────────────────────────────────────────┐
│                          EMPLEADO (Clase Padre)                          │
├─────────────────────────────────────────────────────────────────────────┤
│ Atributos privados:                                                       │
│ - cedula: String                                                          │
│ - nombre: String                                                          │
│ - edad: int                                                               │
│ - telefono: String                                                        │
│ - correo: String                                                          │
├─────────────────────────────────────────────────────────────────────────┤
│ Métodos públicos:                                                         │
│ + Empleado(cedula, nombre, edad, telefono, correo)                       │
│ + getCedula(): String                                                     │
│ + getNombre(): String                                                     │
│ + getEdad(): int                                                          │
│ + getTelefono(): String                                                   │
│ + getCorreo(): String                                                     │
│ + setCedula(cedula): void                                                 │
│ + setNombre(nombre): void                                                 │
│ + setEdad(edad): void                                                     │
│ + setTelefono(telefono): void                                             │
│ + setCorreo(correo): void                                                 │
│ + mostrarInformacion(): void                                              │
│ + calcularPago(): double                                                  │
└─────────────────────────────────────────────────────────────────────────┘
                    ▲                           ▲
                    │ Herencia                  │ Herencia
                    │                           │
        ┌───────────┴─────────────┐    ┌───────┴──────────────┐
        │                         │    │                      │
        │                         │    │                      │
┌───────┴──────────────────────────┐ ┌┴────────────────────────────────┐
│      MEDICO (Subclase 1)         │ │   ADMINISTRATIVO (Subclase 2)  │
├──────────────────────────────────┤ ├───────────────────────────────┤
│ Atributos adicionales:           │ │ Atributos adicionales:        │
│ - especialidad: String           │ │ - departamento: String        │
│ - numeroPacientesAtendidos: int  │ │ - horasTrabajadas: int        │
│ - valorConsulta: double          │ │ - valorHora: double           │
├──────────────────────────────────┤ ├───────────────────────────────┤
│ Métodos públicos:                │ │ Métodos públicos:             │
│ + Medico(...)                    │ │ + Administrativo(...)         │
│ + getEspecialidad(): String      │ │ + getDepartamento(): String   │
│ + setEspecialidad(esp): void     │ │ + setDepartamento(dep): void  │
│ + getNumeroPacientes(): int      │ │ + getHorasTrabajadas(): int   │
│ + setNumeroPacientes(num): void  │ │ + setHorasTrabajadas(h): void │
│ + getValorConsulta(): double     │ │ + getValorHora(): double      │
│ + setValorConsulta(val): void    │ │ + setValorHora(val): void     │
│ + mostrarInformacion(): void ※   │ │ + mostrarInformacion(): void ※ │
│ + calcularPago(): double ※       │ │ + calcularPago(): double ※    │
│                                  │ │                               │
│ Cálculo obligatorio:             │ │ Cálculo obligatorio:          │
│ pago = numeroPacientes ×         │ │ pago = horasTrabajadas ×      │
│         valorConsulta            │ │         valorHora             │
└──────────────────────────────────┘ └───────────────────────────────┘

※ = Métodos sobrescritos (Polimorfismo)


┌──────────────────────────────────────┐
│    EMPLEADO SERVICIO                 │
├──────────────────────────────────────┤
│ Atributo privado:                    │
│ - empleados: ArrayList<Empleado>     │
├──────────────────────────────────────┤
│ Métodos públicos (CRUD):             │
│ + registrarMedico(...): void         │
│ + registrarAdministrativo(...): void │
│ + mostrarEmpleados(): void           │
│ + buscarPorCedula(cedula): Empleado  │
│ + reemplazarInformacion(...): void   │
│ + eliminarRegistro(cedula): void     │
│ + mostrarEstadisticas(): void        │
│ + getEmpleados(): ArrayList          │
└──────────────────────────────────────┘
            │ Usa (Composición)
            │
            └─────► ArrayList<Empleado>


┌──────────────────────────────────────┐
│      VALIDADOR                       │
├──────────────────────────────────────┤
│ Métodos públicos estáticos:          │
│ + validarOpcionMenu(opcion): boolean │
│ + validarEdad(edad): boolean         │
│ + validarCedulaDuplicada(...): bool  │
│ + validarNombre(nombre): boolean     │
│ + validarCorreo(correo): boolean     │
│ + validarTelefono(tel): boolean      │
│ + validarEspecialidad(esp): boolean  │
│ + validarDepartamento(dep): boolean  │
│ + validarPacientesAtendidos(p): bool │
│ + validarValorConsulta(val): boolean │
│ + validarHorasTrabajadas(h): boolean │
│ + validarValorHora(val): boolean     │
│ + obtenerEntero(valor): int          │
│ + obtenerDoble(valor): double        │
└──────────────────────────────────────┘


┌──────────────────────────────────────┐
│         MAIN                         │
├──────────────────────────────────────┤
│ Atributos privados estáticos:        │
│ - servicio: EmpleadoServicio         │
│ - scanner: Scanner                   │
├──────────────────────────────────────┤
│ Métodos públicos:                    │
│ + main(args): void                   │
│ - mostrarMenu(): void                │
│ - registrarMedico(): void            │
│ - registrarAdministrativo(): void    │
│ - buscarPorCedula(): void            │
│ - reemplazarInformacion(): void      │
│ - eliminarRegistro(): void           │
│ - calcularPagos(): void              │
└──────────────────────────────────────┘


## RELACIONES DE HERENCIA

       Empleado
      /        \
     /          \
  Medico    Administrativo


## CONCEPTOS POO IMPLEMENTADOS

1. **HERENCIA**: Medico y Administrativo heredan de Empleado
2. **ENCAPSULAMIENTO**: Todos los atributos son privados con getters y setters
3. **POLIMORFISMO**: Métodos mostrarInformacion() y calcularPago() sobrescritos
4. **ABSTRACCIÓN**: Empleado es la clase padre que define el contrato
5. **COMPOSICIÓN**: EmpleadoServicio usa ArrayList<Empleado>
```
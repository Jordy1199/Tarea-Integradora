package app;

import java.util.Scanner;
import modelo.Empleado;
import servicio.EmpleadoServicio;
import util.Validador;

public class Main {
    private static EmpleadoServicio servicio;
    private static Scanner scanner;

    public static void main(String[] args) {
        servicio = new EmpleadoServicio();
        scanner = new Scanner(System.in);
        int opcion = 0;
        boolean salir = false;

        while (!salir) {
            try {
                mostrarMenu();
                opcion = Validador.obtenerEntero(scanner.nextLine());

                if (!Validador.validarOpcionMenu(opcion)) {
                    System.out.println("✗ Error: opción inválida. Ingrese un número del 1 al 9.\n");
                    continue;
                }

                switch (opcion) {
                    case 1:
                        registrarMedico();
                        break;
                    case 2:
                        registrarAdministrativo();
                        break;
                    case 3:
                        servicio.mostrarEmpleados();
                        break;
                    case 4:
                        buscarPorCedula();
                        break;
                    case 5:
                        reemplazarInformacion();
                        break;
                    case 6:
                        eliminarRegistro();
                        break;
                    case 7:
                        calcularPagos();
                        break;
                    case 8:
                        servicio.mostrarEstadisticas();
                        break;
                    case 9:
                        salir = true;
                        System.out.println("✓ Hasta luego.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("✗ Error: opción inválida. Ingrese un número del 1 al 9.\n");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== CLÍNICA SALUD TOTAL =====");
        System.out.println("1. Registrar médico");
        System.out.println("2. Registrar administrativo");
        System.out.println("3. Mostrar empleados");
        System.out.println("4. Buscar por cédula");
        System.out.println("5. Reemplazar información");
        System.out.println("6. Eliminar registro");
        System.out.println("7. Calcular pagos");
        System.out.println("8. Mostrar estadísticas");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarMedico() {
        try {
            System.out.println("\n========== REGISTRAR MÉDICO ==========");

            String cedula;
            do {
                System.out.print("Ingrese cédula: ");
                cedula = scanner.nextLine();
                if (!Validador.validarCedulaDuplicada(cedula, servicio.getEmpleados())) {
                    System.out.println("✗ Error: Cédula duplicada.\n");
                }
            } while (!Validador.validarCedulaDuplicada(cedula, servicio.getEmpleados()));

            String nombre;
            do {
                System.out.print("Ingrese nombre: ");
                nombre = scanner.nextLine();
                if (!Validador.validarNombre(nombre)) {
                    System.out.println("✗ Error: El nombre no puede estar vacío.\n");
                }
            } while (!Validador.validarNombre(nombre));

            int edad = 0;
            boolean edadValida = false;
            while (!edadValida) {
                try {
                    System.out.print("Ingrese edad: ");
                    edad = Validador.obtenerEntero(scanner.nextLine());
                    if (!Validador.validarEdad(edad)) {
                        System.out.println("✗ Error: La edad debe ser entre 1 y 149 años.\n");
                    } else {
                        edadValida = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("✗ Error: Ingrese un número válido para la edad.\n");
                }
            }

            String telefono;
            do {
                System.out.print("Ingrese teléfono (solo números): ");
                telefono = scanner.nextLine();
                if (!Validador.validarTelefono(telefono)) {
                    System.out.println("✗ Error: El teléfono debe contener solo números.\n");
                }
            } while (!Validador.validarTelefono(telefono));

            String correo;
            do {
                System.out.print("Ingrese correo (debe contener @ y .): ");
                correo = scanner.nextLine();
                if (!Validador.validarCorreo(correo)) {
                    System.out.println("✗ Error: El correo debe contener @ y .\n");
                }
            } while (!Validador.validarCorreo(correo));

            String especialidad;
            do {
                System.out.print("Ingrese especialidad: ");
                especialidad = scanner.nextLine();
                if (!Validador.validarEspecialidad(especialidad)) {
                    System.out.println("✗ Error: La especialidad no puede estar vacía.\n");
                }
            } while (!Validador.validarEspecialidad(especialidad));

            int pacientes = 0;
            boolean pacientesValido = false;
            while (!pacientesValido) {
                try {
                    System.out.print("Ingrese número de pacientes atendidos: ");
                    pacientes = Validador.obtenerEntero(scanner.nextLine());
                    if (!Validador.validarPacientesAtendidos(pacientes)) {
                        System.out.println("✗ Error: El número de pacientes debe ser mayor a 0.\n");
                    } else {
                        pacientesValido = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("✗ Error: Ingrese un número válido.\n");
                }
            }

            double valorConsulta = 0;
            boolean valorConsultaValido = false;
            while (!valorConsultaValido) {
                try {
                    System.out.print("Ingrese valor de consulta: ");
                    valorConsulta = Validador.obtenerDoble(scanner.nextLine());
                    if (!Validador.validarValorConsulta(valorConsulta)) {
                        System.out.println("✗ Error: El valor de consulta debe ser mayor a 0.\n");
                    } else {
                        valorConsultaValido = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("✗ Error: Ingrese un número válido.\n");
                }
            }

            servicio.registrarMedico(cedula, nombre, edad, telefono, correo, especialidad, pacientes, valorConsulta);
            System.out.println();

        } catch (Exception e) {
            System.out.println("✗ Error al registrar médico: " + e.getMessage() + "\n");
        }
    }

    private static void registrarAdministrativo() {
        try {
            System.out.println("\n========== REGISTRAR ADMINISTRATIVO ==========");

            String cedula;
            do {
                System.out.print("Ingrese cédula: ");
                cedula = scanner.nextLine();
                if (!Validador.validarCedulaDuplicada(cedula, servicio.getEmpleados())) {
                    System.out.println("✗ Error: Cédula duplicada.\n");
                }
            } while (!Validador.validarCedulaDuplicada(cedula, servicio.getEmpleados()));

            String nombre;
            do {
                System.out.print("Ingrese nombre: ");
                nombre = scanner.nextLine();
                if (!Validador.validarNombre(nombre)) {
                    System.out.println("✗ Error: El nombre no puede estar vacío.\n");
                }
            } while (!Validador.validarNombre(nombre));

            int edad = 0;
            boolean edadValida = false;
            while (!edadValida) {
                try {
                    System.out.print("Ingrese edad: ");
                    edad = Validador.obtenerEntero(scanner.nextLine());
                    if (!Validador.validarEdad(edad)) {
                        System.out.println("✗ Error: La edad debe ser entre 1 y 149 años.\n");
                    } else {
                        edadValida = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("✗ Error: Ingrese un número válido para la edad.\n");
                }
            }

            String telefono;
            do {
                System.out.print("Ingrese teléfono (solo números): ");
                telefono = scanner.nextLine();
                if (!Validador.validarTelefono(telefono)) {
                    System.out.println("✗ Error: El teléfono debe contener solo números.\n");
                }
            } while (!Validador.validarTelefono(telefono));

            String correo;
            do {
                System.out.print("Ingrese correo (debe contener @ y .): ");
                correo = scanner.nextLine();
                if (!Validador.validarCorreo(correo)) {
                    System.out.println("✗ Error: El correo debe contener @ y .\n");
                }
            } while (!Validador.validarCorreo(correo));

            String departamento;
            do {
                System.out.print("Ingrese departamento: ");
                departamento = scanner.nextLine();
                if (!Validador.validarDepartamento(departamento)) {
                    System.out.println("✗ Error: El departamento no puede estar vacío.\n");
                }
            } while (!Validador.validarDepartamento(departamento));

            int horas = 0;
            boolean horasValidas = false;
            while (!horasValidas) {
                try {
                    System.out.print("Ingrese horas trabajadas: ");
                    horas = Validador.obtenerEntero(scanner.nextLine());
                    if (!Validador.validarHorasTrabajadas(horas)) {
                        System.out.println("✗ Error: Las horas trabajadas deben ser mayor a 0.\n");
                    } else {
                        horasValidas = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("✗ Error: Ingrese un número válido.\n");
                }
            }

            double valorHora = 0;
            boolean valorHoraValido = false;
            while (!valorHoraValido) {
                try {
                    System.out.print("Ingrese valor por hora: ");
                    valorHora = Validador.obtenerDoble(scanner.nextLine());
                    if (!Validador.validarValorHora(valorHora)) {
                        System.out.println("✗ Error: El valor por hora debe ser mayor a 0.\n");
                    } else {
                        valorHoraValido = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("✗ Error: Ingrese un número válido.\n");
                }
            }

            servicio.registrarAdministrativo(cedula, nombre, edad, telefono, correo, departamento, horas, valorHora);
            System.out.println();

        } catch (Exception e) {
            System.out.println("✗ Error al registrar administrativo: " + e.getMessage() + "\n");
        }
    }

    private static void buscarPorCedula() {
        try {
            System.out.print("\nIngrese cédula a buscar: ");
            String cedula = scanner.nextLine();
            Empleado empleado = servicio.buscarPorCedula(cedula);

            if (empleado != null) {
                System.out.println("\n========== INFORMACIÓN ENCONTRADA ==========");
                empleado.mostrarInformacion();
                System.out.println("Pago: $" + empleado.calcularPago());
                System.out.println("==========================================\n");
            } else {
                System.out.println("✗ Registro no encontrado.\n");
            }
        } catch (Exception e) {
            System.out.println("✗ Error al buscar: " + e.getMessage() + "\n");
        }
    }

    private static void reemplazarInformacion() {
        try {
            System.out.print("\nIngrese cédula del empleado a actualizar: ");
            String cedula = scanner.nextLine();
            Empleado empleado = servicio.buscarPorCedula(cedula);

            if (empleado != null) {
                System.out.println("\n========== REEMPLAZAR INFORMACIÓN ==========");

                System.out.print("Ingrese nuevo nombre: ");
                String nombre = scanner.nextLine();

                int edad = 0;
                boolean edadValida = false;
                while (!edadValida) {
                    try {
                        System.out.print("Ingrese nueva edad: ");
                        edad = Validador.obtenerEntero(scanner.nextLine());
                        if (!Validador.validarEdad(edad)) {
                            System.out.println("✗ Error: La edad debe ser entre 1 y 149 años.\n");
                        } else {
                            edadValida = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("✗ Error: Ingrese un número válido.\n");
                    }
                }

                String telefono;
                do {
                    System.out.print("Ingrese nuevo teléfono (solo números): ");
                    telefono = scanner.nextLine();
                    if (!Validador.validarTelefono(telefono)) {
                        System.out.println("✗ Error: El teléfono debe contener solo números.\n");
                    }
                } while (!Validador.validarTelefono(telefono));

                String correo;
                do {
                    System.out.print("Ingrese nuevo correo (debe contener @ y .): ");
                    correo = scanner.nextLine();
                    if (!Validador.validarCorreo(correo)) {
                        System.out.println("✗ Error: El correo debe contener @ y .\n");
                    }
                } while (!Validador.validarCorreo(correo));

                servicio.reemplazarInformacion(cedula, nombre, edad, telefono, correo);
                System.out.println();
            } else {
                System.out.println("✗ Registro no encontrado.\n");
            }
        } catch (Exception e) {
            System.out.println("✗ Error al reemplazar información: " + e.getMessage() + "\n");
        }
    }

    private static void eliminarRegistro() {
        try {
            System.out.print("\nIngrese cédula del empleado a eliminar: ");
            String cedula = scanner.nextLine();
            servicio.eliminarRegistro(cedula);
            System.out.println();
        } catch (Exception e) {
            System.out.println("✗ Error al eliminar: " + e.getMessage() + "\n");
        }
    }

    private static void calcularPagos() {
        try {
            if (servicio.getEmpleados().isEmpty()) {
                System.out.println("\nNo hay empleados para calcular pagos.\n");
                return;
            }

            System.out.println("\n========== CÁLCULO DE PAGOS ==========");
            for (Empleado empleado : servicio.getEmpleados()) {
                System.out.println(empleado.getNombre() + " - $" + empleado.calcularPago());
            }
            System.out.println("=====================================\n");
        } catch (Exception e) {
            System.out.println("✗ Error al calcular pagos: " + e.getMessage() + "\n");
        }
    }
}
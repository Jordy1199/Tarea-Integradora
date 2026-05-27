package util;

import java.util.ArrayList;
import modelo.Empleado;

public class Validador {

    public static boolean validarOpcionMenu(int opcion) {
        return opcion >= 1 && opcion <= 9;
    }

    public static boolean validarEdad(int edad) {
        return edad > 0 && edad < 150;
    }

    public static boolean validarCedulaDuplicada(String cedula, ArrayList<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            if (empleado.getCedula().equals(cedula)) {
                return false; // Cédula duplicada
            }
        }
        return true; // Cédula válida
    }

    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean validarCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            return false;
        }
        return correo.contains("@") && correo.contains(".");
    }

    public static boolean validarTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            return false;
        }
        return telefono.matches("\\d+");
    }

    public static boolean validarEspecialidad(String especialidad) {
        return especialidad != null && !especialidad.trim().isEmpty();
    }

    public static boolean validarDepartamento(String departamento) {
        return departamento != null && !departamento.trim().isEmpty();
    }

    public static boolean validarPacientesAtendidos(int pacientes) {
        return pacientes > 0;
    }

    public static boolean validarValorConsulta(double valor) {
        return valor > 0;
    }

    public static boolean validarHorasTrabajadas(int horas) {
        return horas > 0;
    }

    public static boolean validarValorHora(double valor) {
        return valor > 0;
    }

    public static int obtenerEntero(String valor) throws NumberFormatException {
        return Integer.parseInt(valor);
    }

    public static double obtenerDoble(String valor) throws NumberFormatException {
        return Double.parseDouble(valor);
    }
}
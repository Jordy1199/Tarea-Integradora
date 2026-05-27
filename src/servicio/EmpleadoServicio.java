package servicio;

import java.util.ArrayList;
import modelo.Empleado;
import modelo.Medico;
import modelo.Administrativo;

public class EmpleadoServicio {
    private ArrayList<Empleado> empleados;

    public EmpleadoServicio() {
        this.empleados = new ArrayList<>();
    }

    public void registrarMedico(String cedula, String nombre, int edad, String telefono, String correo,
                                String especialidad, int numeroPacientesAtendidos, double valorConsulta) {
        Medico medico = new Medico(cedula, nombre, edad, telefono, correo, especialidad,
                numeroPacientesAtendidos, valorConsulta);
        empleados.add(medico);
        System.out.println("✓ Médico registrado exitosamente.");
    }

    public void registrarAdministrativo(String cedula, String nombre, int edad, String telefono, String correo,
                                        String departamento, int horasTrabajadas, double valorHora) {
        Administrativo administrativo = new Administrativo(cedula, nombre, edad, telefono, correo,
                departamento, horasTrabajadas, valorHora);
        empleados.add(administrativo);
        System.out.println("✓ Administrativo registrado exitosamente.");
    }

    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        System.out.println("\n========== LISTADO DE EMPLEADOS ==========");
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println("\n--- Empleado " + (i + 1) + " ---");
            empleados.get(i).mostrarInformacion();
            System.out.println("Pago: $" + empleados.get(i).calcularPago());
        }
        System.out.println("==========================================\n");
    }

    public Empleado buscarPorCedula(String cedula) {
        for (Empleado empleado : empleados) {
            if (empleado.getCedula().equals(cedula)) {
                return empleado;
            }
        }
        return null;
    }

    public void reemplazarInformacion(String cedula, String nombre, int edad, String telefono, String correo) {
        Empleado empleado = buscarPorCedula(cedula);
        if (empleado != null) {
            empleado.setNombre(nombre);
            empleado.setEdad(edad);
            empleado.setTelefono(telefono);
            empleado.setCorreo(correo);
            System.out.println("✓ Información actualizada exitosamente.");
        } else {
            System.out.println("✗ Registro no encontrado.");
        }
    }

    public void eliminarRegistro(String cedula) {
        Empleado empleado = buscarPorCedula(cedula);
        if (empleado != null) {
            empleados.remove(empleado);
            System.out.println("✓ Registro eliminado exitosamente.");
        } else {
            System.out.println("✗ Registro no encontrado.");
        }
    }

    public void mostrarEstadisticas() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados para mostrar estadísticas.");
            return;
        }

        int totalMedicos = 0;
        int totalAdministrativos = 0;
        double pagoTotalMedicos = 0;
        double pagoTotalAdministrativos = 0;
        Empleado empleadoMayorIngreso = null;
        double mayorIngreso = 0;

        for (Empleado empleado : empleados) {
            double pago = empleado.calcularPago();

            if (empleado instanceof Medico) {
                totalMedicos++;
                pagoTotalMedicos += pago;
            } else if (empleado instanceof Administrativo) {
                totalAdministrativos++;
                pagoTotalAdministrativos += pago;
            }

            if (pago > mayorIngreso) {
                mayorIngreso = pago;
                empleadoMayorIngreso = empleado;
            }
        }

        System.out.println("\n========== ESTADÍSTICAS ==========");
        System.out.println("Total médicos: " + totalMedicos);
        System.out.println("Total administrativos: " + totalAdministrativos);
        System.out.println("Total empleados: " + empleados.size());
        System.out.println("Pago total médicos: $" + pagoTotalMedicos);
        System.out.println("Pago total administrativos: $" + pagoTotalAdministrativos);
        if (empleadoMayorIngreso != null) {
            System.out.println("Empleado con mayor ingreso: " + empleadoMayorIngreso.getNombre() + " - $" + mayorIngreso);
        }
        System.out.println("==================================\n");
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
}
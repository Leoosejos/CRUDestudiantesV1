package core.modelo;

import core.entrada.GestorEntrada;
import core.salida.GestorSalida;
import java.util.ArrayList;

public class GestorEstudiantes {
    private ArrayList<Estudiante> estudiantes;
    private GestorEntrada entrada;
    private GestorSalida salida;

    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
        entrada = new GestorEntrada();
        salida = new GestorSalida();
    }

    private boolean existeId(int id) {
        return estudiantes.stream().anyMatch(e -> e.getId() == id);
    }

    private Estudiante buscarEstudiantePorId(int id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    public void agregarEstudiante() {
        System.out.println("\n=== ALTA DE NUEVO ESTUDIANTE ===");

        int id;
        do {
            id = entrada.leerEntero("Introduce ID (número positivo): ");
            if (id <= 0) {
                System.out.println("El ID debe ser un número positivo.");
                continue;
            }
            if (existeId(id)) {
                System.out.println("Este ID ya existe. Por favor, introduce otro.");
            }
        } while (id <= 0 || existeId(id));

        String nombreCompleto = entrada.leerTexto("Introduce nombre completo: ");

        int edad;
        do {
            edad = entrada.leerEntero("Introduce edad (entre 16 y 120 años): ");
            if (edad < 16 || edad > 120) {
                System.out.println("La edad debe estar entre 16 y 120 años.");
            }
        } while (edad < 16 || edad > 120);

        String fechaNacimiento = entrada.leerTexto("Introduce fecha de nacimiento (DD/MM/AAAA): ");

        Estudiante estudiante = new Estudiante(id, nombreCompleto, edad, fechaNacimiento);

        System.out.println("\nPrimera Asignatura:");
        String nombreAsignatura1 = entrada.leerTexto("Nombre de la asignatura: ");
        double notaAsignatura1;
        do {
            notaAsignatura1 = entrada.leerDecimal("Nota (0-10): ");
            if (notaAsignatura1 < 0 || notaAsignatura1 > 10) {
                System.out.println("La nota debe estar entre 0 y 10.");
            }
        } while (notaAsignatura1 < 0 || notaAsignatura1 > 10);

        Asignatura asignatura1 = new Asignatura(nombreAsignatura1, notaAsignatura1);

        System.out.println(" Segunda Asignatura:");
        String nombreAsignatura2 = entrada.leerTexto("Nombre de la asignatura: ");
        double notaAsignatura2;
        do {
            notaAsignatura2 = entrada.leerDecimal("Nota (0-10): ");
            if (notaAsignatura2 < 0 || notaAsignatura2 > 10) {
                System.out.println("La nota debe estar entre 0 y 10.");
            }
        } while (notaAsignatura2 < 0 || notaAsignatura2 > 10);

        Asignatura asignatura2 = new Asignatura(nombreAsignatura2, notaAsignatura2);

        estudiante.setAsignaturas(asignatura1, asignatura2);
        estudiantes.add(estudiante);

        System.out.println(" Estudiante agregado correctamente.");
    }

    public void eliminarEstudiante() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados en el sistema.");
            return;
        }

        salida.mostrarListaEstudiantes(estudiantes);
        int id = entrada.leerEntero("Introduce el ID del estudiante a eliminar: ");

        Estudiante estudiante = buscarEstudiantePorId(id);
        if (estudiante != null) {
            estudiantes.remove(estudiante);
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún estudiante con el ID: " + id);
        }
    }

    public void modificarNota() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados en el sistema.");
            return;
        }

        salida.mostrarListaEstudiantes(estudiantes);
        int id = entrada.leerEntero("Introduce el ID del estudiante a modificar: ");

        Estudiante estudiante = buscarEstudiantePorId(id);
        if (estudiante != null) {
            System.out.println(" Asignaturas del estudiante " + estudiante.getNombreCompleto() + ":");
            System.out.println("1. " + estudiante.getAsignaturas()[0].getNombre() +
                    " (Nota actual: " + estudiante.getAsignaturas()[0].getNota() + ")");
            System.out.println("2. " + estudiante.getAsignaturas()[1].getNombre() +
                    " (Nota actual: " + estudiante.getAsignaturas()[1].getNota() + ")");

            int numAsignatura = entrada.leerEntero("Introduce el número de asignatura a modificar (1 o 2): ");

            if (numAsignatura == 1 || numAsignatura == 2) {
                double nuevaNota;
                do {
                    nuevaNota = entrada.leerDecimal("Introduce la nueva nota (0-10): ");
                    if (nuevaNota < 0 || nuevaNota > 10) {
                        System.out.println("La nota debe estar entre 0 y 10.");
                    }
                } while (nuevaNota < 0 || nuevaNota > 10);

                estudiante.getAsignaturas()[numAsignatura - 1].setNota(nuevaNota);
                System.out.println("Nota modificada correctamente.");
            } else {
                System.out.println("Número de asignatura no válido.");
            }
        } else {
            System.out.println("No se encontró ningún estudiante con el ID: " + id);
        }
    }

    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println(" No hay estudiantes registrados en el sistema.");
            return;
        }

        System.out.println("=== LISTADO DE ESTUDIANTES ===");
        salida.mostrarListaEstudiantes(estudiantes);
        mostrarEstadisticas();
    }

    private void mostrarEstadisticas() {
        if (!estudiantes.isEmpty()) {
            System.out.println("Estadísticas:");
            System.out.println("Total de estudiantes: " + estudiantes.size());

            double promedioTotal = 0;
            int totalAsignaturas = 0;

            for (Estudiante estudiante : estudiantes) {
                for (Asignatura asignatura : estudiante.getAsignaturas()) {
                    promedioTotal += asignatura.getNota();
                    totalAsignaturas++;
                }
            }

            if (totalAsignaturas > 0) {
                System.out.printf("Promedio general de notas: %.2f\n", promedioTotal / totalAsignaturas);
            }
        }
    }
}
package altas;

import core.entrada.GestorEntrada;
import core.salida.GestorSalida;
import core.modelo.Asignatura;
import core.modelo.Estudiante;
import java.util.ArrayList;

public class Altas {
    private GestorEntrada entrada;
    private GestorSalida salida;
    private ArrayList<Estudiante> estudiantes;

    public Altas(GestorEntrada entrada, GestorSalida salida, ArrayList<Estudiante> estudiantes) {
        this.entrada = entrada;
        this.salida = salida;
        this.estudiantes = estudiantes;
    }

    private boolean existeId(int id) {
        return estudiantes.stream().anyMatch(e -> e.getId() == id);
    }

    public void agregarEstudiante() {
        salida.mostrarMensajeAlta();
        int id;
        do {
            id = entrada.leerEntero("Introduce ID (número positivo): ");
            if (id <= 0) {
                salida.mostrarMensajeIDpositivo();
                continue;
            }
            if (existeId(id)) {
                salida.mostrarMensajeIDExistente();
            }
        } while (id <= 0 || existeId(id));

        String nombreCompleto = entrada.leerTexto("Introduce nombre completo: ");

        int edad;
        do {
            edad = entrada.leerEntero("Introduce edad (entre 16 y 120 años): ");
            if (edad < 16 || edad > 120) {
                salida.mostrarMensaleIngresarEdad();
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
                salida.mostrarMensajeIngresarNota();
            }
        } while (notaAsignatura1 < 0 || notaAsignatura1 > 10);

        Asignatura asignatura1 = new Asignatura(nombreAsignatura1, notaAsignatura1);

        System.out.println(" Segunda Asignatura:");
        String nombreAsignatura2 = entrada.leerTexto("Nombre de la asignatura: ");
        double notaAsignatura2;
        do {
            notaAsignatura2 = entrada.leerDecimal("Nota (0-10): ");
            if (notaAsignatura2 < 0 || notaAsignatura2 > 10) {
                salida.mostrarMensajeIngresarNota();
            }
        } while (notaAsignatura2 < 0 || notaAsignatura2 > 10);

        Asignatura asignatura2 = new Asignatura(nombreAsignatura2, notaAsignatura2);

        estudiante.setAsignaturas(asignatura1, asignatura2);
        estudiantes.add(estudiante);

        salida.mostrarMensajeAltaExitosa();
    }
}
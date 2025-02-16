package modificacion;

import core.entrada.GestorEntrada;
import core.salida.GestorSalida;
import core.modelo.Estudiante;
import core.modelo.Asignatura;
import java.util.ArrayList;

public class Modificacion {
    private GestorEntrada entrada;
    private GestorSalida salida;
    private ArrayList<Estudiante> estudiantes;

    public Modificacion(GestorEntrada entrada, GestorSalida salida, ArrayList<Estudiante> estudiantes) {
        this.entrada = entrada;
        this.salida = salida;
        this.estudiantes = estudiantes;
    }

    private Estudiante buscarEstudiantePorId(int id) {
        return estudiantes.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void modificarNota() {
        if (estudiantes.isEmpty()) {
            salida.mostrarMensajeSinEstudiantes();
            return;
        }

        salida.mostrarListaEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            salida.mostrarEstudiante("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombreCompleto());
        }

        int id = entrada.leerEntero("Introduce el ID del estudiante a modificar: ");

        Estudiante estudiante = buscarEstudiantePorId(id);
        if (estudiante != null) {
            int numAsignatura = entrada.leerEntero("Introduce el número de asignatura a modificar (1 o 2): ");
            if (numAsignatura == 1 || numAsignatura == 2) {
                double nuevaNota = entrada.leerDecimal("Introduce la nueva nota (0-10): ");
                estudiante.getAsignaturas()[numAsignatura - 1].setNota(nuevaNota);
                salida.mostrarMensajeModificacionExitosa();
            } else {
                salida.mostrarMensajeAsignaturaNoValida();
            }
        } else {
            salida.mostrarMensajeNoSeEncontroId();
        }
    }
}

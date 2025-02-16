package bajas;

import core.entrada.GestorEntrada;
import core.salida.GestorSalida;
import core.modelo.Estudiante;
import java.util.ArrayList;

public class Bajas {
    private GestorEntrada entrada;
    private GestorSalida salida;
    private ArrayList<Estudiante> estudiantes;

    public Bajas(GestorEntrada entrada, GestorSalida salida, ArrayList<Estudiante> estudiantes) {
        this.entrada = entrada;
        this.salida = salida;
        this.estudiantes = estudiantes;
    }

    private Estudiante buscarEstudiantePorId(int id) {
        return estudiantes.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void eliminarEstudiante() {
        if (estudiantes.isEmpty()) {
            salida.mostrarMensajeSinEstudiantes();
            return;
        }

        salida.mostrarListaEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            salida.mostrarEstudiante("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombreCompleto());
        }

        int id = entrada.leerEntero("Introduce el ID del estudiante a eliminar: ");

        Estudiante estudiante = buscarEstudiantePorId(id);
        if (estudiante != null) {
            estudiantes.remove(estudiante);
            salida.mostrarMensajeBajaExitosa();
        } else {
            salida.mostrarMensajeNoSeEncontroId(id);
        }
    }
}

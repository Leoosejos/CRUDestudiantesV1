package lista;

import core.salida.GestorSalida;
import core.modelo.Estudiante;
import core.modelo.Asignatura;
import java.util.ArrayList;

public class Listado {
    private GestorSalida salida;
    private ArrayList<Estudiante> estudiantes;

    public Listado(GestorSalida salida, ArrayList<Estudiante> estudiantes) {
        this.salida = salida;
        this.estudiantes = estudiantes;
    }

    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            salida.mostrarMensajeSinEstudiantes();
            return;
        }

        salida.mostrarListaEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            salida.mostrarEstudianteDetalles(estudiante);
        }
    }
}

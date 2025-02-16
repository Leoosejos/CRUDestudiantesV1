package core.modelo;

import core.entrada.GestorEntrada;
import core.salida.GestorSalida;
import altas.Altas;
import java.util.ArrayList;

public class GestorEstudiantes {
    private ArrayList<Estudiante> estudiantes;
    private GestorEntrada entrada;
    private GestorSalida salida;
    private Altas altas;

    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
        entrada = new GestorEntrada();
        salida = new GestorSalida();
        altas = new Altas(entrada, salida, estudiantes);
    }

    public void agregarEstudiante() {
        altas.agregarEstudiante();
    }
}
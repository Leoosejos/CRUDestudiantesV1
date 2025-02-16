package core.modelo;

import core.entrada.GestorEntrada;
import core.salida.GestorSalida;
import altas.Altas;
import bajas.Bajas;
import lista.Listado;
import java.util.ArrayList;

public class GestorEstudiantes {
    private ArrayList<Estudiante> estudiantes;
    private GestorEntrada entrada;
    private GestorSalida salida;
    private Altas altas;
    private Bajas bajas;
    private Listado listado;

    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
        entrada = new GestorEntrada();
        salida = new GestorSalida();
        altas = new Altas(entrada, salida, estudiantes);
        bajas = new Bajas(entrada, salida, estudiantes);
        listado = new Listado(salida, estudiantes);
    }

    public void agregarEstudiante() {
        altas.agregarEstudiante();
    }

    public void eliminarEstudiante() {
        bajas.eliminarEstudiante();
    }

    public void listarEstudiantes() {
        listado.listarEstudiantes();
    }
}
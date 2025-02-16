package core.salida;

public class GestorSalida {

    public GestorSalida() {
    }

    public void mostrarMenu() {
        System.out.println("1. Agregar estudiante");
        System.out.println("2. Eliminar estudiante");
        System.out.println("5. Salir");
    }

    public void mostrarMensajeAlta() {
        System.out.println("Agregar un nuevo estudiante:");
    }

    public void mostrarMensajeIDpositivo() {
        System.out.println("El ID debe ser un número positivo.");
    }

    public void mostrarMensajeIDExistente() {
        System.out.println("Este ID ya existe. Introduce otro ID.");
    }

    public void mostrarMensaleIngresarEdad() {
        System.out.println("La edad debe estar entre 16 y 120 años.");
    }

    public void mostrarMensajeIngresarNota() {
        System.out.println("La nota debe estar entre 0 y 10.");
    }

    public void mostrarMensajeAltaExitosa() {
        System.out.println("Estudiante agregado exitosamente.");
    }

    public void mostrarMensajeSinEstudiantes() {
        System.out.println("No hay estudiantes en el sistema.");
    }

    public void mostrarMensajeBajaExitosa() {
        System.out.println("Estudiante eliminado exitosamente.");
    }

    public void mostrarMensajeNoSeEncontroId(int id) {
        System.out.println("No se encontró el estudiante con ID: " + id);
    }

    public void mostrarListaEstudiantes() {
        System.out.println("Lista de Estudiantes:");
    }

    public void mostrarEstudiante(String estudianteInfo) {
        System.out.println(estudianteInfo);
    }
}

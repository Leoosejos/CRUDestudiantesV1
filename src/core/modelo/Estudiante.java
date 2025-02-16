package core.modelo;

public class Estudiante {
    private int id;
    private String nombreCompleto;
    private int edad;
    private String fechaNacimiento;
    private Asignatura[] asignaturas;

    public Estudiante(int id, String nombreCompleto, int edad, String fechaNacimiento) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.asignaturas = new Asignatura[2];
    }

    public int getId() { return id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public int getEdad() { return edad; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public Asignatura[] getAsignaturas() { return asignaturas; }

    public void setAsignaturas(Asignatura asignatura1, Asignatura asignatura2) {
        asignaturas[0] = asignatura1;
        asignaturas[1] = asignatura2;
    }
}



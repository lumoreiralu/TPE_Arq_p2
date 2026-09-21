package universidad.entity;


import javax.persistence.*;

@Entity
public class EstudianteCarrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_carrera", nullable = false)
    private Carrera carrera;
    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;
    @Column(nullable = false)
    private int inscripcion;
    @Column(nullable = false)
    private int graduacion;
    @Column(nullable = false)
    private int antiguedad;

    public EstudianteCarrera() {
    }

    public EstudianteCarrera(Carrera carrera, Estudiante estudiante, int inscripcion, int graduacion, int antiguedad) {
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.inscripcion = inscripcion;
        this.graduacion =graduacion;
        this.antiguedad = antiguedad ;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public int isGraduacion() {
        return this.graduacion;
    }

    public int getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(int inscripcion) {
        this.inscripcion = inscripcion;
    }

    public void setGraduacion(int graduacion) {
        this.graduacion = graduacion;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EstudianteCarrera{" +
                "id=" + id +
                ", carrera=" + carrera.getNombre() +
                ", estudiante=" + estudiante.getNombre() +
                ", graduacion=" + graduacion +
                ", antiguedad=" + antiguedad +
                '}';
    }
}

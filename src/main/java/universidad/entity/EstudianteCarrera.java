package universidad.entity;


import javax.persistence.*;

@Entity
public class EstudianteCarrera {

    @EmbeddedId
    private EstudianteCarreraPK id;
    @ManyToOne
    @MapsId("idCarrera")
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;
    @ManyToOne @MapsId("idEstudiante")
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
    @Column(nullable = false)
    private int inscripcion;
    @Column
    private Integer graduacion;

    public EstudianteCarrera() {
    }

    public EstudianteCarrera(Carrera carrera, Estudiante estudiante, int inscripcion, Integer graduacion) {
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.inscripcion = inscripcion;
        this.graduacion =graduacion;
        this.id=new EstudianteCarreraPK(estudiante.getDni(), carrera.getId()) ;
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

    public Integer getGraduacion() {
        return this.graduacion;
    }

    public int getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(int inscripcion) {
        this.inscripcion = inscripcion;
    }

    public void setGraduacion(Integer graduacion) {
        this.graduacion = graduacion;
    }


    public EstudianteCarreraPK getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EstudianteCarrera{" +
                "id=" + id +
                ", carrera=" + carrera.getNombre() +
                ", estudiante=" + estudiante.getNombre() +
                ", graduacion=" + graduacion +
                '}';
    }
}

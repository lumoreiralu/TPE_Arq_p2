package universidad.dto;

public class ReporteCarreraDTO {
    private String nombre_carrera;
    private String nombre_alumno;
    private String apellido_alumno;
    private int inscripcion;
    private int graduacion;

    public ReporteCarreraDTO(String nombre_carrera, String nombre_alumno, String apellido_alumno, int inscripcion, int graduacion){
        this.nombre_carrera=nombre_carrera;
        this.nombre_alumno=nombre_alumno;
        this.apellido_alumno=apellido_alumno;
        this.inscripcion=inscripcion;
        this.graduacion=graduacion;
    }
}

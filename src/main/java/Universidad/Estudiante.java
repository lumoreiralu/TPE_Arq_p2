package Universidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudiante {
    @Id
    private Integer dni;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private String genero;
    @Column
    private String ciudadResidencia;
    @Column
    private int num_libreta_uni;
    @ManyToMany
    private List<Carrera> carreras;

    public Estudiante() {
    }

    public Estudiante(Integer dni, String nombre, int edad, String apellido, String genero, String ciudadResidencia, int num_libreta_uni) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.apellido = apellido;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.num_libreta_uni = num_libreta_uni;
        this.carreras = new ArrayList<>();
    }

    public Integer getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public int getNum_libreta_uni() {
        return num_libreta_uni;
    }

    public void setNum_libreta_uni(int num_libreta_uni) {
        this.num_libreta_uni = num_libreta_uni;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
}

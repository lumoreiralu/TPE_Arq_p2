package universidad.repositories;

import universidad.entity.Carrera;
import universidad.entity.Estudiante;
import universidad.entity.EstudianteCarrera;

import java.util.List;

public interface EstudianteCarreraRepository {
    EstudianteCarrera matricular(Estudiante estudiante, Carrera carrera, int inscripcion, int graduacion, int antiguedad);
    EstudianteCarrera save(EstudianteCarrera estudianteCarrera);
    EstudianteCarrera findById(Integer id);
    List<EstudianteCarrera> findAll();
}

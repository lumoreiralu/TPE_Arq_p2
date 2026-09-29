package universidad.repositories;

import universidad.entity.Carrera;
import universidad.entity.Estudiante;
import universidad.entity.EstudianteCarrera;

import java.util.List;

public interface EstudianteCarreraRepository {
    EstudianteCarrera matricular(Estudiante estudiante, Carrera carrera, int inscripcion, Integer graduacion);
    EstudianteCarrera save(EstudianteCarrera estudianteCarrera);
    EstudianteCarrera findByIds(Integer dni,Integer idCarrera);
    List<EstudianteCarrera> findAll();
}

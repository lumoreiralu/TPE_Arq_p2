package universidad.repositories;

import universidad.dto.CarreraInscriptosDTO;
import universidad.dto.ReporteCarreraDTO;
import universidad.entity.Carrera;

import java.util.List;

public interface CarreraRepository {
    Carrera save(Carrera carrera);
    Carrera findById(Integer id);
    List<Carrera> findAll();

    //para el punto 2
    List<CarreraInscriptosDTO> getCarrerasConInscriptosOrdenadas();

    //para el punto 3
    List<ReporteCarreraDTO> getReporteCarreras();

}

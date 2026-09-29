package universidad.repositories;
import universidad.dto.CarreraInscriptosDTO;
import universidad.dto.ReporteCarreraDTO;
import universidad.entity.Carrera;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CarreraRepositoryImpl implements CarreraRepository {
    private final EntityManager em;
    public CarreraRepositoryImpl(EntityManager em){
        this.em = em;
    }




    @Override
    public Carrera save(Carrera carrera) {
        if(carrera.getId() == null){
            em.persist(carrera);
        }else{
            carrera = em.merge(carrera);
        }
        return carrera;
    }

    @Override
    public Carrera findById(Integer id) {
        return em.find(Carrera.class, id);
    }

    @Override
    public List<Carrera> findAll() {
        TypedQuery<Carrera> query = em.createQuery("SELECT c FROM Carrera c", Carrera.class);
        return query.getResultList();
    }

    @Override 
    public List<CarreraInscriptosDTO> findAllConInscriptosOrderedByCantInscriptosDesc() {
        String jpql = "SELECT new universidad.dto.CarreraInscriptosDTO(" +
                        "c.nombre, c.id, COUNT(ec)) " +
                        "FROM Carrera c " +
                        "JOIN c.estudiantes ec " +
                        "GROUP BY c.id, c.nombre " +
                        "ORDER BY COUNT(ec) DESC";
        TypedQuery<CarreraInscriptosDTO> query = em.createQuery(jpql, CarreraInscriptosDTO.class);
        return query.getResultList();
    }
     @Override
    public List<ReporteCarreraDTO> getReporteCarreras() {
         String sql = "SELECT c.nombre AS carrera, datos.anio, " +
                 "COALESCE(SUM(datos.inscriptos), 0) AS total_inscriptos, " +
                 "COALESCE(SUM(datos.egresados), 0) AS total_egresados " +
                 "FROM Carrera c " +
                 "LEFT JOIN (" +
                 "  SELECT id_carrera, inscripcion AS anio, 1 AS inscriptos, 0 AS egresados " +
                 "  FROM EstudianteCarrera " +
                 "  UNION ALL " +
                 "  SELECT id_carrera, graduacion AS anio, 0 AS inscriptos, 1 AS egresados " +
                 "  FROM EstudianteCarrera " +
                 "  WHERE graduacion IS NOT NULL AND graduacion > 0 " +
                 ") datos ON c.id = datos.id_carrera " +
                 "GROUP BY c.id,c.nombre, datos.anio " +
                 "ORDER BY c.nombre ASC, datos.anio ASC";

         Query query = em.createNativeQuery(sql);
         @SuppressWarnings("unchecked")
         List<Object[]> resultados = query.getResultList();

         List<ReporteCarreraDTO> reporte = new ArrayList<>();
         for (Object[] fila : resultados) {
             String nombreCarrera = (String) fila[0];
             int anio = fila[1] != null ? ((Number) fila[1]).intValue() : 0;
             long cantidadInscriptos = fila[2] != null ? ((Number) fila[2]).longValue() : 0L;
             long cantidadEgresados = fila[3] != null ? ((Number) fila[3]).longValue() : 0L;

             // Instancia tu DTO exacto
             reporte.add(new ReporteCarreraDTO(nombreCarrera, anio, cantidadInscriptos, cantidadEgresados));
         }

         return reporte;
     }
}

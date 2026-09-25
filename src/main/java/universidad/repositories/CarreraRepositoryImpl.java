package universidad.repositories;
import universidad.dto.CarreraInscriptosDTO;
import universidad.dto.ReporteCarreraDTO;
import universidad.entity.Carrera;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    //TODO
   // @Override
    //public List<ReporteCarreraDTO> getReporteCarreras() {
      //  return List.of();
    //}
}

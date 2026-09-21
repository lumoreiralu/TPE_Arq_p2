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

    //TODO
    @Override
    public List<CarreraInscriptosDTO> getCarrerasConInscriptosOrdenadas() {
        return List.of();
    }
    //TODO
    @Override
    public List<ReporteCarreraDTO> getReporteCarreras() {
        return List.of();
    }
}

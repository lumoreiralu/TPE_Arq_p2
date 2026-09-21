package universidad.repositories;

import universidad.entity.Estudiante;

import javax.persistence.EntityManager;
import java.util.List;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private final EntityManager em;

    public EstudianteRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Estudiante save(Estudiante estudiante) {
        if(em.find(Estudiante.class, estudiante.getDni()) == null){
            em.persist(estudiante);
        }else{
            estudiante = em.merge(estudiante);
        }
        return estudiante;
    }

    @Override
    public Estudiante findByDni(Integer dni) {
        return em.find(Estudiante.class, dni);
    }

    //TODO
    //@Override
    //public List<Estudiante> findAllOrderedByApellido() {
    //    return List.of();
    //}

    //TODO
    //@Override
    //public Estudiante findByLU(int numLU) {
    //    return null;
    //}

    //TODO
    //@Override
    //public List<Estudiante> findByCarreraAndCiudad(Integer idCarrera, String ciudad) {
    //    return List.of();
    //}
}

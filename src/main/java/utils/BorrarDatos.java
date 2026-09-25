package utils;


import javax.persistence.EntityManager;

public class BorrarDatos {
    private final EntityManager em;

    public BorrarDatos(EntityManager em) {
        this.em = em;
    }

    public void run() {
        em.getTransaction().begin();
        try{
            em.createQuery("DELETE FROM EstudianteCarrera").executeUpdate();

            em.createQuery("DELETE FROM Carrera").executeUpdate();
            em.createQuery("DELETE FROM Estudiante").executeUpdate();
            
            em.createNativeQuery(
                "ALTER TABLE EstudianteCarrera AUTO_INCREMENT = 1").executeUpdate();
            em.createNativeQuery(
                "ALTER TABLE Carrera AUTO_INCREMENT = 1").executeUpdate();

            em.getTransaction().commit();
            System.out.println("Borrado completo finalizado con exito");
        } catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error al borrar masivamente", e);
        }
    }
}

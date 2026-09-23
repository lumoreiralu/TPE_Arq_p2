package universidad;

import universidad.factory.RepositoryFactory;
import universidad.repositories.CarreraRepository;
import universidad.repositories.EstudianteRepository;
import universidad.entity.Estudiante;
import utils.BorrarDatos;
import utils.CargarDatosIniciales;

import java.util.List;
import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        RepositoryFactory factory = RepositoryFactory.getInstance();
        EntityManager em = factory.getEntityManager();

        try{
            BorrarDatos borrarDatos = new BorrarDatos(em);
            borrarDatos.run();

            CargarDatosIniciales cargarDatosIniciales = new CargarDatosIniciales(em);
            cargarDatosIniciales.run();

            EstudianteRepository estudianteRepo = factory.getEstudianteRepository();
            CarreraRepository carreraRepo = factory.getCarreraRepository();

            // Prueba del punto d)
            Estudiante porLU = estudianteRepo.findByLU(34978);
            System.out.println("Buscado por LU 34978: " + porLU);

            // Prueba del punto e)
            List<Estudiante> mujeres = estudianteRepo.findByGenero("Female");
            System.out.println("Cantidad de estudiantes genero Female: " + mujeres.size());

        }catch (Exception e){
            e.printStackTrace();
        } finally{
            factory.close();
        }

    }

}

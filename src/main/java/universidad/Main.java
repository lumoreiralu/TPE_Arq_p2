package universidad;

import universidad.dto.CarreraInscriptosDTO;
import universidad.dto.EstudianteDTO;
import universidad.factory.RepositoryFactory;
import universidad.repositories.CarreraRepository;
import universidad.repositories.EstudianteRepository;
import universidad.entity.Carrera;
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

            // Prueba del punto C)
            List<Estudiante> estudiantesOrdenadosPorEdad = estudianteRepo.findAllOrderedByEdadAsc();
            System.out.println("Estudiantes ordenados por edad ascendente:");
            for (Estudiante estudiante : estudiantesOrdenadosPorEdad) {
                System.out.println(estudiante);
            } 



            // Prueba del punto d)
            Estudiante porLU = estudianteRepo.findByLU(34978);
            System.out.println("Buscado por LU 34978: " + porLU);

            // Prueba del punto e)
            List<Estudiante> mujeres = estudianteRepo.findByGenero("Female");
            System.out.println("Cantidad de estudiantes genero Female: " + mujeres.size());

            
            // Prueba del punto f)
            List<CarreraInscriptosDTO> carrerasConInscriptos = carreraRepo.findAllConInscriptosOrderedByCantInscriptosDesc();
            System.out.println("Carreras con inscriptos ordenadas por cantidad de inscriptos descendente:");
            for (CarreraInscriptosDTO dto : carrerasConInscriptos) {
                System.out.println(dto);
            }
                  

        }catch (Exception e){
            e.printStackTrace();
        } finally{
            factory.close();
        }

    }

}

package universidad;

import universidad.factory.RepositoryFactory;
import universidad.repositories.CarreraRepository;
import universidad.repositories.EstudianteRepository;
import utils.BorrarDatos;
import utils.CargarDatosIniciales;

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


        }catch (Exception e){
            e.printStackTrace();
        } finally{
            factory.close();
        }

    }

}

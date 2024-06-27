package Repository;

import Controller.EntrenadorController;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrenadorRepository extends JpaRepository<EntrenadorController, Long> {

     List<EntrenadorController> findByNombreContainingIgnoreCase(String nombre);
}

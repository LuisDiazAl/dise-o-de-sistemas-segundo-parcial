package Repository;

import Controller.EntrenadorController;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<EntrenadorController, Long> {
     EntrenadorController findByNombreIgnoreCase(String nombre);
}

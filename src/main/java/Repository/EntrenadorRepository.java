package Repository;

import Controller.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

     List<Entrenador> findByNombreContainingIgnoreCase(String nombre);
}

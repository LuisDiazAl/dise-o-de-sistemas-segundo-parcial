package Repository;

import Controller.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByPoderBetween(int minPoder, int maxPoder);
}

package Service;

import Controller.EntrenadorController;
import Controller.Pokemon;
import Repository.EntrenadorRepository;
import Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    public EntrenadorController crearEntrenador(EntrenadorController entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public EntrenadorController recuperarEntrenadorPorId(Long id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    public void capturarPokemon(Long entrenadorId, Pokemon pokemon) {
        EntrenadorController entrenador = entrenadorRepository.findById(entrenadorId).orElse(null);
        if (entrenador != null && entrenador.getPokemons().size() < 5) {
            pokemon.setEntrenador(entrenador);
            pokemonRepository.save(pokemon);
        }
    }

    public EntrenadorController enfrentarseA(Long entrenadorId, Long otroEntrenadorId) {
        EntrenadorController entrenador1 = entrenadorRepository.findById(entrenadorId).orElse(null);
        EntrenadorController entrenador2 = entrenadorRepository.findById(otroEntrenadorId).orElse(null);

        // Lógica de enfrentamiento aquí

        return null; // Devuelve el resultado del enfrentamiento
    }

    public List<EntrenadorController> buscarEntrenadoresPorNombre(String nombre) {
        return entrenadorRepository.findByNombreContainingIgnoreCase(nombre);
    }
}

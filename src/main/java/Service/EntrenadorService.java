package Service;

import Controller.Entrenador;
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

    public Entrenador crearEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador recuperarEntrenadorPorId(Long id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    public void capturarPokemon(Long entrenadorId, Pokemon pokemon) {
        Entrenador entrenador = entrenadorRepository.findById(entrenadorId).orElse(null);
        if (entrenador != null && entrenador.getPokemons().size() < 5) {
            pokemon.setEntrenador(entrenador);
            pokemonRepository.save(pokemon);
        }
    }

    public Entrenador enfrentarseA(Long entrenadorId, Long otroEntrenadorId) {
        Entrenador entrenador1 = entrenadorRepository.findById(entrenadorId).orElse(null);
        Entrenador entrenador2 = entrenadorRepository.findById(otroEntrenadorId).orElse(null);

        if (entrenador1 != null && entrenador2 != null) {
            //Crear metodos seleccionarPokemonAleatorio
            Pokemon pokemonEntrenador1 = seleccionarPokemonAleatorio(entrenador1);
            Pokemon pokemonEntrenador2 = seleccionarPokemonAleatorio(entrenador2);

            //Hay que hacer que reciba o cambiar a Static - Porque esta en un contexto non-Static un metodo static
            PokemonService.atacarPokemon(pokemonEntrenador1.getId(), pokemonEntrenador2.getId());


            entrenadorRepository.save(entrenador1);
            entrenadorRepository.save(entrenador2);

            return determinarGanador(entrenador1, entrenador2);
        }

        return null;
    }

    //Metodo que sirva para calcular la vida de los pokemones que se enfrentaron
    private Entrenador determinarGanador(Entrenador entrenador1, Entrenador entrenador2) {
        return entrenador1;
    }

    public List<Entrenador> buscarEntrenadoresPorNombre(String nombre) {
        return entrenadorRepository.findByNombreContainingIgnoreCase(nombre);
    }
}

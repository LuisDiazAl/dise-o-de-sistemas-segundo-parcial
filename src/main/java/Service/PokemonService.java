package Service;

import Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public Pokemon crearPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon recuperarPokemonPorId(Long id) {
        return pokemonRepository.findById(id).orElse(null);
    }

    public List<Pokemon> buscarPokemonsPorRangoDePoder(int minPoder, int maxPoder) {
        return pokemonRepository.findByPoderBetween(minPoder, maxPoder);
    }

    public void atacarPokemon(Long pokemonIdAtacante, Long pokemonIdAtacado) {
        Pokemon atacante = pokemonRepository.findById(pokemonIdAtacante).orElse(null);
        Pokemon atacado = pokemonRepository.findById(pokemonIdAtacado).orElse(null);

        if (atacante != null && atacado != null) {
            // Lógica de ataque aquí
        }
    }
}

package Service;

import Controller.Pokemon;
import Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PokemonService{

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
            int damage = calcularDanio(atacante.getPoder());

            atacado.restarVida(damage);

            pokemonRepository.save(atacado);
        }
    }


    //Faltan estos metodos que son parte del enunciado

    //void restarVida(Float cant);
    //void aumentarVida(Float vida);

    private int calcularDanio(int poder) {
        return poder;
    }

}

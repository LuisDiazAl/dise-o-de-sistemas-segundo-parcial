package Controller;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Pokemon {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String especie;
    private float vida;
    private int poder;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private EntrenadorController entrenador;
    

    public Pokemon(EntrenadorController entrenador) {
        this.entrenador = entrenador;
    }

    public Pokemon(String tipo, String especie, float vida, int poder, EntrenadorController entrenador) {
        this.tipo = tipo;
        this.especie = especie;
        this.vida = vida;
        this.poder = poder;
        this.entrenador = entrenador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void restarVida(int damage) {
    }

    public void setEntrenador(EntrenadorController entrenador) {
    }

}

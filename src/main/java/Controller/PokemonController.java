import Controller.EntrenadorController;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
public class Pokemon {

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

    // Constructor, getters y setters

    public Pokemon() {
    }

    public Pokemon(String tipo, String especie, float vida, int poder) {
        this.tipo = tipo;
        this.especie = especie;
        this.vida = vida;
        this.poder = poder;
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

    // Getters y setters omitidos para brevedad
}
